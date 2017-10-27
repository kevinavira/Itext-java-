package Table_pdf_itext;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author SOFTWARE2
 */
public class Table_pdf {

    public static void main(String[] args) throws DocumentException {

        Document document = new Document();
        Calendar calendar;

        try {
            PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\SOFTWARE2\\Desktop\\Table.pdf"));

            //se instancia el elemto que de nombre se va a llamar table
            PdfPTable table = new PdfPTable(new float[]{2, 1, 2});

            //se le define que el elemento va ser de alineacion central
            table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);

            //se le adiciona los datos a la celda // representa la celda  de la tabla en pdf
            table.addCell("Name");
            table.addCell("Age");
            table.addCell("Location");
            table.setHeaderRows(1);
            PdfPCell[] cells = table.getRow(0).getCells();
            for (int j = 0; j < cells.length; j++) {
                // se agrega el color de fondo
                cells[j].setBackgroundColor(BaseColor.GRAY);
            }
            for (int i = 0; i < 5; i++) {
                table.addCell("Name:" + i);
                table.addCell("Age:" + i);
                table.addCell("Location:" + i);
            }

            //se abre el documento
            document.open();
            document.add(table);
            document.close();
            System.out.println("Hecho");

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Table_pdf.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("la cague");
        }

    }

}
