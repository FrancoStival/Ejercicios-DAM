import java.util.Scanner;

public class Exercici11_2FrancoStival {
    public static void main(String[] args) {
        Scanner lector =  new Scanner(System.in);
        int numIntroduit = 0, resposta = 0, resultadoVerdadero = 0, oportunitats = 2, errors = 0;
        boolean quitaWhile = false, quitaWhile2 = false;

        System.out.println("Introdueix un número: ");
        
        while (!quitaWhile) {
            if (lector.hasNextInt()) {
                numIntroduit = lector.nextInt();
                quitaWhile = true;
            } else {
                System.out.print("Porfavor, introduzca un número válido: ");
                lector.next();
            }
        }
        quitaWhile = false;
        for (int i = 1; i < 11; i++) {
            oportunitats = 2;
            resultadoVerdadero =  numIntroduit * i;
            System.out.println("Introdueix el resultat de " + numIntroduit + " x  " + i + ": ");
            
            while (!quitaWhile) {
                if (lector.hasNextInt()) {
                    resposta = lector.nextInt();
                    while (resposta != resultadoVerdadero &&  oportunitats > 0) {
                        System.out.println("Incorrecte, tens " + oportunitats + " intents més. Torna a probar: ");

                        while (!quitaWhile2) {
                            if (lector.hasNextInt()) {
                                resposta = lector.nextInt();
                                quitaWhile2 = true;
                            } else {
                                System.out.print("Porfavor, introduzca un número entero válido: ");
                                lector.next();
                            }
                        }
                        quitaWhile2 = false;
                        oportunitats --;
                    }
                    
                    quitaWhile = true;
                } else {
                    System.out.print("Porfavor, introduzca un número válido: ");
                    lector.next();
                }
            }
            if (oportunitats  == 0) {
                errors ++;
            }
            if (errors > 0) {
                System.out.println("Tens " + errors + " errors");
            }
            quitaWhile = false;
            quitaWhile2 = false;
            if (errors >= 3) {
                System.out.println("");
                System.out.println("");
                System.out.println();
                System.out.println("Tens més de 3 errors, el programa es reiniciarà.");
                System.out.println("");
                System.out.println("Introdueix un número: ");
        
                while (!quitaWhile) {
                    if (lector.hasNextInt()) {
                        numIntroduit = lector.nextInt();
                        quitaWhile = true;
                    } else {
                        System.out.print("Porfavor, introduzca un número válido: ");
                        lector.next();
                    }
                }
                i = 0;
                errors = 0;
                resposta = 0;
                resultadoVerdadero = 0;
                oportunitats = 2;
                quitaWhile = false;
                quitaWhile2 = false;
            }
        }

        lector.close();
    }
}
