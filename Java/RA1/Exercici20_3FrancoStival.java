import java.util.Random;

public class Exercici20_3FrancoStival {
    public static void main(String[] args) {
        Random random = new Random();
        System.out.println();
        int sumar = 0;
        int[] sumarColumna = new int[6];
        int[][] matriu = new int[4][6];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 6; j++) {
                matriu[i][j] = random.nextInt(200) + 1;

            }
        }

        System.out.println("Matriu generada:");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 6; j++) {
                System.out.print(matriu[i][j] + "\t");
                sumar += matriu[i][j];
                sumarColumna[j] += matriu[i][j]; 
            }
            System.out.println("La suma es " + sumar);
            sumar = 0;
            System.out.println();
        }
        System.out.println("Suma de cada columna:");
        for (int j = 0; j < 6; j++) {
            System.out.print(sumarColumna[j] + "\t");
        }
    }
}
