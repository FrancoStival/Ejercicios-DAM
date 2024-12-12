import java.util.Random;
import java.util.Scanner;

public class Exercici13_1FrancoStival {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner lector = new Scanner(System.in);
        int puntuacio = 0, siguienteCarta = 0, valorAs = 0, siguienteCartaCrupier = 0, puntuacioCrupier = 0;
        String figura = "";
        boolean quitaWhile = false, sePlanta = false, sePlantaCrupier = false;
        char sePlantaChar = '1';

        System.out.println("Bienvenido a la mesa de Blackjack.");
        siguienteCarta = random.nextInt(12) + 1;
        switch (siguienteCarta) {
            case 1:
                figura = "As";
                break;
            case 10:
                figura = "Jota";
                break;
            case 11:
                figura = "Reina";
                siguienteCarta = 10;
                break;
            case 12:
                figura = "Rey";
                siguienteCarta = 10;
                break;

        }
        if (siguienteCarta == 1 || siguienteCarta == 10) {
            System.out.println("La carta inicial es: " + figura);
        } else {
            System.out.println("La carta inicial es: " + siguienteCarta);
        }
        if (siguienteCarta == 1) {
            System.out.print("El As puede contar como 1 o como 10. Cual quieres?: ");

            while (!quitaWhile) {
                if (lector.hasNextInt()) {
                    valorAs = lector.nextInt();
                    if (valorAs == 1 || valorAs == 10) {

                        quitaWhile = true;
                    } else {
                        System.out.println("Introduce un numero entre 1 y 10.");
                        lector.next();
                    }
                } else {
                    System.out.print("Porfavor, introduzca un número válido: ");
                    lector.next();
                }
            }
        }
        puntuacio += siguienteCarta;

        while (!sePlanta && puntuacio < 22) {
            siguienteCarta = random.nextInt(12) + 1;
            switch (siguienteCarta) {
                case 1:
                    figura = "As";
                    break;
                case 10:
                    figura = "Jota";
                    break;
                case 11:
                    figura = "Reina";
                    siguienteCarta = 10;
                    break;
                case 12:
                    figura = "Rey";
                    siguienteCarta = 10;
                    break;

            }
            if (siguienteCarta == 1 || siguienteCarta == 10) {
                System.out.println("La carta es: " + figura);
            } else {
                System.out.println("La carta es: " + siguienteCarta);
            }
            if (siguienteCarta == 1) {
                System.out.print("El As puede contar como 1 o como 10. Cual quieres?: ");

                while (!quitaWhile) {
                    if (lector.hasNextInt()) {
                        valorAs = lector.nextInt();
                        if (valorAs != 1 || valorAs != 10) {
                            System.out.println("Introduce un numero entre 1 y 10.");
                            lector.next();
                        } else {
                            siguienteCarta = valorAs;
                            quitaWhile = true;
                        }
                    } else {
                        System.out.print("Porfavor, introduzca un número válido: ");
                        lector.next();
                    }
                }
            }
            puntuacio += siguienteCarta;
            System.out.println("Tu puntuació es de: " + puntuacio);
            System.out.println("");
            if (puntuacio > 21) {
                System.out.println("Has perdido. Te has pasado de 21");
                quitaWhile = true;
                System.exit(0);
            }
            if (puntuacio == 21) {
                System.out.println("Has ganado. Has sacado 21 exacto");
                quitaWhile = true;
                sePlanta = true;
                System.exit(0);
            }
            while (!quitaWhile) {
                System.out.println("Quieres plantarte? (S/N)?");
                sePlantaChar = lector.next().charAt(0);
                if (sePlantaChar == 'S' || sePlantaChar == 'N' || sePlantaChar == 's' || sePlantaChar == 'n') {
                    quitaWhile = true;
                } else {
                    System.out.println("Entrada incorrecta. Prueba otra vez.");
                }
            }
            quitaWhile = false;
            if (sePlantaChar == 'S' || sePlantaChar == 's') {
                sePlanta = true;
            }
        }
        quitaWhile = false;
        System.out.println("");
        System.out.println("Ahora le toca al Crupier.");

        while (!sePlantaCrupier && puntuacioCrupier < 22) {
            siguienteCartaCrupier = random.nextInt(12) + 1;
            switch (siguienteCartaCrupier) {
                case 1:
                    figura = "As";
                    break;
                case 10:
                    figura = "Jota";
                    break;
                case 11:
                    figura = "Reina";
                    siguienteCartaCrupier = 10;
                    break;
                case 12:
                    figura = "Rey";
                    siguienteCartaCrupier = 10;
                    break;

            }
            if (siguienteCartaCrupier == 1 || siguienteCartaCrupier == 10) {
                System.out.println("La carta es: " + figura);
            } else {
                System.out.println("La carta es: " + siguienteCartaCrupier);
            }
            if (siguienteCartaCrupier == 1) {
                System.out.print("Quiero que el As cuente como 10");
                siguienteCarta += 10;
            }
            puntuacioCrupier += siguienteCartaCrupier;
            System.out.println("La puntuacion del crupier es de: " + puntuacioCrupier);
            if (puntuacioCrupier > 21) {
                System.out.println("El crupier se ha pasado de 21, has ganado.");
                quitaWhile = true;
                System.exit(0);
            }
            if (puntuacioCrupier == 21) {
                System.out.println("El crupier se planta con 21. Has perdido ");
                quitaWhile = true;
                System.exit(0);
            }

            if (puntuacioCrupier >= 17) {
                System.out.println("El crupier se planta con una puntuación de: " + puntuacioCrupier);
                System.out.println("");
                sePlantaCrupier = true;
            } else {
                System.out.println("El crupier decide seguir sacando cartas.");
                System.out.println("");
            }
        }

        System.out.println("Tienes:  " + puntuacio + " puntos.");
            System.out.println("El crupier tiene: " + puntuacioCrupier + " puntos.");
            if (sePlantaCrupier) {
                if (puntuacio > puntuacioCrupier) {
                    System.out.println("Has ganado");
                } else if (puntuacio == puntuacioCrupier) {
                    System.out.println("Empate");
                } else if (puntuacioCrupier > puntuacio) {
                    System.out.println("Has perdido");
                }
            }
        lector.close();
    }
}
