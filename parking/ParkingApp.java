import java.util.Scanner;

public class ParkingApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el número de plazas del parking: ");
        int numPlazas = scanner.nextInt();
        scanner.nextLine();

        Parking parking = new Parking(numPlazas);

        while (true) {
            System.out.println("\n--- MENÚ ---");
            System.out.println("1. Crear y aparcar un vehículo");
            System.out.println("2. Desaparcar por matrícula");
            System.out.println("3. Desaparcar por número de plaza");
            System.out.println("4. Mostrar estado del parking");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese matrícula del vehículo: ");
                    String matricula = scanner.nextLine();

                    System.out.println("Seleccione tipo de vehículo: ");
                    System.out.println("1. Coche");
                    System.out.println("2. Motocicleta");
                    System.out.println("3. Furgoneta");
                    int tipo = scanner.nextInt();
                    scanner.nextLine();

                    Vehicle vehicle;
                    if (tipo == 1) {
                        vehicle = new Cotxe(matricula);
                    } else if (tipo == 2) {
                        vehicle = new Motocicleta(matricula);
                    } else {
                        vehicle = new Furgoneta(matricula);
                    }

                    if (parking.aparcar(vehicle)) {
                        System.out.println("Vehículo aparcado con éxito.");
                    } else {
                        System.out.println("Parking lleno. No se pudo aparcar.");
                    }
                    break;

                case 2:
                    System.out.print("Ingrese la matrícula del vehículo: ");
                    String mat = scanner.nextLine();
                    double preu = parking.desaparcar(mat);
                    if (preu >= 0) {
                        System.out.println("Debe pagar: " + preu + "€");
                    } else {
                        System.out.println("No se encontró el vehículo.");
                    }
                    break;

                case 3:
                    System.out.print("Ingrese el número de la plaza: ");
                    int plazaNum = scanner.nextInt();
                    double preuPlaza = parking.desaparcar(plazaNum);
                    if (preuPlaza >= 0) {
                        System.out.println("Debe pagar: " + preuPlaza + "€");
                    } else {
                        System.out.println("No se encontró un vehículo en esa plaza.");
                    }
                    break;

                case 4:
                    parking.llistat();
                    break;

                case 5:
                    System.out.println("Saliendo...");
                    scanner.close();
                    return;
            }
        }
    }
}
