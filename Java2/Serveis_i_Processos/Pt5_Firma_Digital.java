
import java.security.*;
import java.util.Scanner;

public class Pt5_Firma_Digital{

    public static void main(String[] args) {
        try {
            KeyPairGenerator generador = KeyPairGenerator.getInstance("RSA");
            generador.initialize(2048);
            KeyPair parClaves = generador.generateKeyPair();
            PrivateKey clavePrivada = parClaves.getPrivate();
            PublicKey clavePublica = parClaves.getPublic();

            Scanner entrada = new Scanner(System.in);
            System.out.print("Introduce el mensaje a firmar: ");
            String mensaje = entrada.nextLine();

            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashMensaje = digest.digest(mensaje.getBytes());

            Signature firma = Signature.getInstance("SHA256withRSA");
            firma.initSign(clavePrivada);
            firma.update(hashMensaje);
            byte[] firmaDigital = firma.sign();

            System.out.println("\nMensaje original:");
            System.out.println(mensaje);

            System.out.println("\nHash SHA-256 del mensaje:");
            System.out.println(bytesAHex(hashMensaje));

            System.out.println("\nFirma digital (hex):");
            System.out.println(bytesAHex(firmaDigital));

            Signature verificador = Signature.getInstance("SHA256withRSA");
            verificador.initVerify(clavePublica);
            verificador.update(hashMensaje);
            boolean valida = verificador.verify(firmaDigital);

            System.out.println("\nVerificación con el mensaje original:");
            System.out.println(valida ? "Firma válida" : "Firma no válida");

            String mensajeModificado = mensaje + "X";
            byte[] hashModificado = digest.digest(mensajeModificado.getBytes());

            verificador.initVerify(clavePublica);
            verificador.update(hashModificado);
            boolean validaModificado = verificador.verify(firmaDigital);

            System.out.println("\nVerificación con mensaje alterado:");
            System.out.println(validaModificado ? "Firma válida" : "Firma no válida (mensaje alterado)");
            
        } catch (InvalidKeyException | NoSuchAlgorithmException | SignatureException e) {
            e.printStackTrace();
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
