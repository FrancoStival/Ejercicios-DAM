
public class MinMaxExemple {
    public static void main(String[] args) {
        int[] numeros = {3, 5, -1, 42, 7, 0, -15, 8};

        int max = Integer.MIN_VALUE; // Inicializa el máximo con el mínimo posible
        int min = Integer.MAX_VALUE; // Inicializa el mínimo con el máximo posible

        for (int numero : numeros) {
            if (numero > max) {
                max = numero; // Actualiza el máximo
            }
            if (numero < min) {
                min = numero; // Actualiza el mínimo
            }
        }

        System.out.println("Número máximo: " + max);
        System.out.println("Número mínimo: " + min);
    }
}
/*
 * El programa hace una lista de numeros
 * Luego dos variables con el numero más pequeño posible y el más grande
 * Si un numero es mas grande que el que hay en la variable, 
 * el valor de la variable se actualiza al nuevo más grande.
 * Lo mismo al revés
 */