package RA5;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.util.Base64;
import java.util.Scanner;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class Pt6HibridCertSign {

    public static void main(String[] args) {
        Scanner entrada = null;
        try {
            entrada = new Scanner(System.in, StandardCharsets.UTF_8.name());

            System.out.println("Parte 1: XIFRAT HÍBRID (AES + RSA)");
            System.out.print("Missatge secret: ");
            String mensaje = entrada.nextLine();

            KeyGenerator kg = KeyGenerator.getInstance("AES");
            kg.init(128);
            SecretKey claveAES = kg.generateKey();

            Cipher cipherAES = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipherAES.init(Cipher.ENCRYPT_MODE, claveAES);
            byte[] mensajeCifradoAES = cipherAES.doFinal(mensaje.getBytes(StandardCharsets.UTF_8));
            String mensajeCifradoAESBase64 = Base64.getEncoder().encodeToString(mensajeCifradoAES);
            System.out.println("Missatge xifrat (AES, Base64): " + mensajeCifradoAESBase64);

            KeyPairGenerator kpgRSA = KeyPairGenerator.getInstance("RSA");
            kpgRSA.initialize(2048);
            KeyPair parClavesRSA = kpgRSA.generateKeyPair();
            PublicKey clavePublicaRSA = parClavesRSA.getPublic();
            PrivateKey clavePrivadaRSA = parClavesRSA.getPrivate();

            Cipher cipherRSA = Cipher.getInstance("RSA/ECB/OAEPWithSHA-256AndMGF1Padding");
            cipherRSA.init(Cipher.ENCRYPT_MODE, clavePublicaRSA);
            byte[] claveAESbytes = claveAES.getEncoded();
            byte[] claveAESCifradaConRSA = cipherRSA.doFinal(claveAESbytes);
            String claveAESCifradaBase64 = Base64.getEncoder().encodeToString(claveAESCifradaConRSA);
            System.out.println("Clau AES xifrada amb RSA (Base64): " + claveAESCifradaBase64);

            cipherRSA.init(Cipher.DECRYPT_MODE, clavePrivadaRSA);
            byte[] claveAESDesifradaBytes = cipherRSA.doFinal(Base64.getDecoder().decode(claveAESCifradaBase64));
            SecretKey claveAESRecuperada = new SecretKeySpec(claveAESDesifradaBytes, "AES");

            Cipher cipherAESdec = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipherAESdec.init(Cipher.DECRYPT_MODE, claveAESRecuperada);
            byte[] mensajeDescifradoBytes = cipherAESdec.doFinal(Base64.getDecoder().decode(mensajeCifradoAESBase64));
            String mensajeRecuperado = new String(mensajeDescifradoBytes, StandardCharsets.UTF_8);

            System.out.println("Missatge desxifrat amb la clau AES recuperada: " + mensajeRecuperado);
            System.out.println("Coincideix amb l'original: " + mensajeRecuperado.equals(mensaje));

            System.out.println("\nParte 2: SIGNATURA DIGITAL");
            KeyPairGenerator kpgFirma = KeyPairGenerator.getInstance("RSA");
            kpgFirma.initialize(2048);
            KeyPair parClavesFirma = kpgFirma.generateKeyPair();
            PrivateKey clavePrivadaFirma = parClavesFirma.getPrivate();
            PublicKey clavePublicaFirma = parClavesFirma.getPublic();

            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashMensaje = md.digest(mensaje.getBytes(StandardCharsets.UTF_8));
            Signature signer = Signature.getInstance("SHA256withRSA");
            signer.initSign(clavePrivadaFirma);
            signer.update(hashMensaje);
            byte[] signatureBytes = signer.sign();
            String signatureBase64 = Base64.getEncoder().encodeToString(signatureBytes);

            System.out.println("Hash SHA-256 (hex): " + bytesAHex(hashMensaje));
            System.out.println("Signatura (Base64): " + signatureBase64);

            Signature verifier = Signature.getInstance("SHA256withRSA");
            verifier.initVerify(clavePublicaFirma);
            verifier.update(hashMensaje);
            boolean firmaValida = verifier.verify(Base64.getDecoder().decode(signatureBase64));
            System.out.println("Verificació (missatge original): " + (firmaValida ? "VÀLIDA" : "INVÀLIDA"));

            String mensajeAlterado = mensaje + ".";
            byte[] hashAlterado = md.digest(mensajeAlterado.getBytes(StandardCharsets.UTF_8));
            verifier.initVerify(clavePublicaFirma);
            verifier.update(hashAlterado);
            boolean firmaValidaAlterado = verifier.verify(Base64.getDecoder().decode(signatureBase64));
            System.out.println("Verificació (missatge alterat): " + (firmaValidaAlterado ? "VÀLIDA" : "INVÀLIDA"));

            System.out.println("\nParte 3: CERTIFICAT DIGITAL MÍNIM I CA SIMULADA");
            KeyPairGenerator kpgCA = KeyPairGenerator.getInstance("RSA");
            kpgCA.initialize(2048);
            KeyPair parClavesCA = kpgCA.generateKeyPair();
            PrivateKey clavePrivadaCA = parClavesCA.getPrivate();
            PublicKey clavePublicaCA = parClavesCA.getPublic();

            String subject = "Franco";
            String publicKeyBase64 = Base64.getEncoder().encodeToString(clavePublicaRSA.getEncoded());
            String issuer = "SimpleCA";
            String contenidoParaFirmar = subject + "|" + publicKeyBase64;

            Signature signerCA = Signature.getInstance("SHA256withRSA");
            signerCA.initSign(clavePrivadaCA);
            signerCA.update(contenidoParaFirmar.getBytes(StandardCharsets.UTF_8));
            byte[] firmaCert = signerCA.sign();
            String firmaCertBase64 = Base64.getEncoder().encodeToString(firmaCert);

            File certFile = new File("Franco_cert.txt");
            try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(certFile), StandardCharsets.UTF_8))) {
                bw.write("Subject: " + subject);
                bw.newLine();
                bw.write("PublicKey: " + publicKeyBase64);
                bw.newLine();
                bw.write("Issuer: " + issuer);
                bw.newLine();
                bw.write("Signature: " + firmaCertBase64);
                bw.newLine();
            }
            System.out.println("Certificat generat i guardat a: " + certFile.getAbsolutePath());

            System.out.println("\nValidant certificat original...");
            boolean valido = validarCertificat(certFile, clavePublicaCA);
            System.out.println(valido ? "CERTIFICAT VÀLID" : "CERTIFICAT INVÀLID");

            System.out.println("\nProvant certificat modificat (canviarem Subject a 'Mallory')...");
            File certMod = new File("Franco_cert_modificada.txt");
            try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(certFile), StandardCharsets.UTF_8));
                 BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(certMod), StandardCharsets.UTF_8))) {
                String linea;
                while ((linea = br.readLine()) != null) {
                    if (linea.startsWith("Subject: ")) {
                        bw.write("Subject: Mallory");
                    } else {
                        bw.write(linea);
                    }
                    bw.newLine();
                }
            }
            System.out.println("Validant certificat modificat...");
            boolean validoMod = validarCertificat(certMod, clavePublicaCA);
            System.out.println(validoMod ? "CERTIFICAT VÀLID" : "CERTIFICAT INVÀLID");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (entrada != null) {
                entrada.close();
            }
        }
    }

    public static boolean validarCertificat(File ficheroCert, PublicKey clavePublicaCA) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(ficheroCert), StandardCharsets.UTF_8))) {
            String subjectLine = br.readLine();
            String publicKeyLine = br.readLine();
            String issuerLine = br.readLine();
            String signatureLine = br.readLine();

            if (subjectLine == null || publicKeyLine == null || signatureLine == null) {
                return false;
            }

            if (!subjectLine.startsWith("Subject: ") || !publicKeyLine.startsWith("PublicKey: ") || !signatureLine.startsWith("Signature: ")) {
                return false;
            }

            String subject = subjectLine.substring("Subject: ".length()).trim();
            String publicKeyBase64 = publicKeyLine.substring("PublicKey: ".length()).trim();
            String contenido = subject + "|" + publicKeyBase64;

            String signatureBase64 = signatureLine.substring("Signature: ".length()).trim();
            byte[] signatureBytes = Base64.getDecoder().decode(signatureBase64);

            Signature verifierCA = Signature.getInstance("SHA256withRSA");
            verifierCA.initVerify(clavePublicaCA);
            verifierCA.update(contenido.getBytes(StandardCharsets.UTF_8));
            return verifierCA.verify(signatureBytes);

        } catch (Exception e) {
            return false;
        }
    }

    public static String bytesAHex(byte[] datos) {
        StringBuilder sb = new StringBuilder();
        for (byte b : datos) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}
