import java.util.Scanner;

public class Exercici11_1FrancoStival {
    public static void main(String[] args) {

        Scanner lector = new Scanner(System.in);
        int valorIntroduit = 0,  suma = 0;
        boolean quitaWhile = true;
        do {
            System.out.println();
            System.out.println("Introdueix un valor entre 1 i 5:");
            while (quitaWhile) {
                if (lector.hasNextInt()) {
                    valorIntroduit = lector.nextInt();
                    if (valorIntroduit >= 1 && valorIntroduit <= 5) {
                        quitaWhile = false;
                    }else{
                        while (valorIntroduit <= 0 || valorIntroduit >= 6) {
                            System.out.println("El valor introduit no és vàlid. Introdueix un valor entre 1 i 5");
                            valorIntroduit = lector.nextInt();
                            quitaWhile = false;
                        }
                    }
                }else{
                    System.out.println("Introdueix un nombre sencer entre 1 i 5");
                    lector.next();
                }
            }
            quitaWhile = true;
            suma += valorIntroduit;
            System.out.println("El valor de la suma actual es: " + suma);
        } while (suma < 22);
        System.out.println("La suma ha superat els 22");
        System.out.println("L'ultim nombre introduit va ser: " + valorIntroduit);
        lector.close();
    }
}
