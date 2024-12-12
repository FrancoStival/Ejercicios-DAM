import java.util.Scanner;

public class Exercici18_1FrancoStival {
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        String cadena;
        char character;
        char[] array;
        int cantidad = 0;
        try {
            System.out.print("Entra un texto: ");
            cadena = lector.nextLine();
            System.out.print("Entra un caracter: ");
            character = lector.next().charAt(0);
            array = cadena.toCharArray();
           
            System.out.print("El caracter " + character + " es troba a les posicions: ");
            for (int i = 0; i < array.length; i++) {
                if (array[i] == character) {
                    cantidad++;
                    System.out.print((i + 1) + " ");
                }
            }
            System.out.println();
            System.out.println("Surt " + cantidad + " cops.");

        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            lector.close();
            System.out.println("El programa ha finalizado");
        }

    }
}
