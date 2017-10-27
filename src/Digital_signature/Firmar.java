/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Digital_signature;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Image;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.log.Logger;
import com.itextpdf.text.log.LoggerFactory;
import com.itextpdf.text.pdf.BarcodeEAN;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfSignatureAppearance;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.security.BouncyCastleDigest;

import com.itextpdf.text.pdf.security.ExternalDigest;
import org.bouncycastle.jcajce.provider.digest.MD2.Digest;
import com.itextpdf.text.pdf.security.ExternalSignature;
import com.itextpdf.text.pdf.security.MakeSignature;
import com.itextpdf.text.pdf.security.MakeSignature.CryptoStandard;
import com.itextpdf.text.pdf.security.PdfPKCS7;
import com.itextpdf.text.pdf.security.PrivateKeySignature;
import static com.itextpdf.text.pdf.security.SecurityConstants.Signature;
import com.itextpdf.text.pdf.security.TSAClientBouncyCastle;
import java.io.FileOutputStream;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.cert.Certificate;
import com.itextpdf.text.pdf.PdfSignatureAppearance;

/**
 *
 * @author SOFTWARE2
 */
public class Firmar {

    private static final Logger logger = LoggerFactory
            .getLogger(Firmar.class);

    public Firmar() {

    }

    public void firmarPdf(String origen, String destino) {

        try {
            KeyStore keyStore = KeyStore.getInstance("JKS");
            String pass = "456123789"; //PASSWORD DE LA KEYSTORE
            if (pass != "456123789") {
                System.out.println("erorr clave incorrcta");
            }

            java.io.FileInputStream file = new java.io.FileInputStream(
                    "C:\\jks\\keystore.jks"); //EL ARCHIVO QUE GENERAMOS TIENE QUE ESTAR EN EL DISCO C
            keyStore.load(file, pass.toCharArray());
            PrivateKey pk = (PrivateKey) keyStore.getKey("mtorre4580",
                    pass.toCharArray());//USUARIO Y PASSWORD DE LA KEYSTORE
            Certificate[] chain = keyStore.getCertificateChain("mtorre4580"); //OBTENGO EL CERTIFICADO

            PdfReader reader = new PdfReader(origen);//trae el archivo pdf con todos sus atributos
            FileOutputStream os = new FileOutputStream(destino);//instancia un archivo a ala maquina
            PdfStamper stamper = PdfStamper.createSignature(reader, os, '\0');//hace el proceso de estampado
            PdfSignatureAppearance appearance = stamper
                    .getSignatureAppearance();

            appearance.setReason("Firmar documento con itext mtorre4580");//agrega la razon
            appearance.setLocation("Colombia");//la locacion
            appearance.setVisibleSignature(new Rectangle(72, 732, 144, 780), 1,
                    "signature");//agrega los parametros donde se van agreegar el certificado en el documento

            ExternalDigest digest = new BouncyCastleDigest();
            ExternalSignature signature = new PrivateKeySignature(pk, "SHA1", "BC");//se el agrega la llave a la firma
            MakeSignature.signDetached(appearance, digest, signature, chain, null, null, null, 0, CryptoStandard.CADES);//estandar de encryptacion

        } catch (Exception e) {
            System.out.println("tengo un error" + e);
            logger.error("Error al firmar el pdf");
        }
    }
}
