import java.util.Random;

public class Exercici17_6FrancoStival {
    public static void main(String[] args) {
        Random random = new Random();
        int[] contador = new int[21];
        for (int i = 0; i < 100; i++) {
            int pes = random.nextInt(21) + 30;
            contador[pes - 30]++;
        }
        System.out.println("Pesos   Nombre de persones");
        for (int i = 0; i < contador.length; i++) {
            System.out.print((i + 30) + ": ");
            for  (int j = 0; j < contador[i]; j++) {
                System.out.print("■");
                
            }
            System.out.println();
        }
        System.out.println();
    }
}
