
import java.util.Scanner;

public class Exercici2_2FrancoStival {
    public static void main(String[] args) {
        Scanner lector  = new Scanner(System.in);
        System.out.println("Este programa te dirá el porcentaje de vacas y cerdos");
        System.out.println("Introduce el número de vacas");
        double vacas = lector.nextDouble();
        System.out.println("Introduce el número de cerdos");
        double cerdos = lector.nextDouble();
        double total = vacas + cerdos;
        double porcentajeVacas = (vacas * 100) / total;
        double porcentajeCerdos = (cerdos * 100) / total;
        System.out.println("El porcentaje de vacas es: " + porcentajeVacas + "%" +
        " y el porcentaje de cerdos es: " + porcentajeCerdos +  "%");

        if  (porcentajeVacas > porcentajeCerdos) {
            System.out.println("El porcentaje de vacas es mayor que el de cerdos");
        } else if (porcentajeCerdos > porcentajeVacas) {
                System.out.println("El porcentaje de cerdos es mayor que el de vacas");
        } else {
                 System.out.println("El porcentaje de vacas y cerdos es igual");
        }
    }
}
