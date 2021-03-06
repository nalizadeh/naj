package org.naj.java.xml.jaxb;

import java.io.FileInputStream;
import java.util.Collection;

import javax.xml.bind.Marshaller;

import org.eclipse.persistence.descriptors.ClassDescriptor;
import org.eclipse.persistence.dynamic.DynamicEntity;
import org.eclipse.persistence.jaxb.dynamic.DynamicJAXBContext;
import org.eclipse.persistence.jaxb.dynamic.DynamicJAXBContextFactory;

/**
 * https://wiki.eclipse.org/EclipseLink/Examples/MOXy/Dynamic
 * https://www.eclipse.org/eclipselink/documentation/2.5/solutions/jpatoxml006.htm
 * https://www.eclipse.org/eclipselink/documentation/2.5/moxy/dynamic_jaxb003.htm
 * 
 * @author Admin
 *
 */
public class JaxbDyn0 {

	public static void main(String[] args) throws Exception {
	      	
	    System.setProperty("com.sun.tools.xjc.api.impl.s2j.SchemaCompilerImpl.noCorrectnessCheck", "true");

	    FileInputStream xsdInputStream = new FileInputStream(
				"D:\\works\\workspace\\Kiss24\\src\\org\\naj\\java\\xml\\jaxb\\res\\customer.xsd");
		
		DynamicJAXBContext jaxbContext = DynamicJAXBContextFactory.createContextFromXSD(xsdInputStream, null, null,
				null);

		Collection<ClassDescriptor> descriptors = jaxbContext.getXMLContext().getSession().getDescriptors().values();
		for (ClassDescriptor desc : descriptors) {
			if (desc.getJavaClassName() != null) {
				System.out.println(desc.getJavaClassName());
			}
		}

        DynamicEntity newCustomer = jaxbContext.newDynamicEntity("org.example.Customer");
		newCustomer.set("name", "Jones George");

		DynamicEntity newAddress = jaxbContext.newDynamicEntity("org.example.Address");
        newAddress.set("street", "227 Main St.");
		newAddress.set("city", "Toronto");

		newCustomer.set("address", newAddress);
		
		Marshaller marshaller = jaxbContext.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		marshaller.marshal(newCustomer, System.out);
	}
}
