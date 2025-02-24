package RA2;
import java.util.Random;

public class MetodesArrays {

    public static void main(String[] args) {
        // Ejemplo de uso de los métodos
        MetodesArrays metodes = new MetodesArrays();
        
        int[] array = new int[10];
        metodes.incicialitzaAleatori(array, 1, 100);
        metodes.imprimir(array);
        
        System.out.println("Suma: " + metodes.suma(array));
        System.out.println("Mitjana: " + metodes.mitjana(array));
        System.out.println("Max: " + metodes.max(array));
        System.out.println("Min: " + metodes.min(array));
        
        int[] multiplicado = metodes.multiplica(array, 2);
        metodes.imprimir(multiplicado);
        
        int[] array2 = new int[10];
        metodes.incicialitzaAleatori(array2, 1, 100);
        metodes.imprimir(array2);
        
        int[] sumaArrays = metodes.suma(array, array2);
        metodes.imprimir(sumaArrays);
    }

    /**
     * Inicialitza un array d'enters amb valors aleatoris compresos entre dos
     * valors determinats
     * @param array l'array que cal inicialitzar
     * @param desDe el mínim valor possible
     * @param finsA el màxim valor possible
     */
    public void incicialitzaAleatori(int[] array, int desDe, int finsA) {
        Random rand = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(finsA - desDe + 1) + desDe;
        }
    }

    /**
     * Imprimeix en una línia tots els valors del vector
     * @param vector un vector d'enters
     */
    public void imprimir(int[] vector) {
        for (int i = 0; i < vector.length; i++) {
            System.out.print(vector[i] + " ");
        }
        System.out.println();
    }

    /**
     * Suma tots els elements d'un vector
     * @param llista el vector d'enters per sumar
     * @return la suma dels elements del vector
     */
    public int suma(int[] llista) {
        int suma = 0;
        for (int num : llista) {
            suma += num;
        }
        return suma;
    }

    /**
     * Calcula la mitjana aritmètica dels elements d'un vector
     * @param llista un vector d'enters
     * @return la mitjana aritmètica del vector
     */
    public double mitjana(int[] llista) {
        if (llista.length == 0) return 0;
        return (double) suma(llista) / llista.length;
    }

    /**
     * Obté el valor màxim d'una llista d'enters
     * @param llista un vector d'enters
     * @return el valor màxim trobat en el vector
     */
    public int max(int[] llista) {
        int max = llista[0];
        for (int num : llista) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    /**
     * Obté el valor mínim d'una llista d'enters
     * @param llista un vector d'enters
     * @return el valor mínim trobat en el vector
     */
    public int min(int[] llista) {
        int min = llista[0];
        for (int num : llista) {
            if (num < min) {
                min = num;
            }
        }
        return min;
    }

    /**
     * Multiplica cada element d'un vector per un valor determinat
     * @param array un vector d'enters
     * @param n el número pel qual es multiplicarà
     * @return un vector que conté cada element del vector proporcionat multiplicat pel valor n
     */
    public int[] multiplica(int[] array, int n) {
        int[] resultat = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            resultat[i] = array[i] * n;
        }
        return resultat;
    }

    /**
     * Realitza la suma de dos vectors suma[i] = array1[i] + array2[i]
     * @param array1 un vector d'enters
     * @param array2 un vector d'enters
     *```java
     * @return un vector d'enters que resulta de sumar els valors que hi ha
     * en les mateixes posicions dels dos vectors proporcionats en els arguments
     */
    public int[] suma(int[] array1, int[] array2) {
        if (array1.length != array2.length) {
            throw new IllegalArgumentException("Els arrays han de tenir la mateixa longitud");
        }
        int[] resultat = new int[array1.length];
        for (int i = 0; i < array1.length; i++) {
            resultat[i] = array1[i] + array2[i];
        }
        return resultat;
    }
}