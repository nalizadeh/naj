package org.naj.java.xml.pdf;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamSource;

import java.io.*;
import com.lowagie.text.DocumentException;
import org.xhtmlrenderer.pdf.ITextRenderer;
import javax.xml.transform.*;
import javax.xml.transform.stream.*;

public class PdfGenerationDemo2 {
	public static final String RESOURCES_DIR = "src//org//naj//java//xml//pdf//";

	public static void main(String[] args) throws IOException, TransformerException, DocumentException,
			TransformerConfigurationException, FileNotFoundException {

		Transformer transformer = TransformerFactory.newInstance().newTransformer(new StreamSource(RESOURCES_DIR + "test2.xslt"));
	    Source xmlInput = new StreamSource(RESOURCES_DIR + "test2.xml");
		StreamResult xmlOutput = new StreamResult(new StringWriter());
		transformer.transform(xmlInput, xmlOutput);

		OutputStream os = new FileOutputStream(RESOURCES_DIR + "ConvertedFile.pdf");
		ITextRenderer renderer = new ITextRenderer();
		renderer.setDocumentFromString(xmlOutput.getWriter().toString());
		renderer.layout();
		renderer.createPDF(os);
		os.close();
	}
}
