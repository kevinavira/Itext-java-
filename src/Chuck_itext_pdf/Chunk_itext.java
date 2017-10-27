/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chuck_itext_pdf;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SOFTWARE2
 */
public class Chunk_itext {

    public static void main(String[] args) throws DocumentException {
        Document document = new Document();

        try {
            PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\SOFTWARE2\\Desktop\\Chuck.pdf"));

            document.open();

            document.add(new Chunk("esto es una prueba1."));
            document.add(new Chunk("esto es una prueba2."));

            document.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Chunk_itext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
