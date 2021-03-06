package org.naj.java.xml.pdf;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamSource;

import org.apache.fop.apps.FOPException;
import org.apache.fop.apps.FOUserAgent;
import org.apache.fop.apps.Fop;
import org.apache.fop.apps.FopConfParser;
import org.apache.fop.apps.FopFactory;
import org.apache.fop.apps.FopFactoryBuilder;
import org.apache.fop.apps.MimeConstants;
import org.xml.sax.SAXException;

public class PdfGenerationDemo 
{
    public static final String RESOURCES_DIR = "src//org//naj//java//xml//pdf//";

    public static void main( String[] args )
    {
        try {
            convertToPDF();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void convertToPDF() throws IOException, SAXException,  FOPException, TransformerException {

        File xconf = new File(RESOURCES_DIR + "fop.xconf"); 
        FopConfParser parser = new FopConfParser(xconf); //parsing configuration  
        
        FopFactoryBuilder builder = parser.getFopFactoryBuilder(); //building the factory with the user options

    	// create an instance of fop factory       
        FopFactory fopFactory = builder.build();
                
        // a user agent is needed for transformation
        FOUserAgent foUserAgent = fopFactory.newFOUserAgent();
        
        // Setup output
        OutputStream out = new java.io.FileOutputStream(RESOURCES_DIR + "S073-2.pdf");

        // the XSL FO file
        File xsltFile = new File(RESOURCES_DIR + "S073.xslt");
        
        // the XML file which provides the input
        StreamSource xmlSource = new StreamSource(new File(RESOURCES_DIR + "S073.xml"));

        try {
            // Construct fop with desired output format
            Fop fop = fopFactory.newFop(MimeConstants.MIME_PDF, foUserAgent, out);

            // Setup XSLT
            TransformerFactory factory = TransformerFactory.newInstance();
            Transformer transformer = factory.newTransformer(new StreamSource(xsltFile));

            // Resulting SAX events (the generated FO) must be piped through to
            // FOP
            Result res = new SAXResult(fop.getDefaultHandler());

            // Start XSLT transformation and FOP processing
            // That's where the XML is first transformed to XSL-FO and then
            // PDF is created
            transformer.transform(xmlSource, res);
        } finally {
            out.close();
        }
    }
}