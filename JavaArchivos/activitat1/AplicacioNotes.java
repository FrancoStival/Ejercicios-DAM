package activitat1;

import java.io.*;
import java.text.DecimalFormat;
import java.util.Locale;

public class AplicacioNotes {

    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);

        File f = new File("notes.txt");

        try (BufferedReader br = new BufferedReader(new FileReader(f));
                BufferedWriter bw = new BufferedWriter(new FileWriter("salida.txt"))) {

            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" ");
                String nombre = parts[0] + " " + parts[1];
                double sumaNotas = 0;
                int numNotas = parts.length - 2;

                for (int i = 2; i < parts.length; i++) {
                    sumaNotas += Double.parseDouble(parts[i]);
                }

                double media = sumaNotas / numNotas;
                String mediaFormateada = new DecimalFormat("####.##").format(media);

                bw.write(nombre + " - Mitjana: " + mediaFormateada + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
