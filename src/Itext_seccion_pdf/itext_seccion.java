/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Itext_seccion_pdf;

import com.itextpdf.text.Chapter;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SOFTWARE2
 */
public class itext_seccion {

    public static void main(String[] args) throws FileNotFoundException {
        Document document = new Document();

        try {

            PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\SOFTWARE2\\Desktop\\Section.pdf"));

            //abrimos el documento
            document.open();

            //se crea el objeto chapter
            Chapter chapter = new Chapter(new Paragraph("Chapter 1"), 1);

            //adicionamos la seccion de chapter
            chapter.addSection("Section 1", 2);
            chapter.addSection("Section 2", 2);

            //opcional
            /*Chapter chapter2 = new Chapter(new Paragraph("Chapter 2"), 1);

            chapter2.addSection("Section 0", 2);
            chapter2.addSection("Section 1", 2);*/
            //lo adicionamos al documento
            document.add(chapter);
            //document.add(chapter2);

            //cerramos el documento
            document.close();

        } catch (DocumentException ex) {
            Logger.getLogger(itext_seccion.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
