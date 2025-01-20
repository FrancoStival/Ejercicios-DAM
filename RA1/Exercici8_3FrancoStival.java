
import java.util.Scanner;

public class Exercici8_3FrancoStival {

    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);

        int signo;
        String categoria;

        System.out.println("De la siguiente tabla:");
        System.out.println("+---------------+---------------+");
        System.out.println("|  Número  |  Signo  |");
        System.out.println("+---------------+---------------+");
        System.out.println("|  1      |  Aries  |");
        System.out.println("|  2      |  Capricorn |");
        System.out.println("|  3      |  Balança  |");
        System.out.println("|  4      |  Cranc  |");
        System.out.println("|  5      |  Lleó  |");
        System.out.println("|  6      |  Taure  |");
        System.out.println("|  7      |  Aquari  |");
        System.out.println("|  8      |  Escorpió  |");
        System.out.println("|  9      |  Sagitari  |");
        System.out.println("|  10     |  Verge  |");
        System.out.println("|  11     |  Bessons  |");
        System.out.println("|  12     |  Peixos  |");
        System.out.println("+---------------+---------------+");
        System.out.print("Introduce el numero asociado a tu signo zodiacal: ");

        while (true) {

            if (lector.hasNextInt()) {
                signo = lector.nextInt();
                if (signo >= 1 && signo <= 12) {
                    break;
                } else {
                    System.out.println("Introduce un numero de zodiaco valido");
                }
            } else {
                System.out.println("Introduce un numero entero.");
                lector.next();
            }
        }

        switch (signo) { //Cuando quiero que varios casos den un mismo Output, se puede hacer así:
            case 1:
            case 5:
            case 9:
                categoria = "Fuego";
                break;
            case 2:
            case 6:
            case 10:
                categoria = "Tierra";
                break;
            case 3:
            case 7:
            case 11:
                categoria = "Aire";
                break;
            case 4:
            case 8:
            case 12:
                categoria = "Agua";
                break;
            default:
                categoria = "ERROR: " + signo + " no asociado a ningun signo.";
        }

        System.out.println("La categoria del signo seleccionado es: " + categoria);
    }
}
