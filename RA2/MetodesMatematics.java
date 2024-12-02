import java.util.Scanner;

public class MetodesMatematics {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MetodesMatematics programa = new MetodesMatematics();
        System.out.println("");
        System.out.println("Introdueix quatre números per calcular la mitjana:");
        double n1 = scanner.nextDouble();
        double n2 = scanner.nextDouble();
        double n3 = scanner.nextDouble();
        double n4 = scanner.nextDouble();
        double mitjana = programa.mitjana(n1, n2, n3, n4);
        System.out.println("Mitjana: " + mitjana);

        System.out.println();

        System.out.println("Introdueix un número per comptar els dígits:");
        long numeroDigits = scanner.nextLong();
        int comptaDigits = programa.comptaDigits(numeroDigits);
        System.out.println("Nombre de dígits: " + comptaDigits);

        System.out.println();

        System.out.println("Introdueix dos números per comprovar si el primer és múltiple del segon:");
        int n = scanner.nextInt();
        int d = scanner.nextInt();
        boolean esMultiple = programa.esMultiple(n, d);
        System.out.println("És " + n + " un múltiple de " + d + "? " + esMultiple);

        System.out.println();

        System.out.println("Introdueix un número per calcular el factorial:");
        int factorialNum = scanner.nextInt();
        int resultatFactorial = programa.factorial(factorialNum);
        System.out.println("Factorial de " + factorialNum + ": " + resultatFactorial);

        System.out.println();

        System.out.println("Introdueix un número per comprovar si és perfecte:");
        int nombrePerfecte = scanner.nextInt();
        boolean esPerfecte = programa.esNombrePerfecte(nombrePerfecte);
        System.out.println("És " + nombrePerfecte + " un número perfecte? " + esPerfecte);

        scanner.close();
    }

    public double mitjana(double n1, double n2, double n3, double n4) {
        return (n1 + n2 + n3 + n4) / 4;
    }

    public int comptaDigits(long n) {
        int digits = 0;
        while (n != 0) {
            n /= 10;
            digits++;
        }
        return digits;
    }

    public boolean esMultiple(int n, int d) {
        return n % d == 0;
    }

    public int factorial(int n) {
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }

    public boolean esNombrePerfecte(int n) {
        if (n <= 0) {
            return false;
        }

        int suma = 0;
        for (int i = 1; i < n; i++) {
            if (n % i == 0) {
                suma += i;
            }
        }

        return suma == n;
    }
}