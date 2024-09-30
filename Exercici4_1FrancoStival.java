import java.util.Scanner;

public class Exercici4_1FrancoStival {
    public static void main(String[] args) {
        System.out.println("");
        System.out.println("");
        System.out.println("Este programa cogerá los dos numeros que les des y los operará con el simbolo que le digas");
        Scanner lector = new Scanner(System.in);
        System.out.print("Introduce el primer numero: ");
        int num1 = lector.nextInt();
        System.out.print("Introduce el segundo numero: ");
        int num2 = lector.nextInt();
        System.out.print("Introduce el simbolo que quieras usar (+, -, *, /, %): ");
        char simbolo = lector.next().charAt(0); //Segun StackOverflow esta es la mejor forma de leer un solo caracter
        double resultado = 0; // No me deja declarar a variable y ya, le tengo que asignar un valor o sino no compila
        if (simbolo == '+'){
            resultado = num1 + num2;
        }else if (simbolo == '-'){
            resultado = num1 - num2;
        }else if (simbolo == '*'){
            resultado = num1 * num2;
        }else if (simbolo == '/'){
            resultado = num1 / num2;
        }else if (simbolo == '%') {
            resultado = num1 % num2;
        } else {
            System.out.println("Error caracter no valido");
        }
        System.out.println("El resultado es: " + resultado);
    }
}
