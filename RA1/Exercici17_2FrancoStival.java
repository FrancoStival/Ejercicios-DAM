import java.util.Random;

public class Exercici17_2FrancoStival {
    public static void main(String[] args) {
        try {
            double[] temperaturas = new double[12];
            Random random = new Random();

            for (int i = 0; i < temperaturas.length; i++) {
                temperaturas[i] = random.nextDouble() * 40;
            }

            double suma = 0;
            for (double temp : temperaturas) {
                suma += temp;
            }
            double media = suma / temperaturas.length;

            int contadorSuperiores = 0;
            for (double temp : temperaturas) {
                if (temp >= media) {
                    contadorSuperiores++;
                }
            }

            double temperaturaMinima = temperaturas[0];
            int posicionMinima = 0;

            for (int i = 1; i < temperaturas.length; i++) {
                if (temperaturas[i] < temperaturaMinima) {
                    temperaturaMinima = temperaturas[i];
                    posicionMinima = i;
                }
            }

            System.out.println("Temperaturas: ");
            for (double temp : temperaturas) {
                System.out.printf("%.2f ", temp);
            }
            System.out.println("\nTemperatura media: " + media);
            System.out.println("Número de temperaturas superiores o iguales a la media: " + contadorSuperiores);
            System.out.println("Temperatura mínima: " + temperaturaMinima + " en la posición " + posicionMinima);

        } catch (Exception e) {
            System.out.println("Ha ocurrido un error: " + e.getMessage());
        }
    }
}