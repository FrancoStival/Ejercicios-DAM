
import java.util.Scanner;

public class Exercici1_1FrancoStival{
    public static void main(String[] args) {
        Scanner lector = new Scanner (System.in);
        System.out.println("Haré 4 operaciones con los dos numeros que me digas");
        System.out.print("Introduce el primer número: ");
        int num1 = lector.nextInt();
        System.out.print("Introduce el segundo número: ");
        int num2 = lector.nextInt();
        int suma1 = num1  + num2;
        int resta1 = num1 - num2;
        int multiplicacion1 = num1 * num2;
        int division1 = num1 / num2;
        System.out.println("La suma es: " + suma1);
        System.out.println("La resta es: " + resta1);
        System.out.println("La multiplicación es: " + multiplicacion1);
        System.out.println("La división es: " + division1);
        
    }
}

