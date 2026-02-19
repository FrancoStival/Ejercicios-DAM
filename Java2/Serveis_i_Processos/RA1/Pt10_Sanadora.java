
import java.util.*;

class Ogre implements Runnable {
    private int vida = 4000;
    private final List<Heroi> herois;
    private final Random rnd = new Random();

    public Ogre(List<Heroi> herois) {
        this.herois = herois;
    }

    public synchronized void rebreDany(int dany, String nom) {
        if (vida <= 0) return;
        vida -= dany;
        if (vida < 0) vida = 0;
        System.out.println(nom + " fa " + dany + " de dany. Ogre: " + vida);
    }

    public synchronized boolean estaViu() {
        return vida > 0;
    }

    public void run() {
        while (estaViu()) {

            boolean algunViu = false;
            for (Heroi h : herois) {
                if (h.estaViu()) {
                    algunViu = true;
                    break;
                }
            }

            if (!algunViu) {
                System.out.println("Todo el equipo ha muerto. El Ogro ha ganado");
                return;
            }

            Heroi h = herois.get(rnd.nextInt(herois.size()));
            if (h.estaViu()) {
                h.rebreAtac(20 + rnd.nextInt(21));
            }

            try {
                Thread.sleep(400 + rnd.nextInt(400));
            } catch (InterruptedException e) {}
        }
    }
}

abstract class Heroi implements Runnable {
    protected final String nom;
    protected int vida = 100;
    protected final Ogre ogre;
    protected final Random rnd = new Random();

    public Heroi(String nom, Ogre ogre) {
        this.nom = nom;
        this.ogre = ogre;
    }

    public synchronized boolean estaViu() {
        return vida > 0;
    }

    public synchronized void rebreAtac(int dany) {
        if (vida <= 0) return;

        if (rnd.nextInt(100) < 20) {
            System.out.println(nom + " esquiva l'atac");
            return;
        }

        vida -= dany;

        if (vida <= 0) {
            vida = 0;
            System.out.println(nom + " cae KO y espera a Eylin");

            try {
                wait();
            } catch (InterruptedException e) {}

            System.out.println(nom + " ha sido revivido y vuelve al combate");
        } else {
            System.out.println(nom + " rep " + dany + " de dany. Vida: " + vida);
        }
    }
}

class Guerrer extends Heroi {
    public Guerrer(String nom, Ogre ogre) {
        super(nom, ogre);
    }

    public void run() {
        while (ogre.estaViu()) {
            synchronized (this) {
                if (vida > 0) {
                    ogre.rebreDany(70 + rnd.nextInt(30), nom);
                }
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {}
        }
    }
}

class Mag extends Heroi {
    public Mag(String nom, Ogre ogre) {
        super(nom, ogre);
    }

    public void run() {
        while (ogre.estaViu()) {
            synchronized (this) {
                if (vida > 0) {
                    ogre.rebreDany(30 + rnd.nextInt(20), nom);
                }
            }
            try {
                Thread.sleep(600);
            } catch (InterruptedException e) {}
        }
    }
}

class Picar extends Heroi {
    public Picar(String nom, Ogre ogre) {
        super(nom, ogre);
    }

    public void run() {
        while (ogre.estaViu()) {
            synchronized (this) {
                if (vida > 0) {
                    ogre.rebreDany(10 + rnd.nextInt(15), nom);
                }
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {}
        }
    }
}

class Sanadora implements Runnable {

    private final List<Heroi> herois;
    private int mana = 80;

    public Sanadora(List<Heroi> herois) {
        this.herois = herois;
    }

    public void run() {

        while (true) {

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {}

            if (mana < 80) {
                mana++;
            }

            for (Heroi h : herois) {

                synchronized (h) {

                    if (h.vida == 0 && mana >= 50) {

                        System.out.println("Eylin cura a " + h.nom);

                        h.vida = 50;
                        mana -= 50;

                        h.notify();
                    }
                }
            }
        }
    }
}

public class Pt10_Sanadora {
    public static void main(String[] args) {

        List<Heroi> herois = new ArrayList<>();

        Ogre ogre = new Ogre(herois);

        Heroi h1 = new Guerrer("Dalinar", ogre);
        Heroi h2 = new Mag("Kaladin", ogre);
        Heroi h3 = new Picar("Vin", ogre);

        herois.add(h1);
        herois.add(h2);
        herois.add(h3);

        
        Sanadora lift = new Sanadora(herois);

        Thread tOgre = new Thread(ogre);
        Thread t1 = new Thread(h1);
        Thread t2 = new Thread(h2);
        Thread t3 = new Thread(h3);
        Thread tLift = new Thread(lift);

        tOgre.setPriority(Thread.MAX_PRIORITY);
        t1.setPriority(Thread.NORM_PRIORITY);
        t2.setPriority(Thread.NORM_PRIORITY);
        t3.setPriority(Thread.NORM_PRIORITY);
        tLift.setPriority(Thread.NORM_PRIORITY);

        tOgre.start();
        t1.start();
        t2.start();
        t3.start();
        tLift.start();
    }
}
