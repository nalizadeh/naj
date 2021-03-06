package org.naj.java.xml.jaxb.res.eessi.bas.redefine;

// https://www.eclipse.org/forums/index.php/t/360801/


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import javax.xml.transform.stream.StreamSource;

import org.eclipse.persistence.dynamic.DynamicEntity;
import org.eclipse.persistence.dynamic.DynamicType;
import org.eclipse.persistence.exceptions.DynamicException;
import org.eclipse.persistence.jaxb.dynamic.DynamicJAXBContext;
import org.eclipse.persistence.jaxb.dynamic.DynamicJAXBContextFactory;

public class DynamicJaxb {
    public static void main(String[] args) throws JAXBException, FileNotFoundException, DynamicException, InstantiationException, IllegalAccessException {
        System.setProperty("com.sun.tools.xjc.api.impl.s2j.SchemaCompilerImpl.noCorrectnessCheck", "true");
        Locale.setDefault(Locale.ENGLISH);
        testLocal();
//        testCsdb();
    }

    private static void testCsdb() throws FileNotFoundException, JAXBException, DynamicException, InstantiationException, IllegalAccessException {

        File xsd = new File("F:\\schema\\xml_schema_master\\crewSchema.xsd");
        // File xjb = new File("F:\\schema\\xml_schema_master\\crewSchema.xsd");
        //        
        FileInputStream xsdInputStream = new FileInputStream(xsd);
        // FileInputStream xjbInputStream = new FileInputStream(xjb);

        // InputStream xsdStream =
        // loader.getResourceAsStream("file:\\\\F:\\schema\\xml_schema_master\\crewSchema.xsd");
        StreamSource streamSource = new StreamSource(xsdInputStream);
        streamSource.setSystemId(xsd);

        // InputStream xjbStream = loader.getResourceAsStream("crewSchema.xjb");
        // StreamSource xjbStreamSource = new StreamSource(xjbStream);
        // xjbStreamSource.setSystemId("elementTypes.xsd");

        File xjb = new File("F:\\workspace\\test\\src\\crewSchema.xjb");
        // InputStream xjbStream = loader.getResourceAsStream("custom.xjb");
        StreamSource xjbStreamSource = new StreamSource(xjb);
        xjbStreamSource.setSystemId(xjb);

        Map<String, Object> properties = new HashMap<String, Object>();
        properties.put(DynamicJAXBContextFactory.XML_SCHEMA_KEY, streamSource);
        properties.put(DynamicJAXBContextFactory.EXTERNAL_BINDINGS_KEY, xjbStreamSource);

        DynamicJAXBContext jaxbContext = DynamicJAXBContextFactory.createContextFromXSD(streamSource, null, null, properties);
        // DynamicJAXBContext jaxbContext = (DynamicJFAXBContext)
        // org.eclipse.persistence.jaxb.JAXBContext.newInstance("example",
        // loader, properties);

        DynamicType dynamicType = jaxbContext.getDynamicType("dmodule");
        DynamicEntity dmodule = dynamicType.newDynamicEntity();
        traverseProps(jaxbContext, dmodule, dynamicType, 0);

        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(dmodule, System.out);
    }

    private static void testLocal() throws JAXBException, FileNotFoundException, DynamicException, InstantiationException, IllegalAccessException {

        File xsd = new File("F:\\workspace\\test\\src\\custom.xsd");
        FileInputStream xsdInputStream = new FileInputStream(xsd);

        StreamSource streamSource = new StreamSource(xsdInputStream);
        streamSource.setSystemId(xsd);

        File xjb = new File("F:\\workspace\\test\\src\\custom.xjb");
        // InputStream xjbStream = loader.getResourceAsStream("custom.xjb");
        StreamSource xjbStreamSource = new StreamSource(xjb);
        xjbStreamSource.setSystemId(xjb);

        Map<String, Object> properties = new HashMap<String, Object>();
        properties.put(DynamicJAXBContextFactory.XML_SCHEMA_KEY, streamSource);
        properties.put(DynamicJAXBContextFactory.EXTERNAL_BINDINGS_KEY, xjbStreamSource);

        DynamicJAXBContext jaxbContext = DynamicJAXBContextFactory.createContextFromXSD(streamSource, null, null, properties);

        // InputStream inputStream =
        // ClassLoader.getSystemClassLoader().getResourceAsStream("custom.xsd");
        // DynamicJAXBContext jaxbContext =
        // DynamicJAXBContextFactory.createContextFromXSD(streamSource, null,
        // null, null);

        DynamicType dynamicType = jaxbContext.getDynamicType("Customer");
        DynamicEntity customer = dynamicType.newDynamicEntity();
        traverseProps(jaxbContext, customer, dynamicType, 0);

        // DynamicEntity address = jaxbContext.newDynamicEntity("Address");
        // address.set("street", "");
        // address.set("city", "");
        //
        // // DynamicEntity customer = jaxbContext.newDynamicEntity("Customer");
        // customer.set("name", "sss");
        // customer.set("id", "id");
        // customer.set("address", address);

        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(customer, System.out);
    }

    private static void traverseProps(DynamicJAXBContext c, DynamicEntity e, DynamicType t, int level) throws DynamicException, InstantiationException, IllegalAccessException {
        if (t != null) {
            for (String pName : t.getPropertiesNames()) {
                Class<?> clazz = t.getPropertyType(pName);
                if (clazz == null) {
                    // æ£€æŸ¥æ˜¯å�¦æœ‰è¿‡jxbï¼šbindingå¤„ç�†
                    if (t.getDescriptor().getMappingForAttributeName(pName) != null) {
                        String className = t.getDescriptor().getMappingForAttributeName(pName).getReferenceDescriptor().getAlias();
                        DynamicType child = c.getDynamicType(className);
                        DynamicEntity childEntity = child.newDynamicEntity();
                        e.set(pName, childEntity);
                        traverseProps(c, childEntity, child, level + 1);
                    } else {
                        String updatedClassName = pName.substring(0, 1).toUpperCase() + pName.substring(1);
                        DynamicType child = c.getDynamicType(updatedClassName);
                        DynamicEntity childEntity = child.newDynamicEntity();
                        e.set(pName, childEntity);
                        traverseProps(c, childEntity, child, level + 1);
                    }
                } else {
                    e.set(pName, clazz.newInstance());
                }
            }
        } else {
            System.out.println("type is null");
        }
    }
}
