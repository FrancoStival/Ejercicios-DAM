package RA2;

import java.util.Scanner;

public class CaixerAutomatic {
    public static void main(String[] args) {
        // Usuaris, contrasenyes i saldos
        String[] usuaris = {"usuari1", "usuari2", "usuari3"};
        String[] contrasenyes = {"contrasenya1", "contrasenya2", "contrasenya3"};
        double[] saldos = {1000.0, 500.0, 300.0};

        // Bitllets disponibles
        int[] bitllets = {10, 10, 10}; // 10 bitllets de 50, 20 i 10 euros
        int[] tipusBitllets = {50, 20, 10};

        Scanner scanner = new Scanner(System.in);
 
        // Autenticació de l'usuari
        System.out.print("Introduïu l'identificador d'usuari: ");
        String usuari = scanner.nextLine();
        System.out.print("Introduïu la contrasenya: ");
        String contrasenya = scanner.nextLine();

        int indexUsuari = -1;
        for (int i = 0; i < usuaris.length; i++) {
            if (usuaris[i].equals(usuari) && contrasenyes[i].equals(contrasenya)) {
                indexUsuari = i;
                break;
            }
        }

        if (indexUsuari == -1) {
            System.out.println("Identificador o contrasenya incorrectes. L'aplicació es tanca.");
            return;
        }

        // Menú d'opcions
        boolean continuar = true;
        while (continuar) {
            System.out.println("\nMenú d'opcions:");
            System.out.println("1. Consultar saldo");
            System.out.println("2. Retirar diners");
            System.out.println("3. Ingressar");
            System.out.println("4. Canviar clau");
            System.out.println("5. Sortir");
            System.out.print("Seleccioneu una opció: ");
            int opcio = scanner.nextInt();

            switch (opcio) {
                case 1:
                    System.out.println("El vostre saldo és: " + saldos[indexUsuari] + " €");
                    break;

                case 2:
                    System.out.print("Quantitat a retirar: ");
                    double quantitatRetirar = scanner.nextDouble();
                    if (quantitatRetirar > saldos[indexUsuari]) {
                        System.out.println("Error: saldo insuficient.");
                    } else {
                        retirarDinero(quantitatRetirar, saldos, indexUsuari, bitllets, tipusBitllets);
                    }
                    break;

                case 3:
                    System.out.print("Quantitat a ingressar: ");
                    double quantitatIngressar = scanner.nextDouble();
                    if (quantitatIngressar % 10 != 0) {
                        System.out.println("Error: la quantitat ha de ser múltiple de 10.");
                    } else {
                        saldos[indexUsuari] += quantitatIngressar;
                        System.out.println("S'ha ingressat " + quantitatIngressar + " €.");
                    }
                    break;

                case 4:
                    System.out.print("Introduïu la nova contrasenya: ");
                    String novaContrasenya = scanner.next();
                    if (novaContrasenya.length() < 4) {
                        System.out.println("Error: la contrasenya ha de tenir almenys 4 caràcters.");
                    } else {
                        contrasenyes[indexUsuari] = novaContrasenya;
                        System.out.println("Contrasenya canviada amb èxit.");
                    }
                    break;

                case 5:
                    continuar = false;
                    System.out.println("Sortint de l'aplicació...");
                    break;

                default:
                    System.out.println("Opció no vàlida.");
            }
        }

        scanner.close();
    }

    private static void retirarDinero(double quantitat, double[] saldos, int indexUsuari, int[] bitllets, int[] tipusBitllets) {
        double quantitatRestant = quantitat;
        int[] bitlletsDonats = new int[tipusBitllets.length];

        for (int i = 0; i < tipusBitllets.length; i++) {
            while (quantitatRestant >= tipusBitllets[i] && bitllets[i] > 0) {
                quantitatRestant -= tipusBitllets[i ];
                bitllets[i]--;
                bitlletsDonats[i]++;
            }
        }

        if (quantitatRestant > 0) {
            System.out.println("Error: no hi ha suficients bitllets disponibles per completar la retirada.");
            // Retornar els bitllets donats
            for (int i = 0; i < tipusBitllets.length; i++) {
                bitllets[i] += bitlletsDonats[i];
            }
        } else {
            saldos[indexUsuari] -= quantitat;
            System.out.println("Retirada realitzada amb èxit. Se li donen:");
            for (int i = 0; i < tipusBitllets.length; i++) {
                if (bitlletsDonats[i] > 0) {
                    System.out.println(bitlletsDonats[i] + " Bitllet(s) de " + tipusBitllets[i] + " €");
                }
            }
        }
    }
}