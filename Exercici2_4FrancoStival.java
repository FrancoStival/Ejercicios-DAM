
import java.util.Scanner;

public class Exercici2_4FrancoStival {
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        System.out.println("Introduce el primer numero: ");
        double num1 = lector.nextDouble();
        System.out.println("Introduce el segundo numero: ");
        double num2 =  lector.nextDouble();
        if (num1 == num2){
            System.out.println("Los numeros no pueden ser iguales");
            System.exit(0); //Esto cierra el programa
        }
        
        if  (num1 > num2 && num2 != 0){ //Los dos & son AND
            System.out.println("El primer numero es mayor");
            double division = num1 /  num2;
            System.out.println("La division es: " + division);
        }else if (num2 > num1 && num1 != 0){
            System.out.println("El segundo numero es mayor");
            double division = num2 / num1;
            System.out.println("La division es: " + division);
        }else if (num2 == 0 || num1 == 0){ //Las dos barras || es un OR
            System.out.println("El numero más pequeño no puede ser 0");
        }
    }
}