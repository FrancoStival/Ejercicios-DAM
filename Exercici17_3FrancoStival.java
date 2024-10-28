import java.util.Random;

public class Exercici17_3FrancoStival {
    public static void main(String[] args) {
        Random random = new Random();
        int[] llista1 = new int[12];
        int[] llista2 = new int[12];
        for (int i = 0; i < llista1.length; i++) {
            llista1[i] = random.nextInt(99) + 1;
            llista2[i] = llista1[i] * 2;
            System.out.println();
        }
        System.out.println("Llista 1: ");
        for (int i = 0; i < llista1.length; i++) {
            System.out.print(llista1[i] + " ");
        }
        System.out.println();
        System.out.println("Llista 2: ");
        for (int i = 0; i < llista2.length; i++) {
            System.out.print(llista2[i] + " ");
        }
        System.out.println();
    }
}
