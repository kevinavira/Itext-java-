/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pck_Barcode_with_itext;

import com.itextpdf.awt.geom.Rectangle;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.Barcode;
import com.itextpdf.text.pdf.BarcodeEAN;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfSignatureAppearance;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.security.PdfPKCS7;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.security.cert.Certificate;
import java.security.KeyStore;
import java.security.PrivateKey;

/**
 *
 * @author SOFTWARE2
 */
public class Barcode_with_itext {

    public String pathpdf = "C:\\Users\\SOFTWARE2\\Desktop\\C04.pdf";
    public String pathPKCS12 = "ss";
    public String passwordPKCS12 = "ss";

    public boolean sing() throws DocumentException, FileNotFoundException {

        
            Document documento = new Document();
        
            // Obtenemos una instancia de un objeto PDFWriter
            PdfWriter pdfw = PdfWriter.getInstance(documento, new FileOutputStream("C:\\Users\\SOFTWARE2\\Desktop\\C04.pdf"));
            //Abro el documento
            documento.open();
            //Preparo las variables para utilizar la imagen
            Image img;
            //Es el tipo de clase 
            BarcodeEAN codeEAN = new BarcodeEAN();
            //Seteo el tipo de codigo
            codeEAN.setCodeType(Barcode.EAN13);
            //Setep el codigo
            codeEAN.setCode("9781935182610");
            //Paso el codigo a imagen
            img = codeEAN.createImageWithBarcode(pdfw.getDirectContent(), BaseColor.BLACK, BaseColor.RED);
            //Agrego la imagen al documento
            documento.add(img);
            documento.close();
        return false;
       }
 
    

    

    public static void main(String[] args) throws DocumentException, FileNotFoundException {
        Barcode_with_itext c = new Barcode_with_itext();
        c.sing();
    }
}
