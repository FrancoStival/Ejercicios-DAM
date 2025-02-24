
import java.util.Scanner;

public class Exercici1_6FrancoStival {
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        System.out.println("Este programa sirve para intercambiar el valor que tienen 2 variables diferentes");
        System.out.println("Usaré 2 numeros que tu me eligas, dime el primero: ");
        int num1 = lector.nextInt();
        System.out.println("Dime el segundo: ");
        int num2 = lector.nextInt();
        int num3 = num1;
        num1 = num2;
        num2 = num3;
        System.out.println("El primer numero está en la segunda variable: " + num2);
        System.out.println("El segundo numero está en la primer     a variable: " + num1);
    }
}
