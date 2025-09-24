package Java2.RA1;

import java.io.*;
import java.util.*;

public class Practica1 {
    public static void main(String[] args) {
        // Canviar la ruta del fitxer segons la ubicació real
        String fileName = "Java2/RA1/text.txt";
        int totalChars = 0;
        int totalLines = 0;
        int totalWords = 0;
        Map<Character, Integer> charCount = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                totalLines++;
                totalChars += line.length();
                String[] words = line.trim().split("\\s+");
                if (!line.trim().isEmpty()) {
                    totalWords += words.length;
                }
                for (char c : line.toCharArray()) {
                    if (c != '\n' && c != '\r' && c != ' ') { // No contar espacios
                        charCount.put(c, charCount.getOrDefault(c, 0) + 1);
                    }
                }
            }
            // Trobar el caràcter més repetit
            char mostFrequent = 0;
            int maxCount = 0;
            for (Map.Entry<Character, Integer> entry : charCount.entrySet()) {
                if (entry.getValue() > maxCount) {
                    maxCount = entry.getValue();
                    mostFrequent = entry.getKey();
                }
            }
            System.out.println("Total de caràcters (sense salts de línia): " + totalChars);
            System.out.println("Total de línies: " + totalLines);
            System.out.println("Total de paraules: " + totalWords);
            System.out.println("El caràcter que més vegades apareix: '" + mostFrequent + "' (" + maxCount + " vegades)");
        } catch (FileNotFoundException e) {
            System.out.println("Fitxer no trobat: " + fileName);
        } catch (IOException e) {
            System.out.println("Error de lectura del fitxer.");
        }
    }
}

