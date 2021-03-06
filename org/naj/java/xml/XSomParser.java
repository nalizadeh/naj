package org.naj.java.xml;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.EntityResolver;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;

import com.sun.xml.xsom.XSAnnotation;
import com.sun.xml.xsom.XSAttributeDecl;
import com.sun.xml.xsom.XSAttributeUse;
import com.sun.xml.xsom.XSComplexType;
import com.sun.xml.xsom.XSContentType;
import com.sun.xml.xsom.XSElementDecl;
import com.sun.xml.xsom.XSFacet;
import com.sun.xml.xsom.XSModelGroup;
import com.sun.xml.xsom.XSParticle;
import com.sun.xml.xsom.XSRestrictionSimpleType;
import com.sun.xml.xsom.XSSchema;
import com.sun.xml.xsom.XSSchemaSet;
import com.sun.xml.xsom.XSSimpleType;
import com.sun.xml.xsom.XSTerm;
import com.sun.xml.xsom.XSType;
import com.sun.xml.xsom.parser.AnnotationContext;
import com.sun.xml.xsom.parser.AnnotationParser;
import com.sun.xml.xsom.parser.AnnotationParserFactory;
import com.sun.xml.xsom.parser.XSOMParser;

public class XSomParser {

	private XSSchemaSet schemaSet;
	private XSSchema xsSchema;

	public static void main(String[] args) {
		new XSomParser().parse(new File(
				"D:\\works\\Eessi\\4.2.0_3.0.0\\national\\transactions\\S_BUC_19b-3.0-CaseOwner-Counterparty-Start-S080NAF-3.0.xsd"));
	}

	private void parse(File file) {
		try {
			SAXParserFactory factory = SAXParserFactory.newInstance();
			String featureToSet = XMLConstants.FEATURE_SECURE_PROCESSING;
			factory.setFeature(featureToSet, true);
			factory.setNamespaceAware(true);
			XSOMParser parser = new XSOMParser(factory);
			parser.setAnnotationParser(new AnnotationFactory());
			parser.parse(file);
			this.schemaSet = parser.getResult();
			this.xsSchema = this.schemaSet.getSchema(1);
			printElements();
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace(System.out);
		}
	}

	private void printElements() {

		Map<String, XSAttributeDecl> m0 = xsSchema.getAttributeDecls();
		Map<String, XSComplexType> m1 = xsSchema.getComplexTypes();
		Map<String, XSSimpleType> m2 = xsSchema.getSimpleTypes();
		Map<String, XSElementDecl> m3 = xsSchema.getElementDecls();
		Map<String, XSType> m4 = xsSchema.getTypes();
		XSAnnotation an = xsSchema.getAnnotation();

		XSComplexType xsComplexType = xsSchema.getComplexType("StandardBusinessDocument");

		Collection<? extends XSAttributeUse> c0 = xsComplexType.getAttributeUses();

		XSContentType xsContentType = xsComplexType.getContentType();
		XSParticle particle = xsContentType.asParticle();
		if (particle != null) {
			XSTerm term = particle.getTerm();
			if (term.isModelGroup()) {
				XSModelGroup xsModelGroup = term.asModelGroup();
				XSParticle[] particles = xsModelGroup.getChildren();
				for (XSParticle p : particles) {
					XSTerm pterm = p.getTerm();
					if (pterm.isElementDecl()) { // xs:element inside complex type
						System.out.println(pterm);
					}
				}
			}
		}

		getAttributes(xsComplexType);

		if (xsComplexType.getAnnotation() != null) {
			System.out.println(xsComplexType.getAnnotation().getAnnotation());
		}
	}

	private void getAttributes(XSComplexType xsComplexType) {
		Collection<? extends XSAttributeUse> c = xsComplexType.getAttributeUses();
		Iterator<? extends XSAttributeUse> i = c.iterator();
		while (i.hasNext()) {
			XSAttributeDecl attributeDecl = i.next().getDecl();
			System.out.println("type: " + attributeDecl.getType());
			System.out.println("name:" + attributeDecl.getName());
		}
	}

	private void initRestrictions(XSSimpleType xsSimpleType, SimpleTypeRestriction t) {
		XSRestrictionSimpleType restriction = xsSimpleType.asRestriction();
		if (restriction != null) {
			Vector<String> enumeration = new Vector<String>();
			Iterator<? extends XSFacet> i = restriction.getDeclaredFacets().iterator();
			while (i.hasNext()) {
				XSFacet facet = i.next();
				if (facet.getName().equals(XSFacet.FACET_ENUMERATION)) {
					enumeration.add(facet.getValue().value);
				}
				if (facet.getName().equals(XSFacet.FACET_MAXINCLUSIVE)) {
					t.maxValue = facet.getValue().value;
				}
				if (facet.getName().equals(XSFacet.FACET_MININCLUSIVE)) {
					t.minValue = facet.getValue().value;
				}
				if (facet.getName().equals(XSFacet.FACET_MAXEXCLUSIVE)) {
					// t.maxValue = String.valueOf(Integer.parseInt(facet.getValue().value) – 1);
				}
				if (facet.getName().equals(XSFacet.FACET_MINEXCLUSIVE)) {
					t.minValue = String.valueOf(Integer.parseInt(facet.getValue().value) + 1);
				}
				if (facet.getName().equals(XSFacet.FACET_LENGTH)) {
					t.length = facet.getValue().value;
				}
				if (facet.getName().equals(XSFacet.FACET_MAXLENGTH)) {
					t.maxLength = facet.getValue().value;
				}
				if (facet.getName().equals(XSFacet.FACET_MINLENGTH)) {
					t.minLength = facet.getValue().value;
				}
				if (facet.getName().equals(XSFacet.FACET_PATTERN)) {
					t.pattern = facet.getValue().value;
				}
				if (facet.getName().equals(XSFacet.FACET_TOTALDIGITS)) {
					t.totalDigits = facet.getValue().value;
				}
			}
			if (enumeration.size() > 0) {
				t.enumeration = enumeration.toArray(new String[] {});
			}
		}
	}

	class SimpleTypeRestriction {
		public String[] enumeration = null;
		public String maxValue = null;
		public String minValue = null;
		public String length = null;
		public String maxLength = null;
		public String minLength = null;
		public String pattern = null;
		public String totalDigits = null;
	}

	class AnnotationFactory implements AnnotationParserFactory {
		@Override
		public AnnotationParser create() {
			return new XsdAnnotationParser();
		}
	}

	class XsdAnnotationParser extends AnnotationParser {
		private StringBuilder documentation = new StringBuilder();

		@Override
		public ContentHandler getContentHandler(AnnotationContext context, String parentElementName,
				ErrorHandler handler, EntityResolver resolver) {
			return new ContentHandler() {
				private boolean parsingDocumentation = false;

				@Override
				public void characters(char[] ch, int start, int length) throws SAXException {
					if (parsingDocumentation) {
						documentation.append(ch, start, length);
					}
				}

				@Override
				public void endElement(String uri, String localName, String name) throws SAXException {
					if (localName.equals("documentation")) {
						parsingDocumentation = false;
					}
				}

				@Override
				public void startElement(String uri, String localName, String name, Attributes atts)
						throws SAXException {
					if (localName.equals("documentation")) {
						parsingDocumentation = true;
					}
				}

				public void startDocument() throws org.xml.sax.SAXException {
				}

				public void endDocument() throws org.xml.sax.SAXException {
				}

				public void startPrefixMapping(java.lang.String arg0, java.lang.String arg1)
						throws org.xml.sax.SAXException {
				}

				public void setDocumentLocator(org.xml.sax.Locator arg0) {

				}

				public void endPrefixMapping(java.lang.String arg0) throws SAXException {

				}

				public void ignorableWhitespace(char[] arg0, int arg1, int arg2) throws SAXException {

				}

				public void processingInstruction(String s, String v) throws SAXException {

				}

				public void skippedEntity(String arg0) throws SAXException {

				}
			};
		}

		@Override
		public Object getResult(Object existing) {
			return documentation.toString().trim();
		}
	}

	// ======================
	// Simple Schema Reader

	void simpleParser() {
		try {
			// parse the document
			DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
			Document doc = docBuilder.parse(new File(
					"D:\\works\\Eessi\\4.2.0_3.0.0\\national\\transactions\\S_BUC_19b-3.0-CaseOwner-Counterparty-Start-S080NAF-3.0.xsd"));

			NodeList list = doc.getElementsByTagName("xs:element");
			NodeList list2 = doc.getElementsByTagName("xs:redefine");

			// loop to print data
			for (int i = 0; i < list.getLength(); i++) {
				Element first = (Element) list.item(i);
				if (first.hasAttributes()) {
					String nm = first.getAttribute("name");
					System.out.print(nm);
					String re = first.getAttribute("ref");
					System.out.print(" " + re);
					String nm1 = first.getAttribute("type");
					System.out.println(" " + nm1);
				}
			}
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException ed) {
			ed.printStackTrace();
		}
	}

}
