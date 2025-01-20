
import java.util.Scanner;


public class Exercici9_2FrancoStival {

    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        boolean quitaWhile = false;
        int numero = 0;

        System.out.println("");
        System.out.println("Dime un numero y te la tabla de multiplicar de ese numero");
        while (!quitaWhile){
            if (lector.hasNextInt()){
                numero = lector.nextInt();
                quitaWhile = true;
            }else{
                System.out.println("Introduce un numero entero valido.");
                lector.next();
            }
        }

        System.out.println();
        
        for (int i = 1; i <= 10; i++) {
            System.out.println(numero + " por " + i + " es igual a " + (numero * i));
        }
    }
}


