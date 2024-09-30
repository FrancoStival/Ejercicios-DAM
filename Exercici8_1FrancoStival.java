
import java.util.Scanner;

public class Exercici8_1FrancoStival {

    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        int numeroMes;

        System.out.println();
        System.out.println();
        System.out.println("Dime el numero de un més y te diré el nombre: ");

        while (true) {
            
            if (lector.hasNextInt()) {
                numeroMes = lector.nextInt();
                if (numeroMes >= 1 && numeroMes <= 12) {
                    break;
                }else{
                    System.out.println("Introduce un numero de més valido");
                }
            } else {
                System.out.println("Introduce un numero entero.");
                lector.next();
            }
        }

        System.out.print("El nombre del més es: ");
        switch (numeroMes) {
            case 1:
                System.out.println("Enero");
                break;
            case 2:
                System.out.println("Febrero");
                break;
            case 3:
                System.out.println("Marzo");
                break;
            case 4:
                System.out.println("Abril");
                break;
            case 5:
                System.out.println("Mayo");
                break;
            case 6:
                System.out.println("Junio");
                break;
            case 7:
                System.out.println("Julio");
                break;
            case 8:
                System.out.println("Agosto");
                break;
            case 9:
                System.out.println("Septiembre");
                break;
            case 10:
                System.out.println("Octubre");
                break;
            case 11:
                System.out.println("Noviembre");
                break;
            case 12:
                System.out.println("Diciembre");
                break;
            default:
                System.out.println("Error");
        }
    }

}
