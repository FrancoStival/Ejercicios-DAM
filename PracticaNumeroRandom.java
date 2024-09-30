
import java.util.Random;

public class PracticaNumeroRandom {
    public static void main(String[] args) {
        Random random  = new Random();
        int numeroRandom = random.nextInt(100) + 1; //El 100 indica que te da un numero entre 0 y 99, le podemos sumar 1 para que sea entre 1 y 100
        System.out.println(numeroRandom);
    }
}
