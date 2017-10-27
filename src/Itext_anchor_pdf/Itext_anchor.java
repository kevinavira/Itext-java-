/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Itext_anchor_pdf;

import com.itextpdf.text.Anchor;
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
public class Itext_anchor {

    public static void main(String[] args) throws DocumentException {

        Document document = new Document();

        try {
            //greamos la instancia
            PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\SOFTWARE2\\Desktop\\Anchor.pdf"));

            //abrimos el documeto
            document.open();

            //se crea un objeto anchor
            Anchor anchor = new Anchor("mi pagina");
            //aplicamos la referencia
            anchor.setReference("http://peterparker.com");

            //lo adicionamos al document
            document.add(anchor);

            //cerramos el documento
            document.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Itext_anchor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
