
import java.util.Scanner;

public class ActivitatAvaluable1_FrancoStival {

    public static void main(String[] args) {

        Scanner lector = new Scanner(System.in);
        int edat = 0, alçada = 0, pes = 0, flexions = 0, alçadasalt = 0, perfilPercentualInicial = 0, resistenciaCardiovascularRedondeada = 0;
        double tempsCarrera = 0, resistenciaCardiovascular = 0;
        boolean quitaWhiles = false;
        boolean quitaWhiles2 = false;

        perfilPercentualInicial = 0;
        System.out.println();
        System.out.println();
        System.out.println("Benvigut a l'Agència Espacial Internacional.");
        System.out.println("A continuació, comprovarem si ets adequat per al post");
        System.out.print("Introdueix el teu edat: ");

        while (!quitaWhiles) {
            if (lector.hasNextInt()) {
                edat = lector.nextInt();
                quitaWhiles = true;
            } else {
                System.out.println("Error, introdueix un nombre senser.");
                lector.next();
            }
        }
        quitaWhiles = false;
        
        System.out.print("Introdueix la teva alçada (en cm): ");
        while (!quitaWhiles) {
            if (lector.hasNextInt()) {
                alçada = lector.nextInt();
                quitaWhiles = true;
            } else {
                System.out.println("Error, introdueix un nombre senser.");
                lector.next();
            }
        }
        quitaWhiles = false;

        System.out.print("Introdueix el teu pes (en kg): ");
        while (!quitaWhiles) {
            if (lector.hasNextInt()) {
                pes = lector.nextInt();
                quitaWhiles = true;
            } else {
                System.out.println("Error, introdueix un nombre senser.");
                lector.next();
            }
        }
        quitaWhiles = false;


        System.out.println();

        if (edat >= 25 && edat <= 40) { //Se que esto es menos eficiente que comprobar todo a la vez, pero quiero mostrar los dos modos de hacerlo. 
                                        //Más adelante, esta en forma corta
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
        while (!quitaWhiles) {
            if (lector.hasNextInt()) {
                tempsCarrera = lector.nextInt();
                quitaWhiles = true;
            } else {
                System.out.println("Error, introdueix un nombre senser.");
                lector.next();
            }
        }
        quitaWhiles = false;
        
        System.out.print("Quantes flexions pots fer en 60 segons?: ");
        while (!quitaWhiles) {
            if (lector.hasNextInt()) {
                flexions = lector.nextInt();
                quitaWhiles = true;
            } else {
                System.out.println("Error, introdueix un nombre senser.");
                lector.next();
            }
        }
        quitaWhiles = false;

        System.out.print("Altura màxima en salt vertical (en cm)?: ");
        while (!quitaWhiles) {
            if (lector.hasNextInt()) {
                alçadasalt = lector.nextInt();
                quitaWhiles = true;
            } else {
                System.out.println("Error, introdueix un nombre senser.");
                lector.next();
            }
        }
        quitaWhiles = false;


        if (tempsCarrera <= 30 && flexions >= 80 && alçadasalt >= 70) {
            perfilPercentualInicial = perfilPercentualInicial + 30;
            System.out.println("Has complert amb els criteris de entrenament físic");
        } else {
            System.out.println("Ho sento, no compleixes amb el desafiament d'entrenament físic. Intenta-ho de nou");
            System.exit(0);
        }

        System.out.println();
        System.out.println("Ara farem la Avaluació de Resistència Cardiovascular:");

        while (!quitaWhiles) {
            resistenciaCardiovascular = (edat / tempsCarrera) * 7;
            System.out.println("La teva resistencia Cardiovascular es de: " + resistenciaCardiovascular);
            System.out.println("");
            if (resistenciaCardiovascular <= 10) {
                quitaWhiles = true;
            } else {
                System.out.println("El valor de la resistencia cardiovascular no pot ser més gran que 10.");
                System.out.println("Has de tornar a introduir la teva edat i el teu temps de carrera.");
                System.out.println();
                System.out.println("Quina es la teva edat?");
                while (!quitaWhiles2) {
                    if (lector.hasNextInt()) {
                        edat = lector.nextInt();
                        if (edat < 25 || edat > 40) {
                            System.out.println("No tens la edat apropiada per al nostre programa.");
                            System.exit(0);
                        } else {
                            quitaWhiles2 = true;

                        }
                    } else {
                        System.out.println("Error, introdueix un nombre senser.");
                        lector.next();
                    }
                }
                quitaWhiles2  = false;

                System.out.print("En quant de temps pots correr 5 km? (Escriu la resposta en minuts):");
                while (!quitaWhiles2) {
                    if (lector.hasNextInt()) {
                        tempsCarrera = lector.nextInt();
                        if (tempsCarrera > 30) {
                            System.out.println("Ets massa lent per al nostre programa.");
                            System.exit(0);
                        }
                        quitaWhiles2 = true;
                    } else {
                        System.out.println("Error, introdueix un nombre senser.");
                        lector.next();
                    }
                }
            }
        }
        System.out.println("");
        resistenciaCardiovascularRedondeada = (int) Math.ceil(resistenciaCardiovascular);
        if (resistenciaCardiovascular >= 6) {
            switch (resistenciaCardiovascularRedondeada) {
                case 6:
                    perfilPercentualInicial = perfilPercentualInicial + 10;
                    break;
                case 7:
                    perfilPercentualInicial = perfilPercentualInicial + 20;
                    break;
                case 8:
                    perfilPercentualInicial = perfilPercentualInicial + 35;
                    break;
                case 9:
                    perfilPercentualInicial = perfilPercentualInicial + 45;
                    break;
                case 10:
                    perfilPercentualInicial = perfilPercentualInicial + 55;
                    break;
                default:
                    System.out.println("Error");
            }
        } else {
            System.out.println("Ho sento, no has superat la prova de resistència cardiovascular");
        }

        System.out.println("El teu perfil percentual és de: " + perfilPercentualInicial + "%.");

        if (perfilPercentualInicial >= 90 && perfilPercentualInicial <= 100) {
            System.out.println("Enhorabona, has obtingut el rang A (Excellent).");
        } else if (perfilPercentualInicial >= 80 && perfilPercentualInicial <= 89) {
            System.out.println("Enhorabona, has obtingut el rang B (Molt Bo).");
        } else if (perfilPercentualInicial >= 70 && perfilPercentualInicial <= 79) {
            System.out.println("Enhorabona, has obtingut el rang C (Bo).");
        } else if (perfilPercentualInicial < 70) {
            System.out.println("Enhorabona, has obtingut el rang D (Necessites Millorar).");
        } else {
            System.out.println("Error");
        }
    }
}