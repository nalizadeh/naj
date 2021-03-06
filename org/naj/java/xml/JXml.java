/*--- (C) 1999-2020 Techniker Krankenkasse ---*/

package org.naj.java.xml;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

/**
 * @author  P203125
 */
public class JXml {

	/**
	 * head line in the generated xml file
	 */
	private static final String XML_VERS = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";

	private static DocumentBuilderFactory factory;
	private static DocumentBuilder builder;
	private static Document document;
	
	private Document xmlDocument;
	private Element element;

	private File file;

	/**
	 */
	public JXml() {
		this(null, null);
	}

	/**
	 * @param  file
	 */
	public JXml(File file) {
		this(file, null);
	}

	/**
	 * @param  xml
	 */
	public JXml(String xml) {
		this(null, xml);
	}

	/**
	 * @param  file
	 * @param  xml
	 */
	private JXml(File file, String xml) {
		this.file = file;
		try {

			factory = DocumentBuilderFactory.newInstance();
			builder = factory.newDocumentBuilder();
			xmlDocument =
				file != null ? builder.parse(file) : xml != null ? createDocument(xml) : builder.newDocument(); //createTestDocument();
			element = xmlDocument.getDocumentElement();
			document = xmlDocument;

		} catch (SAXParseException spe) {
			System.out.println(spe.getMessage());
		} catch (SAXException sxe) {
			System.out.println(sxe.getMessage());
		} catch (ParserConfigurationException pce) {
		} catch (IOException ioe) {
			System.out.println(ioe.getMessage());
		}
	}

	private JXml(Element element) {
		this.element = element;
	}

	/**
	 * @return
	 */
	public Document getDocument() {
		return xmlDocument;
	}

	/**
	 * @param   xml
	 *
	 * @return  Document
	 *
	 * @throws  SAXException
	 * @throws  IOException
	 * @throws  ParserConfigurationException
	 */
	public Document createDocument(String xml) throws SAXException, IOException, ParserConfigurationException {
		DocumentBuilder newDocumentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		Document document = newDocumentBuilder.parse(new ByteArrayInputStream(xml.getBytes("UTF8")));
		return document;
	}

	/**
	 * @param   tagName
	 *
	 * @return  Element
	 */
	public Element createElement(String tagName) {
		return document.createElement(tagName);
	}

	/**
	 * @param   name
	 *
	 * @return  Node
	 */
	public Node createTextNode(String name) {
		return document.createTextNode(name);
	}

	/**
	 * @param   newChild
	 *
	 * @return  Node
	 */
	public Node appendChild(Node newChild) {
		return document.appendChild(newChild);
	}

	/**
	 * @param   name
	 *
	 * @return  Attr
	 */
	public Attr createAttribute(String name) {
		return document.createAttribute(name);
	}

	/**
	 * @param   tagname
	 *
	 * @return  List
	 */
	public List<JXml> getElements(String tagname) {
		List<JXml> elements = new ArrayList<JXml>();
		NodeList list = element.getElementsByTagName(tagname);
		for (int i = 0; i < list.getLength(); i++) {
			Node node = list.item(i);
			if (node.getParentNode() == element) {
				elements.add(new JXml((Element) node));
			}
		}
		return elements;
	}

	/**
	 * @param   name
	 *
	 * @return  String
	 */
	public String getAttribute(String name) {
		return element.getAttribute(name);
	}

	/**
	 * @return  String (Attribues are seperated with ' ')
	 */
	public String getAttributes() {
		String rc = "";
		NamedNodeMap atrs = element.getAttributes();
		for (int i = 0; i < atrs.getLength(); ++i) {
			Node attr = atrs.item(i);
			rc += attr.getNodeName() + "=\"" + attr.getNodeValue() + "\"";
			if (i < atrs.getLength() - 1) {
				rc += " ";
			}
		}
		return rc;
	}

	/**
	 * @return  String (Attribues are seperated with ' ')
	 */
	public void getAttributesMap(Map<String, String> map) {
		NamedNodeMap atrs = element.getAttributes();
		for (int i = 0; i < atrs.getLength(); ++i) {
			Node attr = atrs.item(i);
			map.put(attr.getNodeValue(), attr.getNodeName());
		}
	}

	/**
	 * @param  atrs (Attribues are seperated with ',')
	 */
	public void setAttributes(String atrs) {
		String[] at = atrs.split(",");
		for (String s : at) {
			String[] ap = s.split("=");
			if (ap.length == 2) {
				element.setAttribute(ap[0].trim(), ap[1].trim());
			}
		}
	}

	/**
	 * @param  element
	 * @param  atrs (Attribues are seperated with ',')
	 */
	public static void setAttributes(Element element, String atrs) {
		String[] at = atrs.split(",");
		for (String s : at) {
			String[] ap = s.split("=");
			if (ap.length == 2) {
				element.setAttribute(ap[0].trim(), ap[1].trim());
			}
		}
	}

	/**
	 * @return  String
	 */
	public String getName() {
		return element.getNodeName();
	}

	/**
	 * @return  int
	 */
	public int getType() {
		return element.getNodeType();
	}

	/**
	 * @return  String
	 */
	public String getValue() {
		Node node = element.getFirstChild();
		String v = node == null ? null : node.getNodeValue();
		if (v != null) {
			v = v.replace("\n", "").replace("\r", "").trim();
			v = v.isEmpty() ? null : v;
		}
		return v;
	}

	/**
	 * @param  value
	 */
	public void setValue(String value) {
		Node node = element.getFirstChild();
		if (node != null) {
			node.setNodeValue(value);
		}
	}

	/**
	 * @param   name
	 *
	 * @return  JXml
	 */
	public JXml getChild(String name) {
		if (element != null) {
			NodeList list = element.getChildNodes();
			for (int i = 0; i < list.getLength(); i++) {
				Node node = list.item(i);
				if (node.getNodeName().equals(name)) {
					return new JXml((Element) node);
				}
			}
		}
		return null;
	}

	/**
	 * @param   name
	 *
	 * @return  JXml
	 */
	public List<JXml> getChilds(String name) {
		if (element != null) {
			List<JXml> childs = new ArrayList<JXml>();
			NodeList list = element.getChildNodes();
			for (int i = 0; i < list.getLength(); i++) {
				Node node = list.item(i);
				if (node.getNodeType() == Node.ELEMENT_NODE && node.getNodeName().equals(name)) {
					childs.add(new JXml((Element) node));
				}
			}
			return childs;
		}
		return null;
	}

	/**
	 * @return  List<JXml>
	 */
	public List<JXml> getChilds() {
		if (element != null) {
			List<JXml> childs = new ArrayList<JXml>();
			NodeList list = element.getChildNodes();
			for (int i = 0; i < list.getLength(); i++) {
				Node node = list.item(i);
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					childs.add(new JXml((Element) node));
				}
			}
			return childs;
		}
		return null;
	}

	/**
	 * @param   name
	 * @param   attribute
	 * @param   value
	 *
	 * @throws  DOMException
	 */
	public Element addChild(String name, String attribute, String value) throws DOMException {
		Element child = document.createElement(name);
		element.appendChild(child);

		if (attribute != null && !attribute.isEmpty()) {
			JXml.setAttributes(child, attribute);
		}
		if (value != null && !value.isEmpty()) {
			//child.setNodeValue(value);
			child.setTextContent(value);
		}
		return child;
	}

	/**
	 * @param   path
	 *
	 * @return  JXml
	 */
	public JXml getNode(String path) {
		String[] names = path.split("[.]");

		if (names[0].equals(getName())) {
			if (names.length == 1) {
				return this;
			}

			String pa = path.substring(path.indexOf(".") + 1);

			for (JXml xr : getChilds()) {
				JXml node = xr.getNode(pa);
				if (node != null) {
					return node;
				}
			}
		}

		return null;
	}

	/**
	 * @param   path
	 *
	 * @return  List<JXml>
	 */
	public List<JXml> getNodes(String path) {
		List<JXml> result = new ArrayList<JXml>();
		getNodes(path, result);
		return result;
	}

	private void getNodes(String path, List<JXml> result) {
		String[] names = path.split("[.]");

		if (names[0].equals(getName())) {
			if (names.length == 1) {
				result.add(this);
				return;
			}

			String pa = path.substring(path.indexOf(".") + 1);

			for (JXml xr : getChilds()) {
				xr.getNodes(pa, result);
			}
		}
	}

	/**
	 * @param   name
	 * @param   attribute
	 * @param   value
	 *
	 * @throws  DOMException
	 */
	public JXml addNode(JXml node) throws DOMException {
		Element elem = document.createElement(node.getName());

		String atr = node.getAttributes();
		String val = node.getValue();
		if (atr != null && !atr.isEmpty()) {
			JXml.setAttributes(elem, atr);
		}
		if (val != null && !val.isEmpty()) {
			elem.setNodeValue(val);
		}

		JXml child = new JXml(elem);
		element.appendChild(elem);
		
//		JXml child = new JXml(addChild(node.getName(), node.getAttributes(), node.getValue()));
//		for (JXml ch : node.getChilds()) {
//			child.addNode(ch);
//		}
		return child;
	}

	/**
	 * @param   nodeName
	 * @param   value
	 * @param   node
	 *
	 * @return  boolean
	 */
	public boolean removeNode(String nodeName, String value, Node node) {

		if (node == null) {
			node = document;
		}

		String[] names = nodeName.split("\\.");

		NodeList list = node.getChildNodes();
		for (int i = 0; i < list.getLength(); i++) {
			Node n = list.item(i);
			if (n instanceof Element) {
				Element e = (Element) n;
				if (names[0].equals(e.getTagName())) {
					if (names.length > 1) {
						return removeNode(nodeName.substring(nodeName.indexOf(names[1])), value, n);
					}

					boolean del = value != null ? value.equals(e.getTextContent()) : true;

					if (del) {
						e.getParentNode().removeChild(n);
						return true; // save();
					}
				}
			}
		}

		return false;
	}

	/**
	 * @param   node
	 * @param   name
	 *
	 * @return  Node
	 */
	public static Node findAttribute(Node node, String name) {
		NamedNodeMap attrs = node.getAttributes();

		for (int i = 0; i < attrs.getLength(); i++) {
			Node item = attrs.item(i);
			if (item.getNodeName().equals(name)) {
				return item;
			}
		}
		return null;
	}

	/**
	 * @return  boolean
	 */
	public boolean save() {
		if (file != null) {
			Source source = new DOMSource(document);
			Result result = new StreamResult(file);
			try {

				Transformer xformer = TransformerFactory.newInstance().newTransformer();
				xformer.transform(source, result);
				return true;

			} catch (TransformerConfigurationException e1) {
				e1.printStackTrace();
			} catch (TransformerException e2) {
				e2.printStackTrace();
			}
		}
		return false;
	}

	/**
	 * @param  filename
	 */
	public boolean writeToFile(String filename) {
		try {

			// write the content into xml file
			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			DOMSource source = new DOMSource(document);
			StreamResult result = new StreamResult(new File(filename));
			transformer.transform(source, result);
			return true;

		} catch (TransformerException tfe) {
			tfe.printStackTrace();
		}
		return false;
	}

	public final String toXml(Node node) {

		StringBuffer sb = new StringBuffer();
		
		if (node == null) {
			node = element;
			sb.append(XML_VERS + System.lineSeparator());
		}
		
		sb.append("<" + node.getNodeName());
		if (node.hasAttributes()) {
			sb.append(" ");
			NamedNodeMap attrs = node.getAttributes();
			for (int i = 0; i < attrs.getLength(); i++) {
				Node item = attrs.item(i);
				sb.append(item.getNodeName() + "=\"" + item.getNodeValue() + (i < attrs.getLength()-1 ? "\" " : "\""));
			}
		}
		sb.append(">");
		Node tn = node.getFirstChild();
		if (tn != null && tn.getNodeType() == Node.TEXT_NODE) {
			sb.append(tn.getNodeValue());
		}
		
		NodeList childs = node.getChildNodes();
		for (int i = 0; i < childs.getLength(); i++) {
			Node n = childs.item(i);
			if (n.getNodeType() == Node.ELEMENT_NODE) {
				sb.append(toXml(n));
			}
		}
		sb.append("</" + node.getNodeName() + ">");

		return sb.toString();
	}
		
	public final void print() throws Exception {
        Transformer tf = TransformerFactory.newInstance().newTransformer();
        tf.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        tf.setOutputProperty(OutputKeys.INDENT, "yes");
        Writer out = new StringWriter();
        tf.transform(new DOMSource(xmlDocument), new StreamResult(out));
        System.out.println(out.toString());
    }
	
	/**
	 * @param  node
	 * @param  ind
	 */
	public void echoNode(Node node, int ind) {

		if (node == null) {
			node = document;
		}

		String indent = "";

		for (int i = 0; i < ind; i++) {
			indent += "\t";
		}

		if (node.getNodeType() != Node.ELEMENT_NODE) {
			//return;
		}

		System.out.println(indent + "Node: " + node.getNodeName());
		System.out.println(indent + "\tAttributes: ");

		if (node.hasAttributes()) {
			NamedNodeMap attrs = node.getAttributes();
			for (int i = 0; i < attrs.getLength(); i++) {
				Node item = attrs.item(i);
				System.out.println(indent + "\t\t" + item.getNodeName() + " = " + item.getNodeValue());
			}
		}

		Node tn = node.getFirstChild();
		if (tn != null && tn.getNodeType() == Node.TEXT_NODE) {
			System.out.println(indent + "\tValue: " + tn.getNodeValue());
		}

		System.out.println(indent + "\tChilds: ");

		NodeList childs = node.getChildNodes();
		for (int j = 0; j < childs.getLength(); j++) {
			Node n = childs.item(j);
			echoNode(n, ind + 2);
		}
	}

	/**
	 * @param  node
	 * @param  ind
	 */
	public void echoNode2(Node node, String ind) {

		if (node == null) {
			node = document;
		}

		if (node.getNodeType() != Node.ELEMENT_NODE) {
			//return;
		}

		if (node.getNodeName().equals("Node")) {

			String[] atrsName = { "name", "multiple", "data-type" };

			if (node.hasAttributes()) {

				int index = 0;
				String atrs = "";

				for (String name : atrsName) {
					Node item = findAttribute(node, name);
					if (item != null) {

						atrs +=
							(
								index == 0 ? item.getNodeValue()
								: index == 1 ? " [" + item.getNodeValue() : "," + item.getNodeValue()
							);
					} else if (name.equals("data-type")) {
						item = findAttribute(node, "ref");
						if (item != null) {
							String v = item.getNodeValue();
							v = v.substring(v.lastIndexOf("\\") + 1);
							v = v.substring(0, v.indexOf("."));
							atrs += "," + v;
						}
					}

					index++;
				}
				if (!atrs.isEmpty()) {
					System.out.println(ind + atrs + "]");
				}
			}

			Node tn = node.getFirstChild();
			if (tn != null && tn.getNodeType() == Node.TEXT_NODE) {
			}
		}

		NodeList childs = node.getChildNodes();
		for (int j = 0; j < childs.getLength(); j++) {
			Node n = childs.item(j);
			echoNode2(n, ind + "\t");
		}
	}

	@SuppressWarnings("unused")
	private Document createTestDocument() throws SAXException, IOException, ParserConfigurationException {
		return
			createDocument(
				"<?xml version=\"1.0\" encoding=\"utf-8\"?>" //
				+ "<A>" //
				+ "<B>" //
				+ "<C>" //
				+ "<C1>" //
				+ "<C11>something</C11>" //
				+ "<C12>something</C12>" //
				+ "</C1>" //
				+ "</C>" //
				+ "<D>" //
				+ "<D1>" //
				+ "<D11>" //
				+ "<D111 operation=\"create\"><Node>something else</Node></D111>" //
				+ "</D11>" //
				+ "</D1>" //
				+ "<D2>" //
				+ "<D21>" //
				+ "</D21>" //
				+ "</D2>" //
				+ "</D>" //
				+ "</B>" //
				+ "</A>"
			); //
	}

	//===================================================================

	public static void main(String[] args) {

//      JXml ma = new JXml("D:/works/tmp/MainModel.xml");
//      ma.echoNode(null, 1);
//      ma.removeNode("MainModel.steuerungskonzept.Brief.briefdatumText", null, null);

		//JXml ma = new JXml("D:/works/kiss24/manager/unfall.xml");
		try {
			JXml ma = new JXml(new File("D:\\works\\Erv\\XJustiz_2_4_0_XSD\\xjustiz_0020_cl_gerichte_2_6.xsd"));
			
			JXml val = ma.getChild("xs:complexType").getChild("xs:annotation").getChild("xs:appinfo").getChild("listName");
			System.out.println(val.getValue());
			
			val = ma.getNode("xs:schema.xs:complexType.xs:complexContent.xs:restriction.xs:sequence.xs:element.xs:simpleType.xs:restriction");
			List<JXml> enums = val.getChilds("xs:enumeration");
			System.out.println(enums.size());

			//JXml ma = new JXml(new File("D:\\works\\kiss24\\manager\\mtext\\datenmodelle\\unfall\\Unfall.datamodel"));
			//JXml ma = new JXml("W:\\Projekte\\TK-Kiss24-Migration\\tools\\manager\\mtext\\xml\\unfall.xml");
			//ma.echoNode2(null, "");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}

/*--- Formatiert nach TK Code Konventionen vom 05.03.2002 ---*/
