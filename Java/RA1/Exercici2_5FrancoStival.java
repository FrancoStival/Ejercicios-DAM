import java.util.Scanner;

public class Exercici2_5FrancoStival {
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        System.out.println("");
        System.out.println("");
        System.out.println("Dependiendo del precio de tu compra se te aplicará un descuento");
        System.out.println("Escribe el precio de tu compra: ");
        double precio = lector.nextDouble();
        if (precio < 500) {
            System.out.println("Tienes un descuento del 5%");
            precio  = precio * 0.95;
            System.out.println("El precio final es:  " + precio);
        } else if (precio >= 500 && precio < 1000) {
            System.out.println("Tienes un descuento del 8%");
            precio = precio * 0.92;
            System.out.println("El precio final es:  " + precio);
        } else if (precio  >= 1000 &&  precio <= 5000) {
            System.out.println("Tienes un descuento del 15%");
            precio = precio * 0.85;
            System.out.println("El precio final es:  " + precio);
        } else if (precio > 5000){
            System.out.println("Tienes un descuento del 25%");
            precio = precio * 0.75;
            System.out.println("El precio final es:  " + precio);
        } else {
            System.out.println("Error, no puedes comprar");
        }
    }
}
