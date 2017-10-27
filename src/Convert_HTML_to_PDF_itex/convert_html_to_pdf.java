/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Convert_HTML_to_PDF_itex;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.html.simpleparser.HTMLWorker;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.StringReader;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.xhtmlrenderer.pdf.ITextRenderer;

/**
 *
 * @author SOFTWARE2
 */
public class convert_html_to_pdf {

    public static void main(String[] args) throws FileNotFoundException, IOException, DocumentException {

        try {
            //agregamso la estructuta HTML
            String k = "<html>\n"
                    + "<head>\n"
                    + "<title>Page Title</title>\n"
                    + "</head>\n"
                    + "<body>\n"
                    + "\n"
                    + "<h1>This is a Heading</h1>\n"
                    + "<p>This is a paragraph.</p>\n"
                    + "\n"
                    + "</body>\n"
                    + "</html>";

            //se crea y generamos el archivo con ruta 
            OutputStream file = new FileOutputStream(new File("C:\\Users\\SOFTWARE2\\Desktop\\ConvertedFiles.pdf"));

            //Instanciamos el documento 
            Document document = new Document();

            PdfWriter.getInstance(document, file);

            //abrimos el documento
            document.open();

            //Instanciamos el HTMLWorker
            HTMLWorker htmlWorker = new HTMLWorker(document);

            //lo parseamso 
            htmlWorker.parse(new StringReader(k));

            //Cerramos el documento
            document.close();

            //Cerramos el archivo
            file.close();

            //Opcional la impresion si sse ejecuto bien el prlograma
            System.out.println("successful function");

        } catch (MalformedURLException ex) {
            Logger.getLogger(convert_html_to_pdf.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
