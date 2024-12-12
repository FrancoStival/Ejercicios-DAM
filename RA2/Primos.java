package RA2;

import java.util.Scanner;

public class Primos {
    public static void main(String[] args) {

        System.out.println("Escribe un numero");
        Scanner lector = new Scanner(System.in);
        int numero = lector.nextInt();
        int contador = 0;
        for (int i = 1; i < (numero + 1); i++) {
            if (numero % i == 0) {
                contador++;
            }
        }
        if (contador == 2) {
            System.out.println("El numero es primo");
        } else
            System.out.println("El numero no es primo");
    }
}
