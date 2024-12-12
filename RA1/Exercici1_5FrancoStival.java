
import java.util.Scanner;

public class Exercici1_5FrancoStival {
    public static void main(String[] args) {
        Scanner lector =  new Scanner(System.in);
        System.out.println("Los estadounidenses siempre quieren complicar las cosas con su sistema imperial");
        System.out.println("Para solucionar eso, este programa te ayudará a convertir de grados Farenheit a Celsius");
        System.out.println("Cual es la temperatura en Farenheit que quieres convertir?: ");
        double farenheit = lector.nextDouble();
        double celsius = (farenheit - 32) * 5/9;
        System.out.println(farenheit + "º en grados Farenheit son " + celsius + "º en Celsius");
    }
}
