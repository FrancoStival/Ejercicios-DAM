public class Exercici10_2FrancoStival {
    public static void main(String[] args) {
        System.out.println("----------------------------------------");
        for (int i = 1; i < 101; i++) {
            System.out.print("| " + i + " ");
            if (i == 100) {
                System.out.println("|");
                System.out.println("----------------------------------------");
                break;
            }
            if (i % 8 == 0) {
                System.out.println("|");
                if (i <= 100) {
                    System.out.println("----------------------------------------");
                }
            }
        }
    }
}