
import java.util.Calendar;

public class Exercici3_2FrancoStival {
   public static void main(String[] args) {
      Calendar calendar = Calendar.getInstance();
      int day = calendar.get(Calendar.DAY_OF_WEEK);
      //day=1 diumenge
      System.out.println("Day: " + day);
      int hour = calendar.get(Calendar.HOUR_OF_DAY);
      System.out.println("Hour: " + hour);
      int minute = calendar.get(Calendar.MINUTE);
      System.out.println("Minute: " + minute);
      boolean trabajar = false;

      if (day >= 2 && day  <= 6){
         if (hour >= 8 && hour <= 20){
           trabajar  = true;
          }
      }

      if (trabajar) {
         System.out.println("Puedes acceder a la sesión de trabajo");
      } else {
         System.out.println("No puedes acceder a la sesión de trabajo");
      }
   }
}

/*Creado por Franco Stival Martincich
* El 24 de septiembre de 2024
* El Archivo no tiene mi nombre porque sino no lo deja enviar
*/
