import java.util.Random;

public class ActivitatAvaluable2_FrancoStival {
    public static void main(String[] args) {
        Random random = new Random();
        int posicióCotxe1 = 0, posicióCotxe2 = 0, torns = 11, movimentCotxe1 = 0, movimentCotxe2 = 0;
        boolean enLaMeta = false;

        while (!enLaMeta || torns < 11) {
            System.out.println();
            System.out.println("Torns : " + torns);
            movimentCotxe1 = random.nextInt(2) + 1;
            movimentCotxe2 = random.nextInt(2) + 1;
            System.out.println("Cotxe1 avança: " + movimentCotxe1);
            System.out.println("Cotxe2 avança: " + movimentCotxe2);
            posicióCotxe1 += movimentCotxe1;
            posicióCotxe2 += movimentCotxe2;

            if (movimentCotxe1 % 2 == 0) {
                System.out.println("Cotxe 1. Corba tancada. Retrocedeix: " + (posicióCotxe1 / 2));
                posicióCotxe1 -= posicióCotxe1 / 2;
            } else if (movimentCotxe1 % 2 == 1) {

                System.out.println("Cotxe 1. Accelera en recta: " + ((posicióCotxe1 + 1) / 2));
                posicióCotxe1 += (posicióCotxe1 + 1) / 2;
            } else {
                System.out.println("Error");
            }

            if (movimentCotxe2 % 2 == 0) {
                System.out.println("Cotxe 2. Corba tancada. Retrocedeix: " + (posicióCotxe2 / 2));
            } else if (movimentCotxe2 % 2 == 1) {
                System.out.println("Cotxe 2. Accelera en recta: " + ((posicióCotxe2 + 1) / 2));
                posicióCotxe2 += (posicióCotxe2 + 1) / 2;
            } else {
                System.out.println("Error");
            }
            if (posicióCotxe1 == 3 || posicióCotxe1 == 7) {
                System.out.println("Cotxe 1 s'ha trobat amb un obstacle. Retrocedeix 2 posicions.");
                posicióCotxe1 -= 2;
            }
            if (posicióCotxe2 == 3 || posicióCotxe2 == 7) {
                System.out.println("Cotxe 2 s'ha trobat amb un obstacle. Retrocedeix 2 posicions.");
                posicióCotxe2 -= 2;
            }
            if(posicióCotxe1 <= 0){
                posicióCotxe1 = 0;
            }
            if(posicióCotxe2 <= 0){
                posicióCotxe2 = 0;
            }
            System.out.print("Cotxe 1 (Posició actual: " + posicióCotxe1 + ")");
            for (int i = 0; i < posicióCotxe1; i++) {
                System.out.print(" =");
            }
            System.out.println();

            System.out.print("Cotxe 2 (Posició actual: " + posicióCotxe2 + ")");
            for (int i = 0; i < posicióCotxe2; i++) {
                System.out.print(" =");
            }
            System.out.println();

            if (posicióCotxe1 >= 10 || posicióCotxe2 >= 10) {
                enLaMeta = true;
            }
            System.out.println();

        }
        
        System.out.println("Hem acabat la carrera!");
        if (posicióCotxe1 > posicióCotxe2) {
            System.out.println("Ha guanyat el Cotxe 1");
        } else if (posicióCotxe2 > posicióCotxe1) {
            System.out.println("Ha guanyat el Cotxe 2");
        } else if (posicióCotxe1 == posicióCotxe2) {
            System.out.println("Empat");
        }
    }
}
