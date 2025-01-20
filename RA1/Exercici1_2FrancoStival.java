
import java.util.Scanner;

public class Exercici1_2FrancoStival{
    public static void main(String[] args) {
        Scanner lector =  new Scanner(System.in);
        int anyNaixement;
        System.out.println("Quina edat tens?");
        int edat1 = lector.nextInt();
        System.out.println("Ha passat el teu aniversari?");
        System.out.println("Escriu True o False");
        boolean aniversari = lector.nextBoolean();
        System.out.print("En quin any estem?:");
        int any = lector.nextInt();
        if (aniversari == true){
            anyNaixement = any - edat1;
            System.out.println("Has nascut l'any " + anyNaixement);
         } else{
                anyNaixement = any - edat1 - 1;
                System.out.println("Has nascut l'any " + anyNaixement);
         }
    }
}
//Creat per Franco Stival Martincich
//Creat el 18 de Setembre de 2024