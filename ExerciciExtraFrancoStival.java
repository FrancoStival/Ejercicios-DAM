import java.util.Scanner;

public class ExerciciExtraFrancoStival {
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        double Num1 = lector.nextDouble();
        double Num2 = lector.nextDouble();
        double Num3 = lector.nextDouble();
        double r1 = (-Num2 - Math.sqrt(Num2 * Num2 - 4 * Num1 * Num3)) /(2 * Num1);
        double r2 = (-Num2 + Math.sqrt(Num2 * Num2 - 4 * Num1 * Num3)) /( 2 * Num1);
        System.out.println("La primera raíz es: " + r1);
        System.out.println("La segunda raíz es: " + r2);
    }
}
