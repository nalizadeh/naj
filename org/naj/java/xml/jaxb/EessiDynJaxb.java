package org.naj.java.xml.jaxb;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

import org.eclipse.persistence.descriptors.ClassDescriptor;
import org.eclipse.persistence.dynamic.DynamicType;
import org.eclipse.persistence.exceptions.DynamicException;
import org.eclipse.persistence.internal.dynamic.DynamicTypeImpl;
import org.eclipse.persistence.jaxb.dynamic.DynamicJAXBContext;
import org.eclipse.persistence.jaxb.dynamic.DynamicJAXBContextFactory;
import org.eclipse.persistence.oxm.annotations.XmlNameTransformer;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 * https://wiki.eclipse.org/EclipseLink/Examples/MOXy/Dynamic
 * https://www.eclipse.org/eclipselink/documentation/2.5/solutions/jpatoxml006.htm
 * https://www.eclipse.org/eclipselink/documentation/2.5/moxy/dynamic_jaxb003.htm
 * https://wiki.eclipse.org/EclipseLink/Examples/MOXy
 * 
 * @author P203125
 *
 */
@XmlNameTransformer(EessiDynJaxb.NameGenerator.class)
public class EessiDynJaxb {

	static {
		try {
			// System.setProperty("javax.xml.bind.context.factory",
			// "org.eclipse.persistence.jaxb.dynamic.DynamicJAXBContextFactory");
			System.setProperty("com.sun.tools.xjc.api.impl.s2j.SchemaCompilerImpl.noCorrectnessCheck", "true");
		} catch (Exception e) {
		}
	}

	private final MyEntityResolver resolver;
	private final List<String> types = new ArrayList<String>();
	
	public EessiDynJaxb(String baseDir) {
		resolver = new MyEntityResolver(baseDir);
	}
	
	public List<JaxBNodeObject> generateTypes(String path) throws Exception {
		FileInputStream xsdStream = new FileInputStream(resolver.getStream(path));
		DynamicJAXBContext jaxbContext = DynamicJAXBContextFactory.createContextFromXSD(xsdStream, resolver, null, null);
		Collection<ClassDescriptor> descriptors = jaxbContext.getXMLContext().getSession().getDescriptors().values();
		
		List<JaxBNodeObject> result = new ArrayList<JaxBNodeObject>();
		
		for (ClassDescriptor desc : descriptors) {
			if (desc.getJavaClassName() != null) {
				String ls = desc.getJavaClassName();
				JaxBNodeObject jo = new JaxBNodeObject(ls.substring(ls.lastIndexOf(".") + 1), ls);
				traverseProps(jaxbContext, jaxbContext.getDynamicType(ls), jo);
				result.add(jo);
			}
		}
		return result;
	}
	
	/**
	 * 
	 * @param c
	 * @param e
	 * @param t
	 * @param level
	 * @throws DynamicException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * 
	 * https://stackoverflow.com/questions/61821462/exception-description-dynamicentity-cannot-set-org-eclipse-persistence-oxm-m
	 * 
	 * https://wiki.eclipse.org/EclipseLink/Examples/MOXy/JAXB/Runtime
	 * 
	 */
	private void traverseProps(DynamicJAXBContext c, DynamicType t, JaxBNodeObject jo)
			throws DynamicException, InstantiationException, IllegalAccessException {
		if (t != null) {
			jo.subs = new ArrayList<JaxBNodeObject>();
			
			for (String pName : t.getPropertiesNames()) {
				Class<?> clazz = t.getPropertyType(pName);			

				if (clazz == null) {
					ClassDescriptor o = ((DynamicTypeImpl)t).getMapping(pName).getReferenceDescriptor();
					if (o != null) {
						DynamicType child = c.getDynamicType(o.getAlias());
						if (!types.contains(child.getClassName())) {
							types.add(child.getClassName());
							JaxBNodeObject co = new JaxBNodeObject(pName, child.getClassName());
							traverseProps(c, child, co);
							jo.subs.add(co);
						}
					}
				}
				else {
					JaxBNodeObject co = new JaxBNodeObject(pName, clazz.getTypeName());
					jo.subs.add(co);
				}
			}
		}
	}

	/**
	 * 
	 * @author Admin
	 *
	 */
	static class MyEntityResolver implements EntityResolver {

		private final String baseDir;
		private List<String> jaxbConflicts;
		
		public MyEntityResolver(String baseDir) {
			this.baseDir = baseDir;
			this.jaxbConflicts = new ArrayList<String>();
		}
		
		public InputSource resolveEntity(String publicId, String systemId) throws SAXException, IOException {
			return getSource(systemId);
		}

		private InputSource getSource(String path) throws SAXException, IOException {
			String filename = new File(path).getName();
			String correctedId = baseDir + "/" + filename;
			if (!new File(correctedId).exists()) {
				correctedId = baseDir + "/sbd/" + filename;
				if (!new File(correctedId).exists()) {
					correctedId = baseDir + "/sbdh/" + filename;
					if (!new File(correctedId).exists()) {
						correctedId = baseDir + "/sed/" + filename;
						if (!new File(correctedId).exists()) {
							correctedId = baseDir + "/transactions/" + filename;
							if (!new File(correctedId).exists()) {
								return null;
							}
						}
					}
				}
			}
			
			String dstPath = getStream(correctedId);			
			InputSource is = new InputSource(ClassLoader.getSystemResourceAsStream(dstPath));
			is.setSystemId(dstPath);

			return is;
		}

		private String getStream(String path) throws IOException {

			String filename = new File(path).getName();
			
			jaxbConflicts.add(filename);

			StringBuffer sb = new StringBuffer();
			try (Stream<String> lines = Files.lines(Paths.get(path), StandardCharsets.UTF_8)) {
				lines.forEachOrdered(line -> analyseLine(sb, line));
			}
			
			String dstPath = baseDir + "/tmp/" + filename;
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(new File(dstPath)), StandardCharsets.UTF_8));
			
			writer.write(sb.toString());
			writer.close();
			return dstPath;
		}
		
		private void analyseLine(StringBuffer sb, String line) {
			if (line.contains(":import ") || line.contains(":include ") || line.contains(":redefine ")) {
				String s = line.substring(line.indexOf("schemaLocation"));
				s = fromChar(s, "\"", false);
				s = fromChar(s, "'", false);
				s = toChar(s, "\"", false);
				s = toChar(s, "'", false);
				s = fromChar(s, "/", true);
				if (!jaxbConflicts.contains(s)) {
					jaxbConflicts.add(s);
					sb.append(line + "\r\n");
				}
				return;
			}
			sb.append(line+ "\r\n");
		}
		
		private String fromChar(String str, String ch, boolean last) {
			int n = last ? str.lastIndexOf(ch) : str.indexOf(ch);
			if (n != -1) {
				return str.substring(n + 1);
			}
			return str;
		}

		private String toChar(String str, String ch, boolean last) {
			int n = last ? str.lastIndexOf(ch) : str.indexOf(ch);
			if (n != -1) {
				return str.substring(0, n);
			}
			return str;
		}
	}
	
	static class NameGenerator implements org.eclipse.persistence.oxm.XMLNameTransformer {
		 
	    //Use the unqualified class name as our root element name.
	    public String transformRootElementName(String name) {
	        return name.substring(name.lastIndexOf('.') + 1);
	    }
	 
	    //The same algorithm as root element name plus "Type" appended to the end.
	    public String transformTypeName(String name) {
	        return transformRootElementName(name) + "Type";
	    }
	 
	    //The name will be lower case with word breaks represented by '-'.  
	    //Note:  A capital letter in the original name represents the start of a new word.
	    public String transformElementName(String name) {
	        StringBuilder strBldr = new StringBuilder();
	        for(char character : name.toCharArray()) {
	            if(Character.isUpperCase(character)) {
	                strBldr.append('-');
	                strBldr.append(Character.toLowerCase(character));
	            } else {
	                strBldr.append(character);
	            }
	         }
	        return strBldr.toString();
	    }
	 
	    //The original name converted to upper case.
	    public String transformAttributeName(String name) {
	        return name.toUpperCase();
	    }
	}
	
	public static class JaxBNodeObject {
		public final String name;
		public final String pkg;
		public List<JaxBNodeObject> subs;
		
		public JaxBNodeObject(String name, String pkg) {
			this.name = name;
			this.pkg = pkg;
		}
	}
	
	
	public static void main(String[] args) throws Exception {

		new EessiDynJaxb("D:\\works\\workspace\\Kiss24\\src\\org\\naj\\java\\xml\\jaxb\\res\\eessi\\generiert").generateTypes(
				// "D:/works/workspace/Kiss24/src/org/naj/java/xml/jaxb/res/eessi/S_BUC_19b-3.0-CaseOwner-Counterparty-Start-S080NAF-3.0.xsd");
				// "D:/works/workspace/Kiss24/src/org/naj/java/xml/jaxb/res/eessi/CC-4.2.xsd"
				// "D:/works/workspace/Kiss24/src/org/naj/java/xml/jaxb/res/eessi/ASec-4.2.xsd"
				// "D:/works/workspace/Kiss24/src/org/naj/java/xml/jaxb/res/eessi/SSec-4.2.xsd"
				// "D:/works/workspace/Kiss24/src/org/naj/java/xml/jaxb/res/eessi/SSecNat-3.0.xsd"
				// "D:/works/workspace/Kiss24/src/org/naj/java/xml/jaxb/res/eessi/XSec-4.2.xsd"
				// "D:/works/workspace/Kiss24/src/org/naj/java/xml/jaxb/res/eessi/xmldsig-core-schema.xsd"
				// "D:/works/workspace/Kiss24/src/org/naj/java/xml/jaxb/res/eessi/XAdES.xsd"
				// "D:/works/workspace/Kiss24/src/org/naj/java/xml/jaxb/res/eessi/S080NAF-4.0.xsd"
				// "D:/works/workspace/Kiss24/src/org/naj/java/xml/jaxb/res/eessi/SBD-S080NAF-4.0.xsd"
				// "D:/works/workspace/Kiss24/src/org/naj/java/xml/jaxb/res/eessi/S_BUC_19b-3.0-CaseOwner-Counterparty-Start-S080NAF-3.0.xsd"
				
				// "D:/works/Eessi/generiert/4.2.0_4.0.1/sbd/SBD-S080NAF-4.0.xsd"
				"D:/works/Eessi/generiert/4.2.0_4.0.1/transactions/S_BUC_19a-4.0-Counterparty-CaseOwner-New-S080NA-4.0.0.xsd"
		);
	}

}
