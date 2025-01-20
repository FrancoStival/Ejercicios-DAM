package activitat9;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.Locale;

public class paciente {
    // El "final" significa que no se agregan atributos al objeto durante el codigo
    private final String nom;
    private final String codiSS;
    private final String dni;
    private final LocalDate dataingres;
    private final char radiografia;

    public paciente(String nom, String codiSS, String dni, LocalDate dataingres, char radiografia) {
        this.nom = nom;
        this.codiSS = codiSS;
        this.dni = dni;
        this.dataingres = dataingres;
        this.radiografia = radiografia;
    }

    public String getNom() {
        return nom;
    }

    public String getCodiSS() {
        return codiSS;
    }

    public String getDni() {
        return dni;
    }

    public LocalDate getDataingres() {
        return dataingres;
    }

    public char getRadiografia() {
        return radiografia;
    }

    public void mostrarDades() {
        System.out.println();
        System.out.println();
        System.out.println("Dades del pacient amb codi SS: " + codiSS);
        System.out.println("Nom: " + nom);
        System.out.println("DNI: " + dni);
        System.out.println("Data d'ingrés: " + formatarData(dataingres));
        System.out.println((radiografia == 's' ? "Si" : "No") + " li han fet una radiografia");
    }

    public String formatarData(LocalDate data) {
        Month mes = data.getMonth();
        String mesCatala = mes.getDisplayName(TextStyle.FULL, new Locale("ca", "ES"));
        return data.getDayOfMonth() + " de " + mesCatala + " de " + data.getYear();

    }
}
