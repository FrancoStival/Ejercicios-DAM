import java.util.Scanner;

public class Exercici11_7FrancoStival {
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        int num = 0, inicial1 = 1, inicial3 = 5;;
        boolean quitaWhile = false;
        System.out.println("Introduce el numero de terminos de la sequencia: ");
        
        while (!quitaWhile) {
            if (lector.hasNextInt()) {
                num = lector.nextInt();
                quitaWhile = true;
            } else {
                System.out.print("Porfavor, introduzca un número válido: ");
                lector.next();
            }
        }
        
        for (int i = 0; i < num; i++) {
            if (i % 2 == 0) {
                System.out.print(inicial1 + ", ");
                inicial1 = inicial1 + 2;
            } else {
                System.out.print(inicial3 + ", ");
                inicial3 = inicial3 + 2;
            }
        }
        System.out.println();
        lector.close();
    }
}
