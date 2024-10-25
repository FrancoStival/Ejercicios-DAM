import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercici17_1FrancoStival {
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);

        try {
            int[] nums = new int[5];
            for (int i = 0; i < nums.length; i++) {
                System.out.println("Introdueix un numero");
                nums[i] = lector.nextInt();
            }
            System.out.println("");
            for (int i = 0; i < nums.length; i++) {
                System.out.println(nums[i]);
            }
            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                sum +=  nums[i];
            }
            System.out.println("La suma dels elements del array és: " + sum);
            int max = Integer.MAX_VALUE, min = Integer.MIN_VALUE;
            for (int i = 0; i < nums.length; i++) {
                if( nums[i] >  min){
                    min = nums[i];
                }
                if (nums[i] < max){
                    max = nums[i];
                }
            }
            System.out.println("El major element del array és: " + max);
            System.out.println("El menor element del array és: " + min);
            System.out.println("El numero del medio es: " + nums[2]);
        } catch (InputMismatchException e) {
            System.out.println("Error, has introducido un valor que no es un numero.");
            System.out.println("Vuelve a intentarlo.");
            lector.next();
        } finally{
            lector.close();
        }
    }
}
