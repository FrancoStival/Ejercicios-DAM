import java.util.Random;

public class Exercici17_4FrancoStival {
    public static void main(String[] args) {
        Random random = new Random();
        int[] llista1 = new int[15];
        int[] llista2 = new int[15];
        int contarParells = 0;
        
        for (int i = 0; i < llista1.length; i++) {
            llista1[i] = random.nextInt(51) + 50;
        }
        System.out.println("Llista 1: ");
        
        for (int i = 0; i < llista1.length; i++) {
            System.out.print(llista1[i] + " ");
        }
        
        for (int i = 0; i < llista1.length; i++) {
            if (llista1[i] % 2 == 0) {
                llista2[contarParells] = llista1[i];
                contarParells++;
            }
        }

        System.out.println();
        System.out.println("Llista 2: ");
        for (int i = 0; i < llista2.length; i++) {
            System.out.print(llista2[i] + " ");
        }
        System.out.println();
    }
}
