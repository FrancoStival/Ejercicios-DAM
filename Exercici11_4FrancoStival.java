import java.util.Scanner;

public class Exercici11_4FrancoStival {
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        int anterior = 0, actual = 0, contador = 0;
        boolean quitaWhile = true;

        System.out.println("Introduce una secuencia de números enteros (introduce un número no válido para finalizar):");

        while (lector.hasNextInt() && quitaWhile) {
            actual = lector.nextInt();

            if (actual == anterior) {
                contador++;
            } else {
                contador = 0;
            }

            if (contador == 2) {
                System.out.println("El primer número que aparece repetido 3 veces consecutivas es: " + actual);
                quitaWhile = false;
            }

            anterior = actual;
        }

        lector.close();
    }
}