
import java.util.Scanner;

public class Exercici5FrancoStival {
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);

        char tipoDia;
        char tarjetaJoven;

        System.out.println("");
        System.out.println("");

        while (true){ //Este while esta siempre activo pq 'true'
            System.out.println("Introduce si hoy es un dia laborable (L) o un fin de semana (F): ");
            tipoDia = lector.next().charAt(0);
            if (tipoDia == 'L' || tipoDia == 'F' || tipoDia == 'l' || tipoDia == 'f'){ // Cuando esta condicion se cumple
                break;                                                                 // Se rompe el bucle
            } else { 
                System.out.println("Entrada incorrecta. Prueba otra vez.");  // En caso de que no se cumpla la condicion el bucle se repite                                 
            }
        }

        while (true) { 
            System.out.println("Tienes el carnet Joven (S/N)?");
            tarjetaJoven = lector.next().charAt(0);
            if  (tarjetaJoven == 'S' || tarjetaJoven == 'N' || tarjetaJoven == 's'  || tarjetaJoven == 'n'){
                break;
            } else {
                System.out.println("Entrada incorrecta. Prueba otra vez.");
            }
        }

        double precio = 5;

        if (tipoDia == 'F' || tipoDia == 'f'){
            System.out.println("Los fines de semana la entrada es un 10% más caro");
            precio  = precio * 1.1;
        }
        
        System.out.println("");

        if (tarjetaJoven == 'S' || tarjetaJoven == 's'){
            System.out.println("Con el carnet joven la entrada es un 15% más barata");
            precio = precio * 0.85;
        }

        System.out.println("");

        System.out.println("El precio de la entrada es: " + precio);
    }
}

    

