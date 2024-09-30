
import java.util.Scanner;

public class Exercici1_4FrancoStival {
    public static void main(String[] args) {
        Scanner lector =  new Scanner(System.in);
        System.out.println("Vaig a fer un truc de màgia numèrica");
        System.out.print("Introdueix un nombre sencer, el que vulguis: ");
        int num1 =  lector.nextInt();
        int numOriginal = num1;
        num1 = num1 * 3;
        System.out.print("Multiplical per 3");
        System.out.println(". Ara tenim: " +  num1);
        System.out.print("Suma-li 6");
        num1 = num1 + 6;
        System.out.println(". Ara tenim: " +  num1);
        System.out.print("Divideix el resultat entre 3");
        num1 = num1 / 3;
        System.out.println(". Ara tenim: " +  num1);
        System.out.println("Resta-li " + numOriginal);
        num1 = num1 - numOriginal;
        System.out.println("El resultat és : " +  num1);
        System.out.println("");
        System.out.println("Dona igual el nombre que posis, el resultat final serà sempre 2.");

    }
}
