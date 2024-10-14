import java.util.Scanner;

public class Exercici_Aire_Acondicionat {
    public static void main(String[] args) {
        int clases, tempClase, tempClasReducida;
        Scanner lector = new Scanner(System.in);
        clases = lector.nextInt();

        for (int i = 0; i < clases; i++) {
            tempClase = lector.nextInt();
            tempClasReducida = (tempClase % 360 + 360) % 360;
            switch (tempClasReducida) {
                case 0:
                case 180:
                    System.out.println("OK");
                    break;
                default:
                System.out.println("BRONCA");
                    break;
            }
        }
    }
}
