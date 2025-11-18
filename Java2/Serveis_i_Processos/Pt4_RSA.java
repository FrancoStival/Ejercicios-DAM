import java.security.*;
import java.util.Base64;
import java.util.Scanner;
import javax.crypto.Cipher;

public class Pt4_RSA {

    public static void main(String[] args) {
        try {
            KeyPairGenerator generadorClaves = KeyPairGenerator.getInstance("RSA");
            generadorClaves.initialize(2048);
            KeyPair parClaves = generadorClaves.generateKeyPair();
            PublicKey clavePublica = parClaves.getPublic();
            PrivateKey clavePrivada = parClaves.getPrivate();

            Scanner sc = new Scanner(System.in);
            System.out.print("Introduce el mensaje a cifrar: ");
            String mensaje = sc.nextLine();

            Cipher cifrador = Cipher.getInstance("RSA/ECB/OAEPWithSHA-256AndMGF1Padding");
            cifrador.init(Cipher.ENCRYPT_MODE, clavePublica);
            byte[] bytesCifrados = cifrador.doFinal(mensaje.getBytes());

            String mensajeCifradoBase64 = Base64.getEncoder().encodeToString(bytesCifrados);
            System.out.println("\nMensaje cifrado (Base64): " + mensajeCifradoBase64);

            Cipher descifrador = Cipher.getInstance("RSA/ECB/OAEPWithSHA-256AndMGF1Padding");
            descifrador.init(Cipher.DECRYPT_MODE, clavePrivada);
            byte[] bytesDescifrados = descifrador.doFinal(bytesCifrados);
            String mensajeDescifrado = new String(bytesDescifrados);

            System.out.println("Mensaje descifrado: " + mensajeDescifrado);

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
