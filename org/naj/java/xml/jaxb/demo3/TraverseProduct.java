package org.naj.java.xml.jaxb.demo3;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import org.eclipse.persistence.dynamic.DynamicEntity;
import org.eclipse.persistence.dynamic.DynamicType;
import org.eclipse.persistence.exceptions.DynamicException;
import org.eclipse.persistence.jaxb.dynamic.DynamicJAXBContext;
import org.eclipse.persistence.jaxb.dynamic.DynamicJAXBContextFactory;

public class TraverseProduct {

	private static void traverseProps(DynamicJAXBContext c, DynamicEntity e, DynamicType t, int level)
			throws DynamicException, InstantiationException, IllegalAccessException {
		if (t != null) {
			for (String pName : t.getPropertiesNames()) {
				Class<?> clazz = t.getPropertyType(pName);
				System.out.println("prop [" + pName + "] in type: " + clazz);
				// logger.info("prop [" + pName + "] in entity: " + e.get(pName));

				if (clazz == null) {
					// need to create an instance of object
					String updatedClassName = pName.substring(0, 1).toUpperCase() + pName.substring(1);
					System.out.println("Creating new type instance for " + pName + " using following class name: "
							+ updatedClassName);
					DynamicType child = c.getDynamicType("generated." + updatedClassName);
					DynamicEntity childEntity = child.newDynamicEntity();
					e.set(pName, childEntity);
					traverseProps(c, childEntity, child, level + 1);

				} else {

					e.set(pName, pName.toString());
					// just set empty value
					/*
					 * switch(clazz.toString()) {
					 * 
					 * 
					 * case "class java.math.BigDecimal" :e.set(pName, new Integer(1).toString());
					 * break;
					 * 
					 * case "class java.util.Date" : e.set(pName, new Date().toString()); break;
					 * 
					 * case "class java.sql.Date" : e.set(pName, new Date().toString()); break;
					 * 
					 * 
					 * 
					 * case "class java.lang.String" :e.set(pName, pName.toString()); break; default
					 * :break; }
					 */
					// if("class java.lang.String".equals(clazz.toString()))
					// e.set(pName, pName.toString());

				}
			}
		} else {
			System.out.print("type is null");
		}
	}

	public static void main(String[] args) throws Exception {

		File ftd = new File("D:\\works\\workspace\\Kiss24\\src\\org\\naj\\java\\xml\\jaxb\\demo3\\product.xsd");
		
		InputStream is = new FileInputStream(ftd);
		DynamicJAXBContext dynamicJAXBContext = DynamicJAXBContextFactory.createContextFromXSD(is, null,
				TraverseProduct.class.getClassLoader(), null);
		DynamicType rootType = dynamicJAXBContext.getDynamicType("Product");

		DynamicEntity root = rootType.newDynamicEntity();
		traverseProps(dynamicJAXBContext, root, rootType, 0);
		dynamicJAXBContext.createMarshaller().marshal(root, System.out);

	}
}
