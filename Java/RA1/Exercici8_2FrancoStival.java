import java.util.Scanner;

public class Exercici8_2FrancoStival {
    
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        int numeroMes;

        System.out.println();
        System.out.println();
        System.out.println("Dime el numero de un més y te diré el numero de dias que tiene ese més: ");

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

        System.out.print("El més tiene: ");
        switch (numeroMes) {
            case 1 :
                System.out.println("31 dias.");
                break;
            case 2:
                System.out.println("28 dias.");
                break;
            case 3:
                System.out.println("31 dias.");
                break;
            case 5:
                System.out.println("31 dias.");
                break;
            case 7:
                System.out.println("31 dias.");
                break;
            case 8:
                System.out.println("31 dias.");
                break;
            case 10:
                System.out.println("31 dias.");
                break;
            case 12:
                System.out.println("31 dias.");
                break;
            default:
                System.out.println("30 dias.");
        }
    }

}
