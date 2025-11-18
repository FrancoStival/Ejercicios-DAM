import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;
import java.util.Scanner;
import javax.crypto.Cipher;

public class Pt3_PracticaRSA {

    private static KeyPair parClaves;
    private static String mensajeOriginal;
    private static String mensajeCifrado;
    private static String mensajeDescifrado;
    private static Scanner entrada;

    public static void main(String[] args) throws Exception {
        parClaves = null;
        mensajeOriginal = "";
        mensajeCifrado = "";
        mensajeDescifrado = "";
        entrada = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("\n--- Menú RSA ---");
            System.out.println("1. Generar par de claves");
            System.out.println("2. Cifrar mensaje");
            System.out.println("3. Descifrar mensaje");
            System.out.println("4. Salir");
            System.out.print("Elige una opción: ");
            int opcion = entrada.nextInt();
            entrada.nextLine();

            switch (opcion) {
                case 1:
                    generarParClaves();
                    System.out.println("Par de claves generado correctamente.");
                    break;
                case 2:
                    if (parClaves == null) {
                        System.out.println("Primero debes generar el par de claves.");
                        break;
                    }
                    System.out.print("Introduce el mensaje a cifrar: ");
                    mensajeOriginal = entrada.nextLine();
                    mensajeCifrado = cifrarMensaje(mensajeOriginal, parClaves.getPublic());
                    System.out.println("Mensaje cifrado (Base64):");
                    System.out.println(mensajeCifrado);
                    break;
                case 3:
                    if (parClaves == null || mensajeCifrado.isEmpty()) {
                        System.out.println("Debes generar claves y cifrar un mensaje antes.");
                        break;
                    }
                    mensajeDescifrado = descifrarMensaje(mensajeCifrado, parClaves.getPrivate());
                    System.out.println("Mensaje descifrado:");
                    System.out.println(mensajeDescifrado);
                    break;
                case 4:
                    salir = true;
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }

        entrada.close();
    }

    private static void generarParClaves() throws Exception {
        KeyPairGenerator generador = KeyPairGenerator.getInstance("RSA");
        generador.initialize(2048);
        parClaves = generador.generateKeyPair();
    }

    private static String cifrarMensaje(String mensaje, PublicKey clavePublica) throws Exception {
        Cipher cifrador = Cipher.getInstance("RSA/ECB/OAEPWithSHA-256AndMGF1Padding");
        cifrador.init(Cipher.ENCRYPT_MODE, clavePublica);
        byte[] bytesCifrados = cifrador.doFinal(mensaje.getBytes());
        return Base64.getEncoder().encodeToString(bytesCifrados);
    }

    private static String descifrarMensaje(String mensajeCifrado, PrivateKey clavePrivada) throws Exception {
        Cipher descifrador = Cipher.getInstance("RSA/ECB/OAEPWithSHA-256AndMGF1Padding");
        descifrador.init(Cipher.DECRYPT_MODE, clavePrivada);
        byte[] bytesDescifrados = descifrador.doFinal(Base64.getDecoder().decode(mensajeCifrado));
        return new String(bytesDescifrados);
    }
}
