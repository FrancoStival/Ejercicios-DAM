
import java.util.Scanner;

public class Exercici2_3FrancoStival {
    public static void main(String[] args) {
        System.out.println("");
        System.out.println("");
        System.out.println("Este programa te dirá si un numero entero es positivo, negativo o es cero");
        Scanner lector =  new Scanner(System.in);
        System.out.println("Introduce un número entero");
        int numero = lector.nextInt();
        if (numero > 0){
            System.out.println("El número es positivo");
        }else if (numero < 0){
            System.out.println("El número es negativo");
        }else{
            System.out.println("El número es cero");
        }
    }
}
