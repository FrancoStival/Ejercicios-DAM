
import java.util.Random;
import java.util.Scanner;

public class Exercici9_FrancoStival {

    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        Random random = new Random();
        int jugador = 0, maquina;
        boolean quitaWhile = false;
        
        System.out.println("Vamos a jugar a piedra, papel o tijera.");
        System.out.println("Escribe 1 para piedra, 2 para papel o 3 para tijera: ");
        
        maquina = random.nextInt(2) + 1;
        while(!quitaWhile){
            if (lector.hasNextInt()) {
                jugador = lector.nextInt();
                quitaWhile = true;
            }else{
                System.out.println("No has escrito un número. Vuelve a intentarlo.");
            }
        }

        if (jugador == 1 && maquina == 2) {
            System.out.println("Ha ganado la maquina");
        } else if (jugador == 1class Exercici9_0_1FrancoStival"Ha ganado el jugador");
        }else if (jugador == 2 && maquina == 3){
            System.out.println("Ha ganado la maquina");
        }else if(jugador == 3 && maquina == 1){
            System.out.println("Ha ganado la maquina");
        }else if(jugador == 3 && maquina == 2){
            System.out.println("Ha ganado el jugador");
        }else if (jugador == maquina){
            System.out.println("Ha sido un empate");
        }

 
   }
}