package Java2.Serveis_i_Processos;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Practica1 {

    public static void main(String[] args) {
        String entrada;
        String hashEsperado;
        String hashCalculado;
        byte[] hashBytes;
        String hex;

        Scanner lector = new Scanner(System.in);

        // Pedir la entrada
        System.out.print("Introduce el texto: ");
        entrada = lector.nextLine().trim();

        // Pedir el hash esperado
        System.out.print("Introduce el hash esperado (en hexadecimal): ");
        hashEsperado = lector.nextLine().trim();

        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");

            hashBytes = digest.digest(entrada.getBytes(StandardCharsets.UTF_8)); // Generar hash

            StringBuilder hexString = new StringBuilder();

            for (byte b : hashBytes) {
                hex = Integer.toHexString(0xff & b); // Convertir byte a hexadecimal
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }

            hashCalculado = hexString.toString(); // Devolver hash en formato hexadecimal pero en String

            if (hashCalculado.equalsIgnoreCase(hashEsperado)) {
                System.out.println("VERIFICADO: El hash coincide.");
            } else {
                System.out.println("ALERTA: El el hash no coincide. Calculado: " + hashCalculado + ", Esperado: " + hashEsperado);
        }
        } catch (NoSuchAlgorithmException e) {
            System.err.println("ERROR: " + e.getMessage());
        } finally {
            lector.close();
        }
    }
}
