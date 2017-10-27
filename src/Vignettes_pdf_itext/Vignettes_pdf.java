/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vignettes_pdf_itext;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.GreekList;
import com.itextpdf.text.List;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.RomanList;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SOFTWARE2
 */
public class Vignettes_pdf {
    
    public static void main(String[] args) throws DocumentException {
        Document documento = new Document();
        
        try {
            //obtenemos la instancia del objeto PDFWriter
            PdfWriter.getInstance(documento, new FileOutputStream("C:\\Users\\SOFTWARE2\\Desktop\\firmaViñeta.pdf"));
            //abrimos el archivo
            documento.open();
            //obtemos una instancia de varios LisItem
            List listado = new List();
            //obtemos una instancia de varios RomanList
            //RomanList listado = new RomanList();
            //obtemos una instancia de varios GreekList
            //GreekList listado = new GreekList();
            
            ListItem itemPais0 = new ListItem("Argentina");
            ListItem itemPais1 = new ListItem("Colombia");
            ListItem itemPais2 = new ListItem("España");
            ListItem itemPais3 = new ListItem("Mexico");
            
            listado.add(itemPais0);
            listado.add(itemPais1);
            listado.add(itemPais2);
            listado.add(itemPais3);
            
            documento.add(listado);
            
            documento.close();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Vignettes_pdf.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
