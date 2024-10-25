import java.util.Random;

public class Exercici12_1FrancoStival {
    public static void main(String[] args) {
        Random random = new Random();
        int cares = 0, creus = 0, num;
        for (int i = 0; i < 100; i++) {
            num = random.nextInt(2) + 1;
            if (num == 1){
                cares++;
            }else if (num == 2) {
                creus++;
            }else{
                System.out.println("Error");
            }
        }
        System.out.println("Cares: " + cares);
        System.out.println("Creus: " + creus);
    }
}