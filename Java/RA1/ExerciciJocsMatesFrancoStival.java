
import java.util.Random;
import java.util.Scanner;

public class ExerciciJocsMatesFrancoStival {
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        Random random = new Random();
        try {
            
            int respostaAlumne, num1, num2, simbolo, numPreguntas = 0, resultatsCorrecte = 0, respostesCorrectes = 0;
            String pregunta = "";
            double percentage;
            boolean quitaWhile = false;
    
            System.out.println();
            System.out.println();
            System.out.print("Introdueix la quantitat de preguntes que desitges respondre: ");
            System.out.print("");
            
            while (!quitaWhile) {
                if (lector.hasNextInt()) {
                    numPreguntas = lector.nextInt();
                    quitaWhile = true;
                    break;
                } else {
                    System.out.print("Porfavor, introduzca un número válido: ");
                    lector.next();
                }
            }
    
            for (int i = 0; i < numPreguntas; i++) {
                
                num1 = random.nextInt(10) + 1;
                num2 = random.nextInt(10) + 1;
                simbolo = random.nextInt(4);
                System.out.println();
                switch (simbolo) {
                    case 0: // addition
                        resultatsCorrecte = num1 + num2;
                        pregunta = "Quin és el resultat de " + num1 + " + " + num2 + "?";
                        break;
                    case 1: // subtraction
                        resultatsCorrecte = num1 - num2;
                        pregunta = "Quin és el resultat de " + num1 + " - " + num2 + "?";
                        break;
                    case 2: // multiplication
                        resultatsCorrecte = num1 * num2;
                        pregunta = "Quin és el resultat de " + num1 + " * " + num2 + "?";
                        break;
                    case 3: // division
                        while (num2 == 0 || num1 % num2 != 0) {
                            num1 = random.nextInt(10) + 1;
                            num2 = random.nextInt(10) + 1;
                        }
                        resultatsCorrecte = num1 / num2;
                        pregunta = "Quin és el resultat de " + num1 + " / " + num2 + "?";
                        break;
                    default:
                        System.err.println ("Error");
                }
    
                System.out.println(pregunta);
                respostaAlumne = lector.nextInt();
    
                if (respostaAlumne == resultatsCorrecte) {
                    respostesCorrectes++;
                    System.out.println("Correcte!");
                } else {
                    System.out.println("Incorrecte. La resposta correcta és " + resultatsCorrecte);
                }
            }
    
            percentage = (double) respostesCorrectes / numPreguntas * 100;
    
            System.out.println();
            System.out.println("Has respost " + respostesCorrectes + " de " + numPreguntas + " preguntes correctament.");
            System.out.println("Percentatge de respostes correctes: " + percentage + "%");
    
            if (percentage >= 60) {
                System.out.println("Felicidades! Has passat el joc!");
            } else {
                System.out.println("No has passat el joc. Intenta-ho de nou!");
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
      
    }
}