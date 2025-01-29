package activitat9;

import java.time.LocalDate;
import java.util.Scanner;

public class Hospital {
    private final paciente[] pacients;

    // Constructor
    public Hospital(paciente[] pacients) {
        this.pacients = pacients;
    }

    // Función para mostrar pacientes con radiografías entre dos fechas
    public void radiografiesTemps(LocalDate datainici, LocalDate datafinal) {
        if (datainici.isAfter(datafinal)) {
            System.out.println("Error: La data d'inici ha de ser anterior a la data final.");
            return;
        }

        boolean trobat = false;
        for (paciente pacient : pacients) {
            if (pacient.getRadiografia() == 's' && !pacient.getDataingres().isBefore(datainici)
                    && !pacient.getDataingres().isAfter(datafinal)) {
                pacient.mostrarDades();
                trobat = true;
            }
        }

        if (!trobat) {
            System.out.println("No s'han trobat pacients amb radiografies entre les dates especificades.");
        }
    }

    // Función para mostrar los datos de un paciente según su código de Seguridad Social
    public void dadesPacient(String numsegsocial) {
        boolean trobat = false;
        for (paciente pacient : pacients) {
            if (pacient.getCodiSS().equals(numsegsocial)) {
                pacient.mostrarDades();
                trobat = true;
                break;
            }
        }

        if (!trobat) {
            System.out.println("Error: No s'ha trobat cap pacient amb el codi de Seguretat Social donat.");
        }
    }

    // Programa principal con menú
    public static void main(String[] args) {
        try {
            // Ejemplo de datos de pacientes
            paciente[] pacients = {
                    new paciente("Pere Sans", "111111111", "44555666", LocalDate.of(2007, 5, 3), 'n'),
                    new paciente("Maria Garcia", "222222222", "77888999", LocalDate.of(2020, 8, 15), 's'),
                    new paciente("Joan Martí", "333333333", "11222333", LocalDate.of(2019, 12, 20), 's'),
                    new paciente("Franco Stival", "444444444", "99887766", LocalDate.of(1995, 7, 12), 'n'),
                    new paciente("Alberto Perez", "555555555", "88776655", LocalDate.of(1988, 3, 25), 's'),
                    new paciente("Roger Ferrer", "666666666", "77665544", LocalDate.of(2001, 11, 8), 'n'),
                    new paciente("Lucas Aiguadé", "777777777", "66554433", LocalDate.of(1990, 9, 17), 's'),

            };

            Hospital hospital = new Hospital(pacients);
            Scanner scanner = new Scanner(System.in);
            int opcio;

            do {
                // Menú de opciones
                System.out.println("\n--- Menú ---");
                System.out.println("1. Mostrar pacients amb radiografies entre dues dates");
                System.out.println("2. Mostrar dades d'un pacient per codi de Seguretat Social");
                System.out.println("0. Sortir");
                System.out.print("Selecciona una opció: ");
                opcio = scanner.nextInt();
                scanner.nextLine(); // Limpiar el buffer

                switch (opcio) {
                    case 1:
                        // Opción 1: Mostrar pacientes con radiografías entre dos fechas
                        System.out.print("Introdueix la data d'inici (AAAA-MM-DD): ");
                        LocalDate datainici = LocalDate.parse(scanner.nextLine());
                        System.out.print("Introdueix la data final (AAAA-MM-DD): ");
                        LocalDate datafinal = LocalDate.parse(scanner.nextLine());
                        hospital.radiografiesTemps(datainici, datafinal);
                        break;

                    case 2:
                        // Opción 2: Mostrar datos de un paciente por código de Seguridad Social
                        System.out.print("Introdueix el codi de Seguretat Social (9 xifres): ");
                        String numsegsocial = scanner.nextLine();
                        hospital.dadesPacient(numsegsocial);
                        break;

                    case 0:
                        // Opción 0: Salir del programa
                        System.out.println("Sortint del programa...");
                        break;

                    default:
                        // Opción no válida
                        System.out.println("Opció no vàlida. Torna a intentar.");
                        break;
                }
            } while (opcio != 0);

            scanner.close();
        } catch (Exception e) {
        }

    }
}

