import java.util.Random;
import java.util.Scanner;

public class Exercici20_5FrancoStival {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int[][] notes = new int[3][15];

        System.out.print("Introdueix el grup (1, 2 o 3) per assignar notes: ");
        int grup = scanner.nextInt();
        if (grup < 1 || grup > 3) {
            System.out.println("Grup no vàlid. Ha de ser 1, 2 o 3.");

        }
        for (int i = 0; i < 15; i++) {
            notes[grup - 1][i] = random.nextInt(11);
        }
        System.out.println("Notes assignades al grup " + grup + ":");
        for (int i = 0; i < notes.length; i++) {
            System.out.print("Grup " + (i + 1) + ": ");
            for (int j = 0; j < notes[i].length; j++) {
                System.out.print(notes[i][j] + " ");
            }
            System.out.println();
        }

        System.out.print("Introdueix el grup (1, 2 o 3) per modificar una nota: ");
        grup = scanner.nextInt();
        if (grup < 1 || grup > 3) {
            System.out.println("Grup no vàlid. Ha de ser 1, 2 o 3.");
        }
        System.out.print("Introdueix el número de l'alumne (1 a 15): ");
        int alumne = scanner.nextInt();
        if (alumne < 1 || alumne > 15) {
            System.out.println("Número d'alumne no vàlid. Ha de ser entre 1 i 15.");
        }
        System.out.print("Introdueix la nova nota per l'alumne " + alumne + ": ");
        int novaNota = scanner.nextInt();
        if (novaNota < 0 || novaNota > 10) {
            System.out.println("Nota no vàlida. Ha de ser entre 0 i 10.");
        }
        notes[grup - 1][alumne - 1] = novaNota;

        System.out.println("Notes actualitzades:");
        for (int i = 0; i < notes.length; i++) {
            System.out.print("Grup " + (i + 1) + ": ");
            for (int j = 0; j < notes[i].length; j++) {
                System.out.print(notes[i][j] + " ");
            }
            System.out.println();
        }

        for (int i = 0; i < 3; i++) {
            int suma = 0;
            for (int nota : notes[i]) {
                suma += nota;
            }
            double mitjana = (double) suma / notes[i].length;
            System.out.println("La nota mitjana del grup " + (i + 1) + " és: " + String.format("%.2f", mitjana));
        }

        scanner.close();
    }
}