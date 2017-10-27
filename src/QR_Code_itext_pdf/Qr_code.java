/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QR_Code_itext_pdf;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.BarcodeQRCode;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author SOFTWARE2
 */
public class Qr_code {
    
    public static void main(String[] args) {
        
        //por defecto es A4
        Document documento = new  Document();
     
        try {
            //Obtenemos una instancia de un objeto PDF writer
            PdfWriter.getInstance(documento,new FileOutputStream("C:\\Users\\SOFTWARE2\\Desktop\\firmaQR.pdf"));
            
            //Abrir documento
            documento.open();

            //seteamos a la variable el valor que deseamos que tenga el QR            
            String txtCodigoQR="";
            
            //Realizamos una instancia de la clase la cual genera el CodigoQR
            //y seteamos el valor al QR
            BarcodeQRCode codigoBarrasQR = new BarcodeQRCode(txtCodigoQR, 0, 0, null);
            
            //agregamos la imagen del codigo QR al documento
            documento.add(codigoBarrasQR.getImage());
            
            //Cerramos el documento
            documento.close();
            
            
            // "|"= o.
        } catch (Exception ex) {
            Logger.getLogger(Qr_code.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Fatal Error"+ex);
            JOptionPane.showMessageDialog( null, "mi error es"+ex);
            
        }
        
    }
}
