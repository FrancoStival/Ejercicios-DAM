
import java.util.Scanner;

public class Exercici9_0_1FrancoStival {
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        int numeroInicial = 0, numeroPersona = 0;
        boolean quitaWhie = false;

        System.out.println("Dime un numero y te mostraré todos los numeros que hay desde el 1 hasta el numero que me has dicho.");
        System.out.println("Escribe un numero entero");
        while(!quitaWhie){
            if(lector.hasNextInt()){
                numeroPersona = lector.nextInt();
                quitaWhie = true;
            }else{
                System.out.println("Introduce un numero entero valido.");
            }
        }
        System.out.println();
        System.out.println();
        System.out.println("Los numeros intermedios son:");
        do{
            System.out.println(numeroInicial);
            numeroInicial += 1;
        }while(numeroInicial <= numeroPersona);
    }
}
