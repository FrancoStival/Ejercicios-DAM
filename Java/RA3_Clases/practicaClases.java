package javaclases;
public class practicaClases {
    public static void main(String[] args) {
        Coche cocheAlberto = new Coche("Audi", "A4", 2015, "Blanco", 0.0);
        cocheAlberto.mostrarDetalles();
        cocheAlberto.acelerar(300);
        cocheAlberto.mostrarDetalles();

    }

}

class Coche {
    private String marca;
    private String modelo;
    private int año;
    private String color;
    private double kilometraje;

    public Coche(String marca, String modelo, int año, String color, double kilometraje) {
        this.marca = marca;
        this.modelo = modelo;
        this.año = año;
        this.color = color;
        this.kilometraje = kilometraje;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAño() {
        return año;
    }

    public String getColor() {
        return color;
    }

    public double getKilometraje() {
        return kilometraje;
    }

    public void mostrarDetalles() {
        System.out.println("");
        System.out.println("Datos del Coche:");
        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);
        System.out.println("Año: " + año);
        System.out.println("Color: " + color);
        System.out.println("Kilometraje: " + kilometraje);
    }

    public void acelerar (double km){
        kilometraje = kilometraje + km;
    }
}
