package RA2;

import java.util.Scanner;

public class JavaParkingMetodes {

    public static void main(String[] args) {
        JavaParkingMetodes prog = new JavaParkingMetodes();

        String[] parking = new String[10];
        for (int i = 0; i < parking.length; i++) {
            parking[i] = ""; // Inicializa cada plaza como una cadena vacía
        }
        String opcio;

        prog.mostrarMenu();
        opcio = prog.triaOpcio();
        while (!opcio.equals("fi")) {
            switch (opcio) {
                case "aparcar":
                    System.out.print("Introdueix la matrícula: ");
                    String matriculaAparcar = prog.entraParaula();
                    if (prog.aparcar(parking, matriculaAparcar)) {
                        System.out.println("Cotxe aparcat amb matrícula: " + matriculaAparcar);
                    } else {
                        System.out.println("No hi ha lloc disponible o el cotxe ja està aparcat.");
                    }
                    break;
                case "desaparcar":
                    System.out.print("Introdueix la matrícula: ");
                    String matriculaDesaparcar = prog.entraParaula();
                    if (prog.desaparcar(parking, matriculaDesaparcar)) {
                        System.out.println("Cotxe amb matrícula " + matriculaDesaparcar + " ha marxat.");
                    } else {
                        System.out.println("El cotxe no es troba aparcat.");
                    }
                    break;
                default:
                    System.out.println("Opcio incorrecta!!");
            }
            prog.mostrarMenu();
            opcio = prog.triaOpcio();
        }

        prog.mostrarParquing(parking);
    }

    // Un mètode per mostrar el menú d'opcions:
    public void mostrarMenu() {
        System.out.println("Opcions:");
        System.out.println("1. aparcar");
        System.out.println("2. desaparcar");
        System.out.println("3. fi");
    }

    // Un mètode per triar una opció del menú
    public String triaOpcio() {
        Scanner scanner = new Scanner(System.in);
        String opcio;
        do {
            opcio = scanner.nextLine();
            if (opcio.equals("aparcar") || opcio.equals("desaparcar") || opcio.equals("fi")) {
                return opcio;
            } else {
                System.out.println("Opció incorrecta. Torna a intentar-ho:");
            }
        } while (true);
    }

    // Un mètode per entrar per teclat una paraula
    public String entraParaula() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    // Un mètode per aparcar
    public boolean aparcar(String places[], String matricula) {
        for (int i = 0; i < places.length; i++) {
            if (places[i].isEmpty()) {
                places[i] = matricula;
                return true;
            } else if (places[i].equals(matricula)) {
                return false; // El cotxe ja està aparcat
            }
        }
        return false; // No hi ha lloc disponible
    }

    // Un mètode per desaparcar
    public boolean desaparcar(String places[], String matricula) {
        for (int i = 0; i < places.length; i++) {
            if (places[i].equals(matricula)) {
                places[i] = ""; // Deixar la plaça buida
                return true;
            }
        }
        return false; // El cotxe no es troba aparcat
    }

    // Un mètode per mostrar l'estat del pàrquing
    public void mostrarParquing(String places[]) {
        System.out.println("Situació del pàrquing:");
        for (int i = 0; i < places.length; i++) {
            System.out.println("Plaça " + (i + 1) + ": " + (places[i].isEmpty() ? "Lliure" : places[i]));
        }
        int placesLliures = 0;
        for (String place : places) {
            if (place.isEmpty()) {
                placesLliures++;
            }
        }
        System.out.println("Places lliures: " + placesLliures);
    }
}