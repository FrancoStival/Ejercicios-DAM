// App.java
import dao.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;
import model.*;

public class App {
    private static final Scanner sc = new Scanner(System.in);
    private static final ProducteDAO producteDAO = new ProducteDAO();
    private static final ClientDAO clientDAO = new ClientDAO();
    private static final DescompteDAO descompteDAO = new DescompteDAO();
    private static final ComandaDAO comandaDAO = new ComandaDAO();
    private static final ConsultesDAO consultesDAO = new ConsultesDAO();

    public static void main(String[] args) throws Exception {
        int op;
        do {
            System.out.println("===== BOTIGA ONLINE =====");
            System.out.println("1. Gestionar Productes");
            System.out.println("2. Gestionar Clients");
            System.out.println("3. Crear Comanda");
            System.out.println("4. Llistar Comandes d'un client");
            System.out.println("5. Mostrar totals de comandes");
            System.out.println("0. Sortir");
            System.out.print("Opció: ");
            op = Integer.parseInt(sc.nextLine().trim());
            switch (op) {
                case 1 -> menuProductes();
                case 2 -> menuClients();
                case 3 -> crearComandaFlow();
                case 4 -> {
                    System.out.print("Id client: ");
                    int id = Integer.parseInt(sc.nextLine().trim());
                    consultesDAO.llistarComandesPerClient(id);
                }
                case 5 -> consultesDAO.mostrarTotalsComandes();
            }
        } while (op != 0);
        sc.close();
    }

    private static void menuProductes() throws Exception {
        int op;
        do {
            System.out.println("== Productes ==");
            System.out.println("1. Llistar");
            System.out.println("2. Afegir");
            System.out.println("3. Actualitzar");
            System.out.println("4. Eliminar");
            System.out.println("0. Tornar");
            System.out.print("Opció: ");
            op = Integer.parseInt(sc.nextLine().trim());
            switch (op) {
                case 1 -> {
                    List<Producte> l = producteDAO.llistar();
                    for (Producte p : l) System.out.println(p.getId() + " " + p.getNom() + " preu:" + p.getPreu() + " estoc:" + p.getEstoc());
                }
                case 2 -> {
                    System.out.print("Nom: ");
                    String nom = sc.nextLine();
                    System.out.print("Preu: ");
                    BigDecimal preu = new BigDecimal(sc.nextLine().trim());
                    System.out.print("Estoc: ");
                    int estoc = Integer.parseInt(sc.nextLine().trim());
                    Producte p = new Producte(0, nom, preu, estoc);
                    producteDAO.inserir(p);
                    System.out.println("Insertat id:" + p.getId());
                }
                case 3 -> {
                    System.out.print("Id a actualitzar: ");
                    int id = Integer.parseInt(sc.nextLine().trim());
                    Producte p = producteDAO.trobarPerId(id);
                    if (p == null) { System.out.println("No trobat."); break; }
                    System.out.print("Nom [" + p.getNom() + "]: ");
                    String nom = sc.nextLine(); if (!nom.isBlank()) p.setNom(nom);
                    System.out.print("Preu [" + p.getPreu() + "]: ");
                    String preuS = sc.nextLine(); if (!preuS.isBlank()) p.setPreu(new BigDecimal(preuS));
                    System.out.print("Estoc [" + p.getEstoc() + "]: ");
                    String estocS = sc.nextLine(); if (!estocS.isBlank()) p.setEstoc(Integer.parseInt(estocS));
                    producteDAO.actualitzar(p);
                    System.out.println("Actualitzat.");
                }
                case 4 -> {
                    System.out.print("Id a eliminar: ");
                    int id = Integer.parseInt(sc.nextLine().trim());
                    producteDAO.eliminar(id);
                    System.out.println("Eliminat si existia.");
                }
            }
        } while (op != 0);
    }

    private static void menuClients() throws Exception {
        int op;
        do {
            System.out.println("== Clients ==");
            System.out.println("1. Llistar");
            System.out.println("2. Afegir");
            System.out.println("3. Actualitzar");
            System.out.println("4. Eliminar");
            System.out.println("0. Tornar");
            System.out.print("Opció: ");
            op = Integer.parseInt(sc.nextLine().trim());
            switch (op) {
                case 1 -> {
                    List<Client> l = clientDAO.llistar();
                    for (Client c : l) System.out.println(c.getId() + " " + c.getNom() + " " + c.getCorreu());
                }
                case 2 -> {
                    System.out.print("Nom: ");
                    String nom = sc.nextLine();
                    System.out.print("Correu: ");
                    String correu = sc.nextLine();
                    Client c = new Client(0, nom, correu);
                    clientDAO.inserir(c);
                    System.out.println("Insertat id:" + c.getId());
                }
                case 3 -> {
                    System.out.print("Id a actualitzar: ");
                    int id = Integer.parseInt(sc.nextLine().trim());
                    Client c = clientDAO.trobarPerId(id);
                    if (c == null) { System.out.println("No trobat."); break; }
                    System.out.print("Nom [" + c.getNom() + "]: ");
                    String nom = sc.nextLine(); if (!nom.isBlank()) c.setNom(nom);
                    System.out.print("Correu [" + c.getCorreu() + "]: ");
                    String correu = sc.nextLine(); if (!correu.isBlank()) c.setCorreu(correu);
                    clientDAO.actualitzar(c);
                    System.out.println("Actualitzat.");
                }
                case 4 -> {
                    System.out.print("Id a eliminar: ");
                    int id = Integer.parseInt(sc.nextLine().trim());
                    clientDAO.eliminar(id);
                    System.out.println("Eliminat si existia.");
                }
            }
        } while (op != 0);
    }

    private static void crearComandaFlow() throws Exception {
        System.out.print("Id client: ");
        int clientId = Integer.parseInt(sc.nextLine().trim());
        Comanda com = new Comanda(clientId);

        while (true) {
            System.out.print("Id producte (0 per acabar): ");
            int pid = Integer.parseInt(sc.nextLine().trim());
            if (pid == 0) break;
            Producte p = producteDAO.trobarPerId(pid);
            if (p == null) { System.out.println("Producte no trobat."); continue; }
            System.out.print("Quantitat: ");
            int q = Integer.parseInt(sc.nextLine().trim());
            if (q <= 0) { System.out.println("Quantitat invàlida."); continue; }
            LiniaComanda l = new LiniaComanda(pid, q, p.getPreu());
            com.afegirLinia(l);
        }

        if (com.getLinies().isEmpty()) { System.out.println("Comanda buida. Abortant."); return; }

        try {
            comandaDAO.crearComanda(com);
            System.out.println("Comanda creada id:" + com.getId() + " total:" + com.getTotal());
        } catch (Exception ex) {
            System.out.println("Error creant comanda: " + ex.getMessage());
        }
    }
}
