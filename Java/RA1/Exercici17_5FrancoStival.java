import java.util.Random;

public class Exercici17_5FrancoStival {
    public static void main(String[] args) {
        Random random = new Random();
        int[] contador = new int[6];
        for (int i = 0; i < 100; i++) {
            int llançament = random.nextInt(6) + 1;
            contador[llançament  - 1]++;
        }
        for (int i = 0; i < contador.length; i++) {
            System.out.print((i +1) + ": ");
            for  (int j = 0; j < contador[i]; j++) {
                System.out.print("■");
                
            }
            System.out.println();
        }
        System.out.println();
    }
}
