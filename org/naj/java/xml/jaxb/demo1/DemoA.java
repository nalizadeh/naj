package org.naj.java.xml.jaxb.demo1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collection;

import javax.xml.bind.Marshaller;

import org.eclipse.persistence.descriptors.ClassDescriptor;
import org.eclipse.persistence.dynamic.DynamicEntity;
import org.eclipse.persistence.jaxb.dynamic.DynamicJAXBContext;
import org.eclipse.persistence.jaxb.dynamic.DynamicJAXBContextFactory;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 * https://wiki.eclipse.org/EclipseLink/Examples/MOXy/Dynamic
 * https://www.eclipse.org/eclipselink/documentation/2.5/solutions/jpatoxml006.htm
 * https://www.eclipse.org/eclipselink/documentation/2.5/moxy/dynamic_jaxb003.htm
 * 
 * @author Admin
 *
 */
import java.io.FileInputStream;

import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.eclipse.persistence.dynamic.DynamicEntity;
import org.eclipse.persistence.dynamic.DynamicType;
import org.eclipse.persistence.jaxb.dynamic.DynamicJAXBContext;
import org.eclipse.persistence.jaxb.dynamic.DynamicJAXBContextFactory;

public class DemoA {

    public static void main(String[] args) throws Exception {
        final DynamicJAXBContext jaxbContext = DynamicJAXBContextFactory.createContextFromXSD(DemoA.class.getResourceAsStream("xsd/customer.xsd"),
                new MyEntityResolver(), null, null);
        final FileInputStream xmlInputStream = new FileInputStream("src/org/naj/java/xml/jaxb/demo1/customer.xml");
        final Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        final DynamicEntity customer = (DynamicEntity) unmarshaller.unmarshal(xmlInputStream);
        System.out.println(customer.<String> get("name"));
        final DynamicType addressType = jaxbContext.getDynamicType("org.example.address.Address");
        final DynamicEntity address = customer.<DynamicEntity> get("address");
        
        for ( final String propertyName : addressType.getPropertiesNames() ) {
            System.out.println((String)address.get(propertyName));
        }
        
        test();
    }

    public static void test() throws JAXBException {
        final DynamicJAXBContext jaxbContext = DynamicJAXBContextFactory.createContextFromXSD(DemoA.class.getResourceAsStream("xsd/customer.xsd"),
                new MyEntityResolver(), null, null);
        DynamicEntity customer = jaxbContext.newDynamicEntity("org.example.customer.Customer");
        customer.set("name", "Jane Doe");
        DynamicEntity address = jaxbContext.newDynamicEntity("org.example.address.Address");
        address.set("street", "1 Any Street").set("city", "Any Town");
        customer.set("address", address);
        
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(customer, System.out);
    }
    
	static class MyEntityResolver implements EntityResolver {
		
		public InputSource resolveEntity(String publicId, String systemId) throws SAXException, IOException {
			
			// Imported schemas are located in ext\appdata\xsd\

			// Grab only the filename part from the full path
			String filename = new File(systemId).getName();

			// Now prepend the correct path
			String correctedId = "D:\\works\\workspace\\Kiss24\\src\\org\\naj\\java\\xml\\jaxb\\demo1\\xsd\\" + filename;

			InputSource is = new InputSource(ClassLoader.getSystemResourceAsStream(correctedId));
			is.setSystemId(correctedId);

			return is;
		}
	}

}

