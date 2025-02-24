
import java.time.LocalDate;
import java.util.Scanner;

public class GestorPeliculas {

    private Actor[] actores;
    private Peli[] peliculas;

    public GestorPeliculas() {
        actores = new Actor[] {
                new Actor(1, "Harrison Ford", LocalDate.of(1942, 7, 13)),
                new Actor(2, "Carrie Fisher", LocalDate.of(1956, 10, 21)),
                new Actor(3, "Mark Hamill", LocalDate.of(1951, 9, 25))
        };

        peliculas = new Peli[] {
                new Peli("StarWars", "George Lucas", 1980, 120, new int[] { 1, 2, 3 }),
                new Peli("Indiana Jones", "Steven Spielberg", 1981, 115, new int[] { 1, -1, -1 }),
                new Peli("Indiana Jones y el templo maldito", "Steven Spielberg", 1984, 118, new int[] { 1, -1, -1 })
        };
    }

    public void pelisActor(String nomActor) {
        boolean encontrado = false;
        System.out.println();
        System.out.println();
        for (Actor actor : actores) {
            if (actor.getNom().equals(nomActor)) {
                encontrado = true;
                System.out.println("Peliculas del actor " + nomActor + ":");
                for (Peli peli : peliculas) {
                    for (int i = 0; i < peli.getProtagonistes().length; i++) {
                        if (peli.getProtagonistes()[i] == actor.getCodi()) {
                            System.out.println("- " + peli.getTitol());
                        }
                    }
                }
                break;
            }

        }
        if (!encontrado) {
            System.out.println("No se ha encontrado el actor " + nomActor + ".");
        }
    }

    public void infoPelis(String nomDirector) {
        boolean encontradoPeli = false;
        System.out.println();
        System.out.println();
        for (Peli peli : peliculas) {
            if (peli.getDirector().equals(nomDirector)) {
                peli.mostrarDetalles(actores);
                encontradoPeli = true;

            }

        }
        if (!encontradoPeli) {
            System.out.println("No se ha encontrado ninguna película del director " + nomDirector + ".");
        }
        System.out.println();
        System.out.println();
    }

    public static void main(String[] args) {
        GestorPeliculas gestor = new GestorPeliculas();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("Menú:");
            System.out.println("1. Buscar las pelis de un actor");
            System.out.println("2. Las peliculas en las que ha trabajado un director");
            System.out.println("3. Salir");
            opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion) {
                case 1:
                    System.out.print("Introduce el nombre del actor que quieras consultar: ");
                    String nomActor = scanner.nextLine();
                    gestor.pelisActor(nomActor);
                    break;
                case 2:
                    System.out.print("Introduce el nombre del director que quieras consultar: ");
                    String nomDirector = scanner.nextLine();
                    gestor.infoPelis(nomDirector);
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Opció no valida. Torna a intentar-ho");
                    break;
            }
        } while (opcion != 3);

    }
}

class Peli {
    private String titol;
    private String director;
    private int any;
    private int durada;
    private int[] protagonistes;

    public Peli(String titol, String director, int any, int durada, int[] protagonistes) {
        this.titol = titol;
        this.director = director;
        this.any = any;
        this.durada = durada;
        this.protagonistes = protagonistes;
    }

    public String getTitol() {
        return titol;
    }

    public String getDirector() {
        return director;
    }

    public int getAny() {
        return any;
    }

    public int getDurada() {
        return durada;
    }

    public int[] getProtagonistes() {
        return protagonistes;
    }

    public void mostrarDetalles(Actor[] actores) {
        System.out.println("Detalles de la peli: " + getTitol());
        System.out.println("Director: " + getDirector());
        System.out.println("Any: " + getAny());
        System.out.println("Durada: " + getDurada() + " minuts");
        System.out.print("Protagonistes: ");
        for (int codi : getProtagonistes()) {
            if (codi != -1) {
                for (Actor actor : actores) {
                    if (actor.getCodi() == codi) {
                        System.out.print(actor.getNom() + ", ");
                        break;
                    }
                }
            }
        }
        System.out.println();
    }

}

class Actor {
    private int codi;
    private String nom;
    private LocalDate data_Naixement;

    public Actor(int codi, String nom, LocalDate data_Naixement) {
        this.codi = codi;
        this.nom = nom;
        this.data_Naixement = data_Naixement;
    }

    public int getCodi() {
        return codi;
    }

    public String getNom() {
        return nom;
    }

    public LocalDate getData_Naixement() {
        return data_Naixement;
    }
}