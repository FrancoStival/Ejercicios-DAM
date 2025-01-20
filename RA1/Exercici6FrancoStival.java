
import java.util.Scanner;

public class Exercici6FrancoStival {
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        int dinero;
        System.out.println();
        System.out.println();
        
        System.out.println("Introduce una cantidad de dinero, en centimos: ");

        while (true) { 
            if (lector.hasNextInt()) {
                dinero = lector.nextInt();
                break; 
            } else {
                System.out.println("Error: La entrada debe ser un número entero.");
                lector.next();
            }
        }

        int monedas200 = dinero / 200;
        dinero %= 200;
        int monedas100 = dinero / 100;
        dinero %= 100;
        int monedas50 = dinero / 50;
        dinero %= 50;
        int monedas20 = dinero / 20;
        dinero %= 20;
        int monedas10 = dinero / 10;
        dinero %= 10;
        int monedas5 = dinero / 5;
        dinero %= 5;
        int monedas2 = dinero / 2;
        dinero %= 2;
        int monedas1 = dinero;

        if (monedas200 > 0) {
            System.out.println(monedas200 + " monedas de 2 euros");
        }
        if (monedas100 > 0) {
            System.out.println(monedas100 + " monedas de 1 euro");
        }
        if (monedas50 > 0) {
            System.out.println(monedas50 + " monedas de 50 cèntimos de euro");
        }
        if (monedas20 > 0) {
            System.out.println(monedas20 + " monedas de 20 cèntimos de euro");
        }   
        if (monedas10 > 0) {
            System.out.println(monedas10 + " monedas de 10 cèntimos de euro");
        }
        if (monedas5 > 0) {
            System.out.println(monedas5 + " monedas de 5 cèntimos de euro");
        }
        if (monedas2 > 0) {
            System.out.println(monedas2 + " monedas de 2 cèntimos de euro");
        }
        if (monedas1 > 0) {
            System.out.println(monedas1 + " monedas de 1 cèntimo de de euro");
        }

    }
}
