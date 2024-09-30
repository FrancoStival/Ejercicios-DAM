
import java.util.Scanner;

public class ActivitatAvaluable1_FrancoStival {

    public static void main(String[] args) {

        Scanner lector = new Scanner(System.in);
        int edat, alçada, pes, flexions, alçadasalt, perfilPercentualInicial = 0;
        double tempsCarrera, resistenciaCardiovascular;

        System.out.println();
        System.out.println();
        System.out.println("Benvigut a l'Agència Espacial Internacional.");
        System.out.println("A continuació, comprovarem si ets adequat per al post");
        System.out.print("Introdueix el teu edat: ");
        while (true) {
            if (lector.hasNextInt()) {
                edat = lector.nextInt();
                break;
            } else {
                System.out.println("Error, introdueix un nombre senser.");
                lector.next();
            }
        }
        System.out.print("Introdueix la teva alçada (en cm): ");
        while (true) {
            if (lector.hasNextInt()) {
                alçada = lector.nextInt();
                break;
            } else {
                System.out.println("Error, introdueix un nombre senser.");
                lector.next();
            }
        }
        System.out.print("Introdueix el teu pes (en kg): ");
        while (true) {
            if (lector.hasNextInt()) {
                pes = lector.nextInt();
                break;
            } else {
                System.out.println("Error, introdueix un nombre senser.");
                lector.next();
            }
        }

        System.out.println();

        if (edat >= 25 && edat <= 40) {
            System.out.println("Edat correcta");
            if (alçada >= 160 && alçada <= 190) {
                System.out.println("Alçada correcta");
                if (pes >= 50 && pes <= 100) {
                    System.out.println("Pes correcte");
                    System.out.println("Has complert amb els criteris basic");
                    perfilPercentualInicial = perfilPercentualInicial + 15;
                } else {
                    System.out.println("Pes incorrecte");
                    System.out.println("Ho sento, no compleixes amb els criteris bàsics per al viatge espacial.");
                    System.exit(0);
                }

            } else {
                System.out.println("Alçada minima no requerida");
                System.out.println("Ho sento, no compleixes amb els criteris bàsics per al viatge espacial.");
                System.exit(0);

            }
        } else {
            System.out.println("Edat minima no complida");
            System.out.println("Ho sento, no compleixes amb els criteris bàsics per al viatge espacial.");
            System.exit(0);
        }

        System.out.println();
        System.out.println("Ara pasarem al Desafiament d'Entrenament Físic");
        System.out.print("En quant de temps pots correr 5 km? (Escriu la resposta en minuts):");
        while (true) {
            if (lector.hasNextInt()) {
                tempsCarrera = lector.nextInt();
                break;
            } else {
                System.out.println("Error, introdueix un nombre senser.");
            }
        }
        System.out.print("Quantes flexions pots fer en 60 segons?: ");
        while (true) {
            if (lector.hasNextInt()) {
                flexions = lector.nextInt();
                break;
            } else {
                System.out.println("Error, introdueix un nombre senser.");
            }
        }
        System.out.print("Altura màxima en salt vertical (en cm)?: ");
        while (true) {
            if (lector.hasNextInt()) {
                alçadasalt = lector.nextInt();
                break;
            } else {
                System.out.println("Error, introdueix un nombre senser.");
            }
        }

        if (tempsCarrera <= 30 && flexions >= 80 && alçadasalt >= 70) {
            perfilPercentualInicial = perfilPercentualInicial + 30;
            System.out.println("Has complert amb els criteris de entrenament físic");
        } else {
            System.out.println("Ho sento, no compleixes amb el desafiament d'entrenament físic. Intenta-ho de nou");
            System.exit(0);
        }

        System.out.println();
        System.out.println("Ara farem la Avaluació de Resistència Cardiovascular:");
        
    }
}
