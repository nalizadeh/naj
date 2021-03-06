/*--- (C) 1999-2020 Techniker Krankenkasse ---*/

package org.naj.java.xml;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.apache.xerces.dom.DOMInputImpl;
import org.apache.xerces.dom.DOMXSImplementationSourceImpl;
import org.apache.xerces.impl.xs.XMLSchemaLoader;
import org.apache.xerces.xs.StringList;
import org.apache.xerces.xs.XSComplexTypeDefinition;
import org.apache.xerces.xs.XSConstants;
import org.apache.xerces.xs.XSElementDeclaration;
import org.apache.xerces.xs.XSImplementation;
import org.apache.xerces.xs.XSLoader;
import org.apache.xerces.xs.XSModel;
import org.apache.xerces.xs.XSModelGroup;
import org.apache.xerces.xs.XSModelGroupDefinition;
import org.apache.xerces.xs.XSNamedMap;
import org.apache.xerces.xs.XSObject;
import org.apache.xerces.xs.XSObjectList;
import org.apache.xerces.xs.XSParticle;
import org.apache.xerces.xs.XSTerm;
import org.apache.xerces.xs.XSTypeDefinition;
import org.apache.xmlbeans.SchemaAnnotation;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SchemaTypeSystem;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.impl.xsd2inst.SampleXmlUtil;
import org.apache.xmlbeans.impl.xsd2inst.SchemaInstanceGenerator;
import org.w3c.dom.ls.LSInput;
import org.w3c.dom.ls.LSResourceResolver;

/**
 * @author P203125
 *
 */
public class JXsdToXml {

	/**
	 * Specifies if network downloads are enabled for imports and includes. Default
	 * value is {@code false}
	 */
	private static final boolean ENABLE_NETWORK_DOWNLOADS = true;

	/**
	 * disable particle valid (restriction) rule Default value is {@code false}
	 */
	private static final boolean NO_PVR = false;

	/**
	 * disable unique particle attribution rule. Default value is {@code false}
	 */
	private static final boolean NO_UPA = false;

	/**
	 * head line in the generated xml file
	 */
	private static final String XML_VERS = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";

	/**
	 * The root path where xsds are located
	 */
	private final String basePath;
	/**
	 * XSD as String
	 */
	private final String xsdString;

	/**
	 * XML as String
	 */
	private String xmlString;

	/**
	 * File resolver
	 */
	private FileResolver resolver;

	/**
	 * Constructor
	 *
	 * @param basePath
	 * @param xsdFile
	 */
	public JXsdToXml(String basePath, String xsdFile) {
		this.basePath = basePath;
		this.resolver = new FileResolver(basePath);
		this.xsdString = readXsdFile(resolver, xsdFile);
	}

	/**
	 * Generator
	 *
	 * @param elementToGenerate
	 * @param nsMap
	 *
	 * @return String
	 */
	public final String generateXmlInstance(String elementToGenerate, Map<String, String> nsMap) {
		XmlObject schema = getSchema(xsdString);
		SchemaTypeSystem schemaTypeSystem = getSchemaTypeSystem(schema, nsMap);
		xmlString = generateXmlInstance(schemaTypeSystem.documentTypes(), elementToGenerate);
		return xmlString; 
	}

	/**
	 * 
	 * @param xsAsString
	 * 
	 * @return XmlObject
	 */
	private final XmlObject getSchema(String xsAsString) {
		List<XmlObject> schemaXmlObjects = new ArrayList<>();
		try {
			schemaXmlObjects.add(XmlObject.Factory.parse(xsAsString));
		} catch (XmlException e) {
			e.printStackTrace();
			System.out.println("Error Occured while Parsing Schema");
		}
		return schemaXmlObjects.isEmpty() ? null : schemaXmlObjects.get(0);
	}

	/**
	 * 
	 * @param schema
	 * 
	 * @return SchemaTypeSystem
	 * @return nsMap
	 */
	private final SchemaTypeSystem getSchemaTypeSystem(XmlObject schema, Map<String, String> nsMap) {

		SchemaInstanceGenerator.Xsd2InstOptions options = new SchemaInstanceGenerator.Xsd2InstOptions();
		options.setNetworkDownloads(ENABLE_NETWORK_DOWNLOADS);
		options.setNopvr(NO_PVR);
		options.setNoupa(NO_UPA);

		SchemaTypeSystem schemaTypeSystem = null;

		XmlOptions compileOptions = new XmlOptions();
		
		if (options.isNetworkDownloads()) {
			compileOptions.setCompileDownloadUrls();
		}
		if (options.isNopvr()) {
			compileOptions.setCompileNoPvrRule();
		}
		if (options.isNoupa()) {
			compileOptions.setCompileNoUpaRule();
		}

		if (nsMap != null) {
			compileOptions.setLoadSubstituteNamespaces(nsMap);
		    compileOptions.setLoadAdditionalNamespaces(nsMap);
		    compileOptions.setSaveImplicitNamespaces(nsMap);

			Map<String, String> nm = new TreeMap<String, String>();
			for (String key : nsMap.keySet()) {
				nm.put(nsMap.get(key), key);
			}
			compileOptions.setSaveSuggestedPrefixes(nm);
		}


//		compileOptions.setCompileSubstituteNames();

        compileOptions.setSavePrettyPrint()
        .setSavePrettyPrintIndent(4)
        .setUseDefaultNamespace()
        .setSaveAggressiveNamespaces()
        .setLoadLineNumbers()
        .setLoadMessageDigest();
//	    compileOptions.setSaveNamespacesFirst();
//      compileOptions.setCompileDownloadUrls();
//      compileOptions.setSaveSaxNoNSDeclsInAttributes();


		compileOptions.setValidateOnSet();

		try {
			schemaTypeSystem = XmlBeans.compileXsd(new XmlObject[] { schema }, XmlBeans.getBuiltinTypeSystem(),
					compileOptions);
		} catch (XmlException e) {
			e.printStackTrace();
			System.out.println("Error occurred while compiling XSD");
		}

		if (schemaTypeSystem == null) {
			throw new RuntimeException("No Schemas to process.");
		}
		return schemaTypeSystem;
	}

	/**
	 * @param globalElements
	 * @param rootElement
	 *
	 * @return String xml
	 */
	private final String generateXmlInstance(SchemaType[] globalElements, String rootElement) {
		SchemaType elem = null;
		for (SchemaType globalElement : globalElements) {
			if (rootElement.equals(globalElement.getDocumentElementName().getLocalPart())) {
				elem = globalElement;
				break;
			}
		}
		if (elem == null) {
			throw new RuntimeException("Could not find a global element with name \"" + rootElement + "\"");
		}

		// Now generate it and return the result
		return XML_VERS + SampleXmlUtil.createSampleForType(elem);
	}

	/**
	 * @return String[] globalElements
	 */
	public final String[] getGlobalElements() {
		XmlObject schema = getSchema(xsdString);
		SchemaTypeSystem schemaTypeSystem = getSchemaTypeSystem(schema, null);
		SchemaType[] globalElements = schemaTypeSystem.documentTypes();

		List<String> elems = new ArrayList<String>();
		for (SchemaType globalElement : globalElements) {
			elems.add(globalElement.getDocumentElementName().getLocalPart());
		}

		return elems.toArray(new String[elems.size()]);
	}

	/**
	 * 
	 * @return Map<String, String>
	 */
	public final Map<String, String> getNamespaces() {

		Map<String, String> nsMap = new TreeMap<String, String>();

		XmlObject schema = getSchema(xsdString);
		SchemaTypeSystem schemaTypeSystem = getSchemaTypeSystem(schema, null);
		SchemaType[] globals = schemaTypeSystem.globalTypes();

		// find default namespace
		XmlCursor cursor = schema.newCursor();
		if (!cursor.isContainer()) {
			cursor.toParent();
		} else {
			cursor.toStartDoc();
		}
		if (cursor.toFirstChild()) {
			String ns = cursor.namespaceForPrefix("");
			if (ns != null && !ns.isEmpty()) {
				nsMap.put(ns, "xmlns:");
			}
		}
		cursor.dispose();

		// find other namespaces
		for (SchemaType st : globals) {

//			if (st.getBaseType() != null) {
//				nsMap.put(st.getBaseType().getName().getNamespaceURI(), st.getName().getLocalPart());
//			}
//			nsMap.put(st.getName().getNamespaceURI(), st.getName().getLocalPart());

//			if (st.getAttributeModel() != null) {
//		    SchemaLocalAttribute[] attributes = st.getAttributeModel().getAttributes();
//		    for (SchemaLocalAttribute at : attributes) {
//				System.out.println(at.getName().getLocalPart() + ":" + at.getName().getNamespaceURI());
//		    }
//			}

			SchemaAnnotation an = st.getAnnotation();
			if (an != null) {
				XmlObject[] ui = an.getUserInformation();
				for (XmlObject userInfo : ui) {

					cursor = userInfo.newCursor();
					cursor.toFirstChild();
					String xs = cursor.xmlText();
					JXml xml = new JXml(xs);
					Map<String, String> ms = new TreeMap<String, String>();
					xml.getAttributesMap(ms);
					for (String k : ms.keySet()) {
						String v = ms.get(k);
						if (v.startsWith("xmlns")) {
							v = v.indexOf(":") == -1 ? "" : v.substring(v.indexOf(":") + 1);
							nsMap.put(k, v);
						}
					}
				}
			}
		}

		Map<String, String> nsMapRev = new TreeMap<String, String>();
		for (String key : nsMap.keySet()) {
			nsMapRev.put(nsMap.get(key), key);
			//System.out.println(nsMap.get(key) + "=" + key);
		}
		return nsMapRev;
	}

	/**
	 * @param path
	 * @param file
	 *
	 * @return String
	 */
	private final String readXsdFile(FileResolver resolver, String file) {
		StringBuffer sb = new StringBuffer();
		try {
			String fn = resolver.resolve(file);
			BufferedReader br = new BufferedReader(new FileReader(fn));
			for (String line; (line = br.readLine()) != null;) {
				if (line.contains("schemaLocation=\"")) {
					String ln1 = line.substring(line.indexOf("schemaLocation=\"") + 16);
					String ln2 = ln1.substring(0, ln1.indexOf("\""));
					fn = resolver.resolve(ln2);
					line = line.replace("schemaLocation=\"" + ln2, "schemaLocation=\"file:///" + fn);
				}
				sb.append(line + System.lineSeparator());
			}
			br.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return sb.toString();
	}

	/**
	 * 
	 * @param schema
	 * @return boolean
	 */
	public boolean validateSchema(XmlObject schema) {
		List<String> validationErrors = new ArrayList<String>();
		XmlOptions validationOptions = new XmlOptions();
		validationOptions.setErrorListener(validationErrors);
		boolean isValid = schema.validate(validationOptions);

		if (!isValid) {
			Iterator<String> iter = validationErrors.iterator();
			while (iter.hasNext()) {
				System.out.println(">> " + iter.next() + "\n");
			}
		}
		return isValid;
	}

	public void validate() throws Exception {
		validateXml(xsdString, xmlString, basePath);
	}

	/**
	 * 
	 * @param xmlStr
	 * @param schemaStr
	 * @param basePath
	 */
	public static void validateXml(String schemaStr, String xmlStr, String basePath) throws Exception {
		try {
			Source schemaSource = new StreamSource(new ByteArrayInputStream(schemaStr.getBytes(StandardCharsets.UTF_8)));
			Source xmlSource = new StreamSource(new ByteArrayInputStream(xmlStr.getBytes(StandardCharsets.UTF_8)));
			validate(schemaSource, xmlSource, basePath);
			System.out.println(xmlSource.getSystemId() + " is valid");
		} catch (Exception e) {
			System.out.println("XML is NOT valid reason:" + e);
			throw e;
		}
	}

	/**
	 * 
	 * @param xmlFilename
	 * @param schemaFilename
	 * @param basePath
	 */
	public static void validateXmlFile(String xmlFilename, String schemaFilename, String basePath) throws Exception {
		try {
			Source xmlFile = new StreamSource(new File(xmlFilename));
			Source schemaFile = new StreamSource(new File(schemaFilename));
			validate(schemaFile, xmlFile, basePath);
			System.out.println(xmlFile.getSystemId() + " is valid");
		} catch (Exception e) {
			System.out.println(xmlFilename + " is NOT valid reason:" + e);
			throw e;
		}
	}

	/**
	 * 
	 * @param schemaSource
	 * @param xmlSource
	 * @param basePath
	 * @throws Exception
	 */
	private static void validate(Source schemaSource, Source xmlSource, String basePath) throws Exception {
		SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		schemaFactory.setResourceResolver(new ResourceResolver(basePath));
		Schema schema = schemaFactory.newSchema(schemaSource);
		Validator validator = schema.newValidator();
		validator.validate(xmlSource);
	}

	private static class FileResolver {

		private String basePath;

		public FileResolver(String basePath) {
			this.basePath = basePath;
		}

		public String resolve(String name) throws IOException {
			String filename = new File(name).getName();
			String correctedId = basePath + "\\" + filename;
			if (!new File(correctedId).exists()) {
				correctedId = basePath + "\\transactions\\" + filename;
				if (!new File(correctedId).exists()) {
					correctedId = basePath + "\\sbdh\\" + filename;
					if (!new File(correctedId).exists()) {
						correctedId = basePath + "\\sed\\" + filename;
						if (!new File(correctedId).exists()) {
							throw new IOException("File " + name + " not found.");
						}
					}
				}
			}
			return correctedId;
		}
	}

	private static class ResourceResolver implements LSResourceResolver {

		private String basePath;

		public ResourceResolver(String basePath) {
			this.basePath = basePath;
		}

		@Override
		public LSInput resolveResource(String type, String namespaceURI, String publicId, String systemId,
				String baseURI) {

			String filename = new File(systemId).getName();
			String correctedId = basePath + "\\national\\sbdh\\" + filename;

			if (!new File(correctedId).exists()) {
				correctedId = basePath + "\\national\\sed\\" + filename;
			}
			try {
				InputStream resourceAsStream = new FileInputStream(new File(correctedId));
				Objects.requireNonNull(resourceAsStream,
						String.format("Could not find the specified xsd file: %s", systemId));
				return new DOMInputImpl(publicId, systemId, baseURI, resourceAsStream, "UTF-8");
			} catch (Exception ex) {
				return null;
			}
		}
	}

	// ========================================================
	// org.apache.xerces
	// ========================================================

	/**
	 * 
	 * @param xsdFile
	 * @return StringList
	 */
	public static StringList getNamespaces(String xsdFile) {
		XMLSchemaLoader loader = new XMLSchemaLoader();
		XSModel model = loader.loadURI(new File(xsdFile).toURI().toString());
		return model.getNamespaces();
	}

	/**
	 * 
	 * @param xsdFile
	 * @param nsMap
	 */
	public static void getComponents(String xsdFile, Map<String, String> nsMap) {
		XMLSchemaLoader loader = new XMLSchemaLoader();
		XSModel model = loader.loadURI(new File(xsdFile).toURI().toString());
		XSNamedMap map = model.getComponents(XSConstants.TYPE_DEFINITION);
		for (int j = 0; j < map.getLength(); j++) {
			XSObject o = map.item(j);
			nsMap.put(o.getName(), o.getNamespace());
		}
	}

	/**
	 * 
	 * @param xsdFile
	 * @param nsMap
	 */
	public Map<String, String> getComponents() {
		Map<String, String> nsMap = new TreeMap<String, String>();
		XMLSchemaLoader loader = new XMLSchemaLoader();
		InputStream stream = new ByteArrayInputStream(xsdString.getBytes(StandardCharsets.UTF_8));
		LSInput input = new DOMInputImpl();
		input.setByteStream(stream);
		XSModel xsModel = loader.load(input);
		XSNamedMap xsMap = xsModel.getComponents(XSConstants.TYPE_DEFINITION);
		// model.getComponentsByNamespace(XSConstants.ELEMENT_DECLARATION, ns)
		for (int j = 0; j < xsMap.getLength(); j++) {
			XSObject o = xsMap.item(j);
			nsMap.put(o.getName(), o.getNamespace());
		}
		xsMap = xsModel.getComponents(XSConstants.ELEMENT_DECLARATION);
		return nsMap;
	}

	//==================================
	
	private void loadSchema(String xsdURI) {
		XSImplementation impl = (XSImplementation)
				(new DOMXSImplementationSourceImpl()).getDOMImplementation ("XS-Loader");

		XSLoader schemaLoader = impl.createXSLoader(null);
		XSModel xsModel = schemaLoader.loadURI(xsdURI);
		processXSModel(xsModel);
	}

	/**
	 * Process schema content
	 */
	private void processXSModel(XSModel xsModel) {
		XSNamedMap xsMap;

		// process model group definitions
		xsMap = xsModel.getComponents(XSConstants.MODEL_GROUP_DEFINITION);
		for (int i = 0; i < xsMap.getLength(); i++) {
			XSModelGroupDefinition xsGroupDef = (XSModelGroupDefinition) xsMap.item(i);
			XSModelGroup xsGroup = xsGroupDef.getModelGroup();
		}

		// process top-level type definitions
		xsMap = xsModel.getComponents(XSConstants.TYPE_DEFINITION);
		for (int i = 0; i < xsMap.getLength(); i++) {
			XSTypeDefinition xsTDef = (XSTypeDefinition) xsMap.item(i);
			processXSTypeDef(xsTDef);
		}

		// process top-level element declarations
		xsMap = xsModel.getComponents(XSConstants.ELEMENT_DECLARATION);
		for (int i = 0; i < xsMap.getLength(); i++) {
			XSElementDeclaration xsElementDecl = (XSElementDeclaration) xsMap.item(i);
			// processXSElementDecl (xsElementDecl);
		}
	}

	/**
	 * Process type definition
	 */
	private void processXSTypeDef(XSTypeDefinition xsTDef) {
		switch (xsTDef.getTypeCategory()) {
		case XSTypeDefinition.SIMPLE_TYPE:

			// processXSSimpleType ((XSSimpleTypeDefinition) xsTDef);
			break;

		case XSTypeDefinition.COMPLEX_TYPE:

			XSComplexTypeDefinition xsCTDef = (XSComplexTypeDefinition) xsTDef;

			// element's attributes
			XSObjectList xsAttrList = xsCTDef.getAttributeUses();
			for (int i = 0; i < xsAttrList.getLength(); i++) {
				// processXSAttributeUse ((XSAttributeUse) xsAttrList.item (i));
			}

			// element content
			switch (xsCTDef.getContentType()) {
			case XSComplexTypeDefinition.CONTENTTYPE_EMPTY:

				break;

			case XSComplexTypeDefinition.CONTENTTYPE_SIMPLE:

				// parseValueType (xsCTDef.getSimpleType());
				break;

			case XSComplexTypeDefinition.CONTENTTYPE_ELEMENT:

				processXSParticle(xsCTDef.getParticle());
				break;

			case XSComplexTypeDefinition.CONTENTTYPE_MIXED:

				processXSParticle(xsCTDef.getParticle());
				break;
			}
		}
	}

	/**
	 * Process particle
	 */
	private void processXSParticle(XSParticle xsParticle) {
		XSTerm xsTerm = xsParticle.getTerm();
		switch (xsTerm.getType()) {
		case XSConstants.ELEMENT_DECLARATION:

			// processXSElementDecl ((XSElementDeclaration) xsTerm);
			break;

		case XSConstants.MODEL_GROUP:

			// this is one of the globally defined groups
			// (found in top-level declarations)

			XSModelGroup xsGroup = (XSModelGroup) xsTerm;

			// it also consists of particles
			XSObjectList xsParticleList = xsGroup.getParticles();
			for (int i = 0; i < xsParticleList.getLength(); i++) {
				processXSParticle((XSParticle) xsParticleList.item(i));
			}
			break;

		case XSConstants.WILDCARD:

			break;
		}
	}

	public static void main(String[] args) {

		try {
			JXsdToXml.validateXmlFile("D:\\works\\Eessi\\SBD-S080NAF-3.0.xml",
				"D:\\works\\Eessi\\4.2.0_3.0.0\\national\\transactions\\S_BUC_19b-3.0-CaseOwner-Counterparty-Start-S080NAF-3.0.xsd",
				"D:\\works\\Eessi\\4.2.0_3.0.0\\");
		} catch(Exception e) {
			
		}
		
		JXsdToXml gen = new JXsdToXml("D:\\works\\Eessi\\4.2.0_3.0.0",
				"S_BUC_19b-3.0-CaseOwner-Counterparty-Start-S080NAF-3.0.xsd");

//      String xsd =
//          "<xs:schema attributeFormDefault=\"unqualified\" elementFormDefault=\"qualified\" xmlns:xs=\"http://www.w3.org/2001/XMLSchema\">\r\n"
//          + "<xs:element name=\"Employee\"><xs:complexType><xs:sequence><xs:element type=\"xs:string\" name=\"name\"/><xs:element type=\"xs:byte\" name=\"age\"/>\r\n"
//          + "<xs:element type=\"xs:string\" name=\"role\"/><xs:element type=\"xs:string\" name=\"gender\"/></xs:sequence></xs:complexType></xs:element></xs:schema>";
//      System.out.println(gen.generateXmlInstance(xsd, "Employee"));

		// "C:\\SPU\\pwe\\kiss24Manager\\kiss24Manager\\git-repos\\diverse\\org\\naj\\java\\xml\\test2.xsd"
		// "X:\\Projekte\\EESSI_EU-Datenaustausch\\Staging\\4.2.0_3.0.0\\national\\transactions\\S_BUC_19b-3.0-CaseOwner-Counterparty-Start-S080NAF-3.0.xsd"

		// System.out.println(xsd2);
		System.out.println(gen.generateXmlInstance("StandardBusinessDocument", null));

//      String xsd3 =
//          gen.readXmlFile(
//              "X:\\Projekte\\EESSI_EU-Datenaustausch\\Staging\\4.2.0_3.0.0\\national\\transactions\\S_BUC_19b-3.0-CaseOwner-Counterparty-Start-S080NAF-3.0.xsd"
//          );
//      System.out.println(xsd3);
//      System.out.println(gen.generateXmlInstance(xsd3, "StandardBusinessDocument"));
	}
}

/*--- Formatiert nach TK Code Konventionen vom 05.03.2002 ---*/
