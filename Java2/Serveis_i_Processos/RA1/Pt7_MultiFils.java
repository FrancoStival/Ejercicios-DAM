package RA1;
import java.util.Random;
public class Pt7_MultiFils {
    public static void main(String[] args) {
        new Thread(new Guerrer("Kelsier", 10, 8)).start();
        new Thread(new Mag("Dalinar", 6, 10)).start();
    }
}
abstract class Personatge implements Runnable {
    private final String nom;
    private int vida;
    private final int dau;

    public Personatge(String nom, int vida, int dau) {
        this.nom = nom;
        this.vida = vida;
        this.dau = dau;
    }
    public void rebreDany(int punts) {
        vida -= punts;
        System.out.println(getNom() + " rep " + punts + " punts de dany. Vida restant: " + vida);
    }

    public void atacarAlEnemic() {
        Random random = new Random();
        int dany = random.nextInt(getdau()) + 1;
        System.out.println(getNom() + " ataca al enemigo. Tira un dau de "+ getdau() + ". Y hace " + dany + " punts de dany.");
    }

    public String getNom() {
        return nom;
    }
    public int getVida() {
        return vida;
    }
    public int getdau() {
        return dau;
    }

    @Override
    public void run() {
        Random random = new Random();
        
        for (int i = 0; i < 5; i++) {
            int pause = 500 + random.nextInt(1001);
            atacarAlEnemic();
            try {
                Thread.sleep(pause);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class Guerrer extends Personatge {
    public Guerrer(String nom, int vida, int dau) {
        super(nom, vida, dau);
    }
}
class Mag extends Personatge {
    public Mag(String nom, int vida, int dau) {
        super(nom, vida, dau);
    }
}
