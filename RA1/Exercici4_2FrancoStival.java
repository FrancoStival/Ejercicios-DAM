
import java.util.Scanner;

public class Exercici4_2FrancoStival {
    public static void main(String[] args) {
        System.out.println("");
        System.out.println("");
        Scanner lector = new Scanner(System.in);
        double nota;
        System.out.println("Escribe tu nota y te diré si has aprobado y por cuanto");
        
        while (true) {   
            nota = lector.nextDouble();
                if (nota <= 10) {
                    break;
                }else{
                    System.out.println("Has puesto una nota incorrecta.");
                }
        }

        if (nota < 5) {
            System.out.println("Has suspendido");
        }else if (nota == 5) {
            System.out.println("Has aprobado");
        }else if(nota  >= 6 && nota < 7){
            System.out.println("Has sacado un bien");
        }else if (nota >= 7 && nota <= 9){
            System.out.println("Has sacado un notable");
        }else if (nota > 9 && nota <= 10){
            System.out.println("Has sacado un excelente");
        }else{
            System.out.println("Error");
        }

    }
}

