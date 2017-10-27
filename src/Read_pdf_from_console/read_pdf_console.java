/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Read_pdf_from_console;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SOFTWARE2
 */
public class read_pdf_console {

    public static void main(String[] args) {

        try {
            //crea instancia de pdfReader
            PdfReader pdfReader = new PdfReader("C:\\Users\\SOFTWARE2\\Desktop\\Table.pdf");

            //obtego el numero  de paginas en pdf
            int pages = pdfReader.getNumberOfPages();

            //itera el numero de paginas 
            for (int i = 1; i < pages; i++) {
                String pageContent = PdfTextExtractor.getTextFromPage(pdfReader, i);

                //imprime el contenido de la pagina en la consola
                System.out.println("Content on page" + i + ":" + pageContent);

            }

            //se cierra el pdf
            pdfReader.close();

        } catch (IOException ex) {
            Logger.getLogger(read_pdf_console.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
