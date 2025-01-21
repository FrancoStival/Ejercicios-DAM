package activitat10;

public class Castellers {
    public static void main(String[] args) {
        Castell[] arrayCastell = {
            new Castell(1, "Quatre de set", 800, 980),
            new Castell(27, "Tres de deu amb folre i manilles", 12500, 13200),
            new Castell(3, "Quatre de set amb l'agulla", 1220, 1440),
            new Castell(22, "Quatre de nou amb folre i l'agulla", 9200, 9800),
            new Castell(2, "Tres de set", 1000, 1200),
            new Castell(21, "Cinc de nou amb folre", 8600, 9180),
            new Castell(20, "Pilar de vuit amb folre i manilles", 8020, 8580)
        };

        Colla[] arrayColla = {
            new Colla("Colla Vella dels Xiquets de Valls", "Valls", new int[]{21, 3, 20}),
            new Colla("Xiquets del Serrallo", "Tarragona", new int[]{2, 1, 3}),
            new Colla("Minyons de Terrassa", "Terrassa", new int[]{22, 20, 21}),
            new Colla("Xiquets de Vilafranca", "Vilafranca", new int[]{27, 22, 20})
        };

        dadesColla("Minyons de Terrassa", arrayColla, arrayCastell);
        collesCastell("Pilar de vuit amb folre i manilles", arrayColla, arrayCastell);
    }

    public static void dadesColla(String nomColla, Colla[] arrayColla, Castell[] arrayCastell) {
        System.out.println("");
        System.out.println("");
        for (Colla colla : arrayColla) {
            if (colla.getNom().equalsIgnoreCase(nomColla)) {
                System.out.println("Colla: " + colla.getNom());
                for (int codiCastell : colla.getCodisCastellsPrincipals()) {
                    for (Castell castell : arrayCastell) {
                        if (castell.getCodi() == codiCastell) {
                            System.out.println("Castell: " + castell.getDescripcio());
                        }
                    }
                }
                return;
            }
        }
        System.out.println("Colla no trobada: " + nomColla);
    }

    public static void collesCastell(String nomCastell, Colla[] arrayColla, Castell[] arrayCastell) {
        System.out.println("");
        System.out.println("");
        System.out.println("Castell: " + nomCastell);
        boolean castellTrobat = false;
        for (Castell castell : arrayCastell) {
            if (castell.getDescripcio().equalsIgnoreCase(nomCastell)) {
                castellTrobat = true;
                for (Colla colla : arrayColla) {
                    for (int codiCastell : colla.getCodisCastellsPrincipals()) {
                        if (codiCastell == castell.getCodi()) {
                            System.out.println("Colla: " + colla.getNom());
                        }
                    }
                }
                break;
            }
        }
        if (!castellTrobat) {
            System.out.println("No s'ha trobat el castell: " + nomCastell);
        }
    }
}