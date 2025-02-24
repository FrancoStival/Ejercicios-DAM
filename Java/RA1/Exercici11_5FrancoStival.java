import java.util.Scanner;

public class Exercici11_5FrancoStival {
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        int num = 0, cantidadCifras = 0;
        boolean quitaWhile = false;
        System.out.print("Introduce un número: ");
        
        while (!quitaWhile) {
            if (lector.hasNextInt()) {
                num = lector.nextInt();
                quitaWhile = true;
            } else {
                System.out.print("Porfavor, introduzca un número válido: ");
                lector.next();
            }
        }      
        if (num < 0) {
            num = num * -1;
        }
        
        System.out.println(num);
        if (num == 0) {
            cantidadCifras = 1;
        } else {
            while (num > 0) {
                num /= 10;
                cantidadCifras++; 
            }
        }
        
        System.out.println("La cantidad de cifras del número es: " + cantidadCifras);
        
        lector.close();
    }
}