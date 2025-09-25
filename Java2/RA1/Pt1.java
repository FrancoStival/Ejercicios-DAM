package Java2.RA1;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Pt1 {

    public static void main(String[] args) {
        String fileName = "Java2/RA1/data/text.txt";
        try {
            Pt1 practica = new Pt1();
            practica.procesarFichero(fileName);
        } catch (IOException e) {
            System.err.println("Error leyendo el archivo: " + e.getMessage());
        }
    }

    private void procesarFichero(String fileName) throws IOException {
        int totalCharacters = 0;
        int totalLines = 0;
        int totalWords = 0;
        char mostFrequentChar;
        Map<Character, Integer> charCount = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                totalLines++;
                totalCharacters += contarCaracteres(line);
                totalWords += contarPalabras(line);
                contarFrecuencia(line, charCount);
            }
        }

        mostFrequentChar = encontrarCaracterMasFrecuente(charCount);
        mostrarResultados(totalCharacters, totalLines, totalWords, mostFrequentChar, charCount.get(mostFrequentChar));
    }

    private int contarCaracteres(String line) {
        return line.replace("\n", "").length(); // Contar caracteres sin saltos de línea
    }

    private int contarPalabras(String line) {
        return line.trim().split("\\s+").length; // Contar palabras separadas por espacios o tabuladores
    }

    private void contarFrecuencia(String line, Map<Character, Integer> charCount) {
        for (char c : line.toCharArray()) {
            if (Character.isLetter(c)) { // Solo contar letras
                charCount.put(c, charCount.getOrDefault(c, 0) + 1);
            }
        }
    }

    private char encontrarCaracterMasFrecuente(Map<Character, Integer> charCount) {
        char mostFrequentChar = ' ';
        int maxCount = 0;
        for (Map.Entry<Character, Integer> entry : charCount.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                mostFrequentChar = entry.getKey();
            }
        }
        return mostFrequentChar;
    }

    private void mostrarResultados(int totalCharacters, int totalLines, int totalWords, char mostFrequentChar, int maxCount) {
        System.out.println("Total de caracteres (sin saltos de línea): " + totalCharacters);
        System.out.println("Total de líneas: " + totalLines);
        System.out.println("Total de palabras: " + totalWords);
        System.out.println("Carácter que más veces aparece: '" + mostFrequentChar + "' (" + maxCount + " veces)");
    }
}
