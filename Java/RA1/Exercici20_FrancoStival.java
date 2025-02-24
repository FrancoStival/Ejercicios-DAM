import java.util.Random;

public class Exercici20_FrancoStival {
    public static void main(String[] args) {
        Random random = new Random();
        int velocitat1, velocitat2, obstacle1, obstacle2;
        int posicioTortuga1 = 0, posicioTortuga2 = 0, torns = 1;
        boolean quitaCarrera = false;
        while (!quitaCarrera) {
            System.out.println();
            System.out.println();
            System.out.println("Torn " + torns);
            velocitat1 = random.nextInt(3) + 1;
            velocitat2 = random.nextInt(3) + 1;
            obstacle1 = random.nextInt(6) + 1;
            obstacle2 = random.nextInt(6) + 1;
            switch (obstacle1) {
                case 1:
                    velocitat1 = velocitat1 / 2;
                    System.out.println("La tortuga 1 s'ha trobat amb un obstacle Relliscós. La seva velocitat es redueix a la meitat.");
                    break;
                case 2:
                    posicioTortuga1 -= 1;
                    System.out.println("La tortuga 1 s'ha trobat amb un obstacle Pedregós i ha de donar un pas enrere.");
                    break;
                case 3:
                    posicioTortuga1 -= 3;
                    System.out.println("La tortuga 1 s'ha trobat amb una Trampa de Fang i ha de retrocedir 3 passos.");
                    break;
                default:
                    break;
            }
            switch (obstacle2) {
                case 1:
                    velocitat2 = velocitat2 / 2;
                    System.out.println("La tortuga 2 s'ha trobat amb un obstacle Relliscós. La seva velocitat es redueix a la meitat.");
                    break;
                case 2:
                    posicioTortuga2 -= 1;
                    System.out.println("La tortuga 2 s'ha trobat amb un obstacle Pedregós i ha de donar un pas enrere.");
                    break;
                case 3:
                    posicioTortuga2 -= 3;
                    System.out.println("La tortuga 2 s'ha trobat amb una Trampa de Fang i ha de retrocedir 3 passos.");
                    break;
                default:
                    break;
            }
                
            if (posicioTortuga1 < 0) {
                posicioTortuga1 = 0;
            }
            if (posicioTortuga2 < 0){
                posicioTortuga2 = 0;
            }

            posicioTortuga1 += velocitat1;
            posicioTortuga2 += velocitat2;
            System.out.println("La tortuga 1 es mou amb una velocitat de " + velocitat1 + " i arriba a la posició " + posicioTortuga1);
            System.out.println("La tortuga 2 es mou amb una velocitat de " + velocitat2 + " i arriba a la posició " + posicioTortuga2);
            if (posicioTortuga1 >= 10 || posicioTortuga2 >= 10) {
                quitaCarrera = true;
            }
            torns ++;
        }
        System.out.println("");
        System.out.println("");
        if (posicioTortuga1 >= 10){
            System.out.println("La tortuga 1 ha arribat a la meta!");
        }
        if (posicioTortuga2 >= 10){
            System.out.println("La tortuga 2 ha arribat a la meta!");
        }else{
            System.out.println("La tortuga 2 ha arribat a la meta!");
            System.out.println("Empat. Les dues tortuges han arribat a la vegada");
        }
    }
}
