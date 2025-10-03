import java.io.*;
import java.util.Scanner;

public class Pt2_Xifrat_Cesar {
    public static void main(String[] args) {
        String entrada = "data/entrada.txt";
        String xifrat = "data/xifrat.txt";
        String desxifrat = "data/desxifrat.txt";

        Scanner lector = new Scanner(System.in);
        System.out.print("Introdueix la clau (nombre enter): ");
        int clau = lector.nextInt();

        try {
            // Xifrar
            BufferedReader fixerEntrada = new BufferedReader(new FileReader(entrada));
            BufferedWriter fixerXifrat = new BufferedWriter(new FileWriter(xifrat));

            String linia;
            while ((linia = fixerEntrada.readLine()) != null) {
                // Invertir línia
                String invertida = new StringBuilder(linia).reverse().toString();

                // Aplicar Cèsar (suma clau a cada caràcter)
                StringBuilder xifrada = new StringBuilder();
                for (char c : invertida.toCharArray()) {
                    xifrada.append((char)(c + clau));
                }

                // Escriure al fitxer xifrat
                fixerXifrat.write(xifrada.toString());
                fixerXifrat.newLine();
            }
            fixerEntrada.close();
            fixerXifrat.close();
            System.out.println("Xifrat complet. Fitxer creat: " + xifrat);

            // Desxifrar
            fixerEntrada = new BufferedReader(new FileReader(xifrat));
            fixerXifrat = new BufferedWriter(new FileWriter(desxifrat));

            while ((linia = fixerEntrada.readLine()) != null) {
                // Desfer el Cèsar (restar la clau)
                StringBuilder desxifrada = new StringBuilder();
                for (char c : linia.toCharArray()) {
                    desxifrada.append((char)(c - clau));
                }

                // Invertir altra vegada per obtenir l'original
                String original = desxifrada.reverse().toString();

                fixerXifrat.write(original);
                fixerXifrat.newLine();
            }
            fixerEntrada.close();
            fixerXifrat.close();
            System.out.println("Desxifrat complet. Fitxer creat: " + desxifrat);

        } catch (IOException e) {
            System.out.println("Error d'entrada/sortida: " + e.getMessage());
        }
        finally {
            lector.close();
    }
}
}
