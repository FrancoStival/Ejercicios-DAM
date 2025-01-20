
import java.util.Scanner;

public class Exercici3_1FrancoStival{
    public static void main(String[] args) {
        System.out.println();
        System.out.println();
        System.out.println("Este programa determina que numero es más grande de los que me digas.");
        Scanner lector =  new Scanner(System.in);
        System.out.print("Introduce el primer numero: ");
        int num1 = lector.nextInt();
        System.out.print("Introduce el segundo numero: ");
        int num2 = lector.nextInt();
        int z;
        if  (num1 > num2){
            z = num1;
        }else{
            z = num2;
        }
        System.out.println("El numero más grande és:" + z);
    }
}
