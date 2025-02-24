import java.io.*;
import java.util.*;

public class logins {
    public static void main(String[] args) {
        // Ruta del fitxer d'entrada
        String rutaFitxerEntrada = "usuaris.txt";
        // Ruta del fitxer de sortida
        String rutaFitxerSortida = "logins_passwords.txt";

        crearArchivoEntrada(rutaFitxerEntrada);
        // Llista per emmagatzemar les dades d'usuaris
        List<String> usuaris = new ArrayList<>();
        
        // Llegir el fitxer d'entrada
        try (BufferedReader br = new BufferedReader(new FileReader(rutaFitxerEntrada))) {
            String linia;
            while ((linia = br.readLine()) != null) {
                usuaris.add(linia.trim());
            }
        } catch (IOException e) {
            System.out.println("Error llegint el fitxer d'entrada: " + e.getMessage());
            return;
        }

        // Obrir el fitxer de sortida per escriure
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(rutaFitxerSortida))) {
            // Variable per al password
            int passwordSeq = 1;

            for (String usuari : usuaris) {
                // Dividir el nom i els cognoms
                String[] parts = usuari.split(",");
                if (parts.length < 2) continue;  // Ignorar línies incorrectes

                String cognoms = parts[0].trim();
                String nom = parts[1].trim();

                // Obtenir login (inicial del nom + primer cognom)
                String[] cognomsParts = cognoms.split(" ");
                String login = nom.substring(0, 1).toLowerCase() + cognomsParts[0].toLowerCase();

                // Crear el password amb 4 xifres (seqüencial)
                String password = String.format("%04d", passwordSeq++);

                // Escriure el login i el password al fitxer
                bw.write(login + "," + password);
                bw.newLine();
            }
            System.out.println("Logins i passwords creats amb èxit!");
        } catch (IOException e) {
            System.out.println("Error escrivint al fitxer de sortida: " + e.getMessage());
        }
    }
    private static void crearArchivoEntrada(String rutaEntrada) {
        // Verificar si el archivo ya existe, si no, crearlo
        File archivo = new File(rutaEntrada);
        if (archivo.exists()) return;  // Si ya existe, no lo creamos de nuevo

        // Crear el archivo con algunos usuarios de ejemplo
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaEntrada))) {
            writer.write("Olivar Puig, Xavier");
            writer.newLine();
            writer.write("Lluch Saiz, Josep Maria");
            writer.newLine();
            writer.write("Pont Carrera, Adriana");
            writer.newLine();
            writer.write("Llana Figueres, Josep");
            writer.newLine();
            writer.write("Martinez Colell, Ana");
            writer.newLine();
            writer.write("Pico Cruz, Francesc");
            writer.newLine();
            writer.write("Seuma Solans, Pere");
            writer.newLine();
            writer.write("Palau Pou, Carme");
            writer.newLine();
            writer.write("Merino Gonzalez, Victor");
            writer.newLine();
            writer.write("Sentis Corona, Robert");
            writer.newLine();
            System.out.println("Archivo de entrada creado con éxito.");
        } catch (IOException e) {
            System.out.println("Error creando el archivo de entrada: " + e.getMessage());
        }
    }
}
