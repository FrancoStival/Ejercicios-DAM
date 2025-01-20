import java.util.Scanner;
public class Exercici2_1FrancoStival {
    public static void main(String[] args) {
        System.out.println("Este programa te dirá si un numero que tu me pases es par o impar");
        Scanner lector = new Scanner(System.in);
        System.out.println("Introduce un número");
        int num = lector.nextInt();
        if (num % 2 == 0) {
            System.out.println("El número es par");
            } else {
                System.out.println("El número es impar");
                }
    }
}
