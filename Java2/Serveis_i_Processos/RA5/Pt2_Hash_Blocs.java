package RA5;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Pt2_Hash_Blocs {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            // Pedir al usuario el nombre del archivo
            System.out.print("Introduce el nombre del archivo: ");
            String nombreArchivo = scanner.nextLine();

            // Pedir al usuario el hash esperado en hexadecimal
            System.out.print("Introduce el hash esperado (hexadecimal): ");
            String hashEsperadoHex = scanner.nextLine().toLowerCase();

            // Crear MessageDigest para SHA-256
            MessageDigest digest = MessageDigest.getInstance("SHA-256");

            // Abrir el archivo para lectura por bloques
            try (InputStream archivo = new FileInputStream(nombreArchivo)) {
                byte[] bloque = new byte[4096]; // bloque de 4 KB
                int bytesLeidos;

                // Leer archivo por bloques y actualizar digest
                while ((bytesLeidos = archivo.read(bloque)) > 0) {
                    digest.update(bloque, 0, bytesLeidos);
                }
            }

            // Obtener el hash final como byte[]
            byte[] hashFinal = digest.digest();

            // Convertir hash a hexadecimal para comparación
            StringBuilder hashFinalHex = new StringBuilder();
            for (byte b : hashFinal) {
                hashFinalHex.append(String.format("%02x", b));
            }

            // Comparar con el hash esperado
            if (hashFinalHex.toString().equals(hashEsperadoHex)) {
                System.out.println("El archivo NO ha sido modificado. Hash coincide.");
            } else {
                System.out.println("El archivo ha sido modificado. Hash NO coincide.");
                System.out.println("Hash esperado: " + hashEsperadoHex);
            }

        } catch (NoSuchAlgorithmException e) {
            System.err.println("Error al procesar el archivo: " + e.getMessage());
        }catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
        finally {
            scanner.close();
        }
    }
}
