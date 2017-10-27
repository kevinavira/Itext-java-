/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Digital_signature;

import com.itextpdf.text.log.LoggerFactory;
import com.itextpdf.text.log.SysoLogger;
import java.security.Security;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

/**
 *
 * @author SOFTWARE2
 */
public class Principal {

    public static void main(String args[]) {
        LoggerFactory.getInstance().setLogger(new SysoLogger());
        Security.addProvider(new BouncyCastleProvider());
        Firmar firma = new Firmar();
        firma.firmarPdf("C:\\Users\\SOFTWARE2\\Desktop\\ETB.pdf", "C:\\Users\\SOFTWARE2\\Desktop\\firma1.pdf");
    }
}
