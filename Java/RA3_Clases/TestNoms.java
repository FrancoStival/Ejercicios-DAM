import java.util.*;

public class TestNoms {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Noms llistaNoms = new Noms(5);
        int opcio;

        String menu = """
                \n1) Afegir Nom
                2) Eliminar Nom
                3) Buidar Llista
                4) Mostrar Nom
                5) Llista Plena?
                6) Mostrar tota la llista
                7) Sortir
                Opció: """;

        do {
            System.out.print(menu);
            while (!scanner.hasNextInt()) {
                System.out.println("Si us plau, introdueix un número vàlid.");
                scanner.next();
            }
            opcio = scanner.nextInt();
            scanner.nextLine();

            switch (opcio) {
                case 1 -> {
                    System.out.print("Nom: ");
                    System.out.println(llistaNoms.afegirNom(scanner.nextLine()));
                }
                case 2 -> {
                    System.out.print("Nom: ");
                    System.out.println(llistaNoms.eliminarNom(scanner.nextLine()));
                }
                case 3 -> {
                    llistaNoms.buidarLlista();
                    System.out.println("Llista buidada!");
                }
                case 4 -> {
                    System.out.print("Posició: ");
                    while (!scanner.hasNextInt()) {
                        System.out.println("Si us plau, introdueix un número vàlid.");
                        scanner.next();
                    }
                    System.out.println(llistaNoms.mostrarNom(scanner.nextInt()));
                    scanner.nextLine();
                }
                case 5 ->
                    System.out.println(llistaNoms.llistaPlena() ? "La llista està plena." : "Encara hi ha espai.");
                case 6 -> System.out.println(llistaNoms);
                case 7 -> System.out.println("Sortint...");
                default -> System.out.println("Opció no vàlida. Tria una opció del menú.");
            }
        } while (opcio != 7);
        scanner.close();
    }
}

class Noms {
    private final int capacitatMaxima;
    private final List<String> llista;

    public Noms(int capacitatMaxima) {
        this.capacitatMaxima = capacitatMaxima;
        this.llista = new ArrayList<>();
    }

    public String afegirNom(String nom) {
        if (llista.size() >= capacitatMaxima)
            return "La llista està plena!";
        if (llista.contains(nom))
            return "El nom ja existeix!";
        llista.add(nom);
        return "Afegit correctament!";
    }

    public String eliminarNom(String nom) {
        return llista.remove(nom) ? "Eliminat correctament!" : "El nom no es troba a la llista!";
    }

    public void buidarLlista() {
        llista.clear();
    }

    public String mostrarNom(int posicio) {
        return (posicio < 0 || posicio >= llista.size()) ? "Posició fora de rang!" : "Nom: " + llista.get(posicio);
    }

    public boolean llistaPlena() {
        return llista.size() >= capacitatMaxima;
    }

    @Override
    public String toString() {
        return llista.isEmpty() ? "Llista buida" : String.join("\n", llista);
    }
}
