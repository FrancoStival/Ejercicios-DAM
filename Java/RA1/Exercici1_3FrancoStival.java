
import java.util.Scanner;

public class Exercici1_3FrancoStival {
    public static void main(String[] args) {
        Scanner lector =  new Scanner(System.in);
        System.out.print("Introdueix el teu nom complet: ");
        String nom = lector.nextLine();
        System.out.print("Que vas estudiar l'any passat?: ");
        String estudis = lector.nextLine();
        System.out.print("Quina edat tens?: ");
        int edat = lector.nextInt();
        System.out.println("El meu nom és:  " + nom);
        System.out.println("L'any passat vaig estudiar: "  + estudis);
        System.out.println("Tinc " + edat + " anys.");
    }
}
