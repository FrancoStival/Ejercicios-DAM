import java.util.Random;
import java.util.Scanner;

public class Exercici20_4FrancoStival {
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        Random random = new Random();
        
        int n;
        do {
            System.out.print("Introdueix un nombre enter n (3-20): ");
            n = lector.nextInt();
        } while (n <= 2 || n > 20);

        int[][] matriu = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matriu[i][j] = random.nextInt(50) + 1;
            }
        }

        System.out.println("Matriu generada:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matriu[i][j] + "\t");
            }
            System.out.println();
        }

        System.out.print("Introdueix un nombre enter per comptar les seves aparicions: ");
        int num = lector.nextInt();

        int comptador = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matriu[i][j] == num) {
                    comptador++;
                }
            }
        }

        System.out.println("El nombre " + num + " apareix " + comptador + " vegades a la matriu.");

        lector.close();
    }
}