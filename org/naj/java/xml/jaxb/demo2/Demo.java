package org.naj.java.xml.jaxb.demo2;

import java.io.*;
import java.math.BigInteger;
import javax.xml.bind.*;
import org.eclipse.persistence.dynamic.DynamicEntity;
import org.eclipse.persistence.jaxb.dynamic.*;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

// https://www.eclipse.org/forums/index.php/t/487334/

public class Demo {

    public static void main(String[] args) throws Exception {
        FileInputStream xsdInputStream = new FileInputStream(
        		"D:\\works\\workspace\\Kiss24\\src\\org\\naj\\java\\xml\\jaxb\\demo2\\generalInvoiceResponse_430.xsd");
        DynamicJAXBContext jaxbContext = 
            DynamicJAXBContextFactory.createContextFromXSD(xsdInputStream, new MyEntityResolver(), null, null);

        Unmarshaller unmarshaller= jaxbContext.createUnmarshaller();
        File xml = new File("D:\\works\\workspace\\Kiss24\\src\\org\\naj\\java\\xml\\jaxb\\demo2\\input.xml");
        JAXBElement<DynamicEntity> result = (JAXBElement<DynamicEntity>) unmarshaller.unmarshal(xml);
        
        BigInteger responseTimestamp = result.getValue().<DynamicEntity>get("payload").<BigInteger>get("responseTimestamp");
        System.out.println(responseTimestamp);
        
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(result, System.out);
    }
    
	static class MyEntityResolver implements EntityResolver {

		public InputSource resolveEntity(String publicId, String systemId) throws SAXException, IOException {
			String filename = new File(systemId).getName();
			String correctedId = "D:\\works\\workspace\\Kiss24\\src\\org\\naj\\java\\xml\\jaxb\\demo2\\" + filename;
			InputSource is = new InputSource(ClassLoader.getSystemResourceAsStream(correctedId));
			is.setSystemId(correctedId);
			return is;
		}
	}


}
