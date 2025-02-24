
import java.util.Scanner;

public class Exercici10FrancoStival {

    public static void main(String[] args) {

        Scanner lector = new Scanner(System.in);
        int horaEntrada, horaSalida, minutoEntrada, minutoSalida, horasParking, minutosParking, tiempoTotal;
        double precio = 0;

        System.out.println();
        System.out.println();
        System.out.println("Introduzca la hora de entrada (Formato 24h)");
        while (true) {
            if (lector.hasNextInt()) {
                horaEntrada = lector.nextInt();
                break;
            } else {
                System.out.println("Error: La entrada debe ser un número entero.");
                lector.next();
            }
        }

        System.out.println("Introduzca los minutos de entrada");
        while (true) {
            if (lector.hasNextInt()) {
                minutoEntrada = lector.nextInt();
                break;
            } else {
                System.out.println("Error: La entrada debe ser un número entero.");
                lector.next();
            }
        }

        System.out.println("Introduzca la hora de salida (Formato 24h");
        while (true) {
            if (lector.hasNextInt()) {
                horaSalida = lector.nextInt();
                break;
            } else {
                System.out.println("Error: La entrada debe ser un número entero.");
                lector.next();
            }
        }

        System.out.println("Introduzca los minutos de salida");
        while (true) {
            if (lector.hasNextInt()) {
                minutoSalida = lector.nextInt();
                break;
            } else {
                System.out.println("Error: La entrada debe ser un número entero.");
                lector.next();
            }
        }

        if (horaSalida == 0) {
            horaSalida = 24;
        }

        horasParking = horaSalida - horaEntrada;
        minutosParking = minutoSalida - minutoEntrada;
        tiempoTotal = (horasParking * 60) + minutosParking;

        if (tiempoTotal >= 1 && tiempoTotal <= 30) {
            precio = tiempoTotal * 0.057750;
        } else if (tiempoTotal >= 31 && tiempoTotal <= 120) {
            precio = tiempoTotal * 0.055;
        } else if (tiempoTotal >= 121 && tiempoTotal <= 418) {
            precio = tiempoTotal * 0.05;
        } else if (tiempoTotal >= 419) {
            precio = 20.95;
        } else {
            System.out.println("Error");
        }
        System.out.println("El tiempo total de estacionamiento es de " + tiempoTotal + ". El importe total a pagar es de $" + precio + ".");

    }
}
