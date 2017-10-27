/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Password_Itext_pdf;

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
public class password_pdf {

    public static void main(String[] args) throws DocumentException {

        String userPassword = "user123";
        String ownerPassword = "lexco123";
        //creamos el documento
        Document document = new Document();

        try {
            //se instancia el PdfWriter 
            PdfWriter pdfWriter = PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\SOFTWARE2\\Desktop\\Password.pdf"));
            
            //adicionamos la proteccion al password
            pdfWriter.setEncryption(userPassword.getBytes(), ownerPassword.getBytes(),
                    //permitir la impresion ose que pueda ser visible la clave  //ALLOW_COPY desactiva la copia con la versiones mayores a 9 de adobe no funciona
                    PdfWriter.ALLOW_PRINTING | PdfWriter.ALLOW_COPY, PdfWriter.ENCRYPTION_AES_256);

            //abrimos el documento
            document.open();

            //agreganos el contenido
            document.add(new Paragraph("hola mundosin niños Ratas" + "probar la contreaseña de proteccion "));

            //cerramos el documento
            document.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(password_pdf.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
