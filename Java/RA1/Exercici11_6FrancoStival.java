public class Exercici11_6FrancoStival {
    public static void main(String[] args) {
        System.out.println("Conversió de temperatures en graus Fahrenheit a graus Centígrads:");
        System.out.println("---------------------------------------------------------------");
        System.out.println("| Graus Fahrenheit (ºF) | Graus Centígrads (ºC) |");
        System.out.println("---------------------------------------------------------------");

        for (int fahrenheit = 0; fahrenheit <= 300; fahrenheit += 20) {
            double centigrads = (fahrenheit - 32) * 5.0 / 9.0;
            System.out.printf("| %-21d | %-21.2f |%n", fahrenheit, centigrads);
        }

        System.out.println("---------------------------------------------------------------");
    }
}