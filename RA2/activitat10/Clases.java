package activitat10;


class Castell {
    private int codi;
    private String descripcio;
    private int puntsCarregats;
    private int puntsDescarregats;

    public Castell(int codi, String descripcio, int puntsCarregats, int puntsDescarregats) {
        this.codi = codi;
        this.descripcio = descripcio;
        this.puntsCarregats = puntsCarregats;
        this.puntsDescarregats = puntsDescarregats;
    }

    public int getCodi() {
        return codi;
    }

    public String getDescripcio() {
        return descripcio;
    }
}

class Colla {
    private String nom;
    private String localitat;
    private int[] codisCastellsPrincipals;

    public Colla(String nom, String localitat, int[] codisCastellsPrincipals) {
        this.nom = nom;
        this.localitat = localitat;
        this.codisCastellsPrincipals = codisCastellsPrincipals;
    }

    public String getNom() {
        return nom;
    }

    public int[] getCodisCastellsPrincipals() {
        return codisCastellsPrincipals;
    }
}
