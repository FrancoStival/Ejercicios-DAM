import java.io.*;
import java.util.*;

public class Pt3_Persistencia_de_Dades {
    private static final String FITXER = "videojocs.dat";
    private static ArrayList<Videojoc> llista = new ArrayList<>();
    private static Scanner lector = new Scanner(System.in);

    public static void main(String[] args) {
        carregarDades();

        int opcio = -1;
        do {
            mostrarMenu();
            System.out.print("Tria una opció: ");
            try {
                opcio = Integer.parseInt(lector.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Has d'introduir un número.");
                continue;
            }

            switch (opcio) {
                case 1 -> afegirVideojoc();
                case 2 -> llistarVideojocs();
                case 3 -> cercarPerTitol();
                case 4 -> actualitzarVideojoc();
                case 5 -> eliminarVideojoc();
                case 6 -> guardarDades();
                case 0 -> {
                    guardarDades();
                    System.out.println("Sortint del programa...");
                    lector.close();
                }
                default -> System.out.println("Opció no vàlida.");
            }
        } while (opcio != 0);
    }

    // Menú principal
    private static void mostrarMenu() {
        System.out.println("\n--- Gestió de Videojocs ---");
        System.out.println("1. Afegir videojoc");
        System.out.println("2. Llistar tots");
        System.out.println("3. Cercar per títol");
        System.out.println("4. Actualitzar videojoc");
        System.out.println("5. Eliminar videojoc");
        System.out.println("6. Desar canvis");
        System.out.println("0. Sortir");
    }

    // Afegeix un videojoc
    private static void afegirVideojoc() {
        System.out.print("Títol: ");
        String titol = lector.nextLine();

        System.out.print("Gènere: ");
        String genere = lector.nextLine();

        int any = demanarInt("Any de llançament: ");
        System.out.print("Plataforma: ");
        String plataforma = lector.nextLine();

        double preu = demanarDouble("Preu (€): ");

        llista.add(new Videojoc(titol, genere, any, plataforma, preu));
        guardarDades();
        System.out.println("Videojoc afegit correctament.");
    }

    // Mostra tots els videojocs
    private static void llistarVideojocs() {
        if (llista.isEmpty()) {
            System.out.println("No hi ha videojocs desats.");
            return;
        }
        System.out.println("\n--- Llista de videojocs ---");
        for (int i = 0; i < llista.size(); i++) {
            System.out.println((i + 1) + ". " + llista.get(i));
        }
    }

    // Cerca per títol
    private static void cercarPerTitol() {
        System.out.print("Introdueix part del títol: ");
        String cerca = lector.nextLine().toLowerCase();
        boolean trobat = false;

        for (Videojoc v : llista) {
            if (v.getTitol().toLowerCase().contains(cerca)) {
                System.out.println(v);
                trobat = true;
            }
        }
        if (!trobat) System.out.println("Cap coincidència trobada.");
    }

    // Actualitza dades
    private static void actualitzarVideojoc() {
        llistarVideojocs();
        if (llista.isEmpty()) return;

        int index = demanarInt("Número del videojoc a actualitzar: ") - 1;
        if (index < 0 || index >= llista.size()) {
            System.out.println("Index invàlid.");
            return;
        }

        Videojoc v = llista.get(index);
        System.out.println("Editant: " + v.getTitol());

        System.out.print("Nou títol (" + v.getTitol() + "): ");
        String nouTitol = lector.nextLine();
        if (!nouTitol.isBlank()) v.setTitol(nouTitol);

        System.out.print("Nou gènere (" + v.getGenere() + "): ");
        String nouGenere = lector.nextLine();
        if (!nouGenere.isBlank()) v.setGenere(nouGenere);

        System.out.print("Nou any (" + v.getAnyLlançament() + "): ");
        String nouAny = lector.nextLine();
        if (!nouAny.isBlank()) {
            try {
                v.setAnyLlançament(Integer.parseInt(nouAny));
            } catch (NumberFormatException e) {
                System.out.println("Any no vàlid, no s'ha canviat.");
            }
        }

        System.out.print("Nova plataforma (" + v.getPlataforma() + "): ");
        String novaPlataforma = lector.nextLine();
        if (!novaPlataforma.isBlank()) v.setPlataforma(novaPlataforma);

        System.out.print("Nou preu (" + v.getPreu() + "): ");
        String nouPreu = lector.nextLine();
        if (!nouPreu.isBlank()) {
            try {
                v.setPreu(Double.parseDouble(nouPreu));
            } catch (NumberFormatException e) {
                System.out.println("Preu no vàlid, no s'ha canviat.");
            }
        }

        guardarDades();
        System.out.println("Videojoc actualitzat.");
    }

    // Elimina videojoc
    private static void eliminarVideojoc() {
        llistarVideojocs();
        if (llista.isEmpty()) return;

        int index = demanarInt("Número del videojoc a eliminar: ") - 1;
        if (index < 0 || index >= llista.size()) {
            System.out.println("Index invàlid.");
            return;
        }
        
        llista.remove(index);
        guardarDades();
        System.out.println("Videojoc eliminat.");
    }

    // Desa dades al fitxer
    private static void guardarDades() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FITXER))) {
            oos.writeObject(llista);
        } catch (IOException e) {
            System.out.println("Error en desar les dades: " + e.getMessage());
        }
    }

    // Carrega dades del fitxer
    @SuppressWarnings("unchecked")
    private static void carregarDades() {
        File fitxer = new File(FITXER);
        if (!fitxer.exists()) return;

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fitxer))) {
            llista = (ArrayList<Videojoc>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("No s'han pogut carregar les dades.");
        }
    }

    // --- Helpers per validar entrades ---

    private static int demanarInt(String missatge) {
        while (true) {
            System.out.print(missatge);
            String input = lector.nextLine();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Introdueix un número enter vàlid.");
            }
        }
    }

    private static double demanarDouble(String missatge) {
        while (true) {
            System.out.print(missatge);
            String input = lector.nextLine();
            try {
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("Introdueix un número decimal vàlid.");
            }
        }
    }
}

// Classe Videojoc (serialitzable)
class Videojoc implements Serializable {
    private static final long serialVersionUID = 1L;

    private String titol;
    private String genere;
    private int anyLlançament;
    private String plataforma;
    private double preu;

    // Constructor
    public Videojoc(String titol, String genere, int anyLlançament, String plataforma, double preu) {
        this.titol = titol;
        this.genere = genere;
        this.anyLlançament = anyLlançament;
        this.plataforma = plataforma;
        this.preu = preu;
    }

    // Getters i setters
    public String getTitol() { return titol; }
    public void setTitol(String titol) { this.titol = titol; }

    public String getGenere() { return genere; }
    public void setGenere(String genere) { this.genere = genere; }

    public int getAnyLlançament() { return anyLlançament; }
    public void setAnyLlançament(int anyLlançament) { this.anyLlançament = anyLlançament; }

    public String getPlataforma() { return plataforma; }
    public void setPlataforma(String plataforma) { this.plataforma = plataforma; }

    public double getPreu() { return preu; }
    public void setPreu(double preu) { this.preu = preu; }

    // Mostra dades
    @Override
    public String toString() {
        return "Títol: " + titol +
               ", Gènere: " + genere +
               ", Any: " + anyLlançament +
               ", Plataforma: " + plataforma +
               ", Preu: " + preu + "€";
    }
}
