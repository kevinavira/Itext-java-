/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Itext_font_pdf;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
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
public class itext_font {

    public static void main(String[] args) throws FileNotFoundException {

        Document documet = new Document();

        try {
            PdfWriter.getInstance(documet, new FileOutputStream("C:\\Users\\SOFTWARE2\\Desktop\\Font.pdf"));

            documet.open();
            //font Family tipo de fuente // font italic otro metodo de italic // font underline pone el subrayado // Font.BOLD = negrita

            Font font = new Font(Font.FontFamily.TIMES_ROMAN, 20, Font.ITALIC | Font.UNDERLINE | Font.BOLD);

            documet.add(new Paragraph("test font in pdf file.", font));

            documet.close();

        } catch (DocumentException ex) {
            Logger.getLogger(itext_font.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
