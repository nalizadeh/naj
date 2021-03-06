package org.naj.java.xml.jaxb;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.Marshaller;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;

import org.eclipse.persistence.descriptors.ClassDescriptor;
import org.eclipse.persistence.dynamic.DynamicEntity;
import org.eclipse.persistence.jaxb.dynamic.DynamicJAXBContext;
import org.eclipse.persistence.jaxb.dynamic.DynamicJAXBContextFactory;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 * See JAXB bindings by example:
 * https://coderleaf.wordpress.com/2016/11/15/jaxb-bindings-by-example/
 * 
 * 
 * https://wiki.eclipse.org/EclipseLink/Examples/MOXy/Dynamic
 * https://www.eclipse.org/eclipselink/documentation/2.5/solutions/jpatoxml006.htm
 * https://www.eclipse.org/eclipselink/documentation/2.5/moxy/dynamic_jaxb003.htm
 * 
 * https://stackoverflow.com/questions/7261322/jaxb-xjc-xpath-evaluation-results-in-empty-target-node
 * 
 * @author Admin
 *
 */
public class JaxbDyn1 {

	 static {
	        try {
	            System.setProperty("com.sun.tools.xjc.api.impl.s2j.SchemaCompilerImpl.noCorrectnessCheck", "true");
	        } catch (Exception e) {
	        }
	    }
	 
	public static void main(String[] args) throws Exception {
	      	
		FileInputStream xsdStream = new FileInputStream(
				"D:\\works\\workspace\\Kiss24\\src\\org\\naj\\java\\xml\\jaxb\\res\\customer2.xsd");
		Source xsdSource = new StreamSource(xsdStream);
		xsdSource.setSystemId("customer2.xsd");

		FileInputStream xjbStream1 = new FileInputStream(
				"D:\\works\\workspace\\Kiss24\\src\\org\\naj\\java\\xml\\jaxb\\res\\customer1.xjb");
		Source xjbSource1 = new StreamSource(xjbStream1);
		xjbSource1.setSystemId(xsdSource.getSystemId());

		List<Source> xjbFiles = new ArrayList<Source>(2);
		xjbFiles.add(xjbSource1);
		 
		// Put XSD and XJBs into Properties
		Map<String, Object> properties = new HashMap<String, Object>();
		properties.put(DynamicJAXBContextFactory.XML_SCHEMA_KEY, xsdSource);
		properties.put(DynamicJAXBContextFactory.EXTERNAL_BINDINGS_KEY, xjbFiles);

		DynamicJAXBContext jaxbContext = DynamicJAXBContextFactory.createContextFromXSD(xsdStream,
				new MyEntityResolver(), Thread.currentThread().getContextClassLoader(), properties);

		Collection<ClassDescriptor> descriptors = jaxbContext.getXMLContext().getSession().getDescriptors().values();
		for (ClassDescriptor desc : descriptors) {
			if (desc.getJavaClassName() != null) {
				System.out.println(desc.getJavaClassName());
			}
		}

		DynamicEntity newCustomer = jaxbContext.newDynamicEntity("example.Customer");
		DynamicEntity newAddress = jaxbContext.newDynamicEntity("addressnamespace.Address");

		newAddress.set("street", "227 Main St.");
		newAddress.set("city", "Toronto");
		newAddress.set("province", "Ontario");
		newAddress.set("postalCode", "M5V1E6");

		newCustomer.set("firstName", "George");
		newCustomer.set("lastName", "Jones");
		newCustomer.set("address", newAddress);
		
		Marshaller marshaller = jaxbContext.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		marshaller.setProperty(Marshaller.JAXB_NO_NAMESPACE_SCHEMA_LOCATION, "true");
		marshaller.marshal(newCustomer, System.out);
	}

	static class MyEntityResolver implements EntityResolver {
		
		public InputSource resolveEntity(String publicId, String systemId) throws SAXException, IOException {
			
			// Imported schemas are located in ext\appdata\xsd\

			// Grab only the filename part from the full path
			String filename = new File(systemId).getName();

			// Now prepend the correct path
			String correctedId = "D:\\works\\workspace\\Kiss24\\src\\org\\naj\\java\\xml\\jaxb\\res\\" + filename;

			InputSource is = new InputSource(ClassLoader.getSystemResourceAsStream(correctedId));
			is.setSystemId(correctedId);

			return is;
		}
	}
}
