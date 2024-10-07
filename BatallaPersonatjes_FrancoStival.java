
import java.util.Random;
import java.util.Scanner;

public class BatallaPersonatjes_FrancoStival {

    public static void main(String[] args) {
        int vida1, vida2, dañoMin1, dañoMin2, dañoMax1, dañoMax2, dañoAtaque1, dañoAtaque2, turno, cambioTurno;
        String nom1, nom2;
        Random random = new Random();
        Scanner lector = new Scanner(System.in);
        vida1 = random.nextInt(49, 99) + 1;
        vida2 = random.nextInt(49, 99) + 1;
        dañoMin1 = random.nextInt(4, 9) + 1;
        dañoMin2 = random.nextInt(4, 9) + 1;
        dañoMax1 = random.nextInt(14, 19) + 1;
        dañoMax2 = random.nextInt(14, 19) + 1;
        turno = 1;
        cambioTurno = random.nextInt(1);

        System.out.println();
        System.out.println();
        
        System.out.println("Introduce el nombre del primer luchador: ");
        nom1 = lector.next();
        System.out.println("Introduce el nombre del segundo luchador: ");
        nom2 = lector.next();

        do { 
            dañoAtaque1 = random.nextInt(dañoMin1, dañoMax1);
            dañoAtaque2 = random.nextInt(dañoMin2, dañoMax2);
            switch (cambioTurno) {
                case 0:
                    System.out.println();
                    System.out.println("Turno " + turno + ":");
                    vida2 -= dañoAtaque1; 
                    System.out.println(nom1 + " ataca a " + nom2 + ". Haciendo " +  dañoAtaque1 + " puntos de daño.");
                    System.out.println(nom2 + " tiene " + vida2 + " puntos de vida.");
                    turno += 1;
                    cambioTurno = 1;
                    break;
                case 1:
                    System.out.println();
                    System.out.println("Turno " + turno + ":");
                    vida1 -= dañoAtaque2;
                    System.out.println(nom2 + " ataca a " + nom1 + ". Haciendo " + dañoAtaque2 + " puntos de daño.");
                    System.out.println(nom1 + " tiene " + vida1 + " puntos de vida.");
                    turno += 1;
                    cambioTurno = 0;
                    break;
                default:
                    System.out.println("Error");
                    break;
            }
        } while (vida1 > 0  && vida2 > 0);
        
        System.out.println();
        
        if(vida1 >=  vida2){
            System.out.println(nom1 + " ha ganado la batalla.");
        }else{
            System.out.println(nom2 + " ha ganado la batalla.");
}
        
    }
}
