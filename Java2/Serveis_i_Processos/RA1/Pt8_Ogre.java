package RA1;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

class Ogre {
    private int vida = 3000;
    private boolean enFuria = false;

    public synchronized void rebreDany(String heroi, int dany) {
        if (vida <= 0) return;

        if (!enFuria && vida < 750) {
            enFuria = true;
            System.out.println("L'OGRE ENTRA EN FÚRIA!");
        }

        int danyFinal = enFuria ? dany / 2 : dany;

        if (danyFinal > 80) {
            try {
                System.out.println("\t(L'Ogre està estabornit... Bloquejat 2s)");
                Thread.sleep(2000);
            } catch (InterruptedException e) {}
        }

        vida -= danyFinal;
        if (vida < 0) vida = 0;

        System.out.println(heroi + " fa " + danyFinal + " dany");
    }

    public synchronized int getVida() {
        return vida;
    }

    public synchronized boolean estaViu() {
        return vida > 0;
    }
}

abstract class Heroi implements Runnable {
    protected String nom;
    protected Ogre ogre;
    protected Random rnd = new Random();
    protected AtomicBoolean viu = new AtomicBoolean(true);

    public Heroi(String nom, Ogre ogre) {
        this.nom = nom;
        this.ogre = ogre;
    }

    public boolean estaViu() {
        return viu.get();
    }
}

class Guerrer extends Heroi {
    public Guerrer(String nom, Ogre ogre) {
        super(nom, ogre);
    }

    public void run() {
        while (ogre.estaViu()) {
            int dany = 30 + rnd.nextInt(111);
            ogre.rebreDany(nom, dany);
            try {
                Thread.sleep(1000 + rnd.nextInt(500));
            } catch (InterruptedException e) {}
        }
        viu.set(false);
    }
}

class Mag extends Heroi {
    public Mag(String nom, Ogre ogre) {
        super(nom, ogre);
    }

    public void run() {
        while (ogre.estaViu()) {
            int dany = 10 + rnd.nextInt(51);
            ogre.rebreDany(nom, dany);
            try {
                Thread.sleep(600 + rnd.nextInt(400));
            } catch (InterruptedException e) {}
        }
        viu.set(false);
    }
}

class Picar extends Heroi {
    public Picar(String nom, Ogre ogre) {
        super(nom, ogre);
    }

    public void run() {
        while (ogre.estaViu()) {
            int dany = 5 + rnd.nextInt(26);
            ogre.rebreDany(nom, dany);
            try {
                Thread.sleep(200 + rnd.nextInt(300));
            } catch (InterruptedException e) {}
        }
        viu.set(false);
    }
}

public class Pt8_Ogre {
    public static void main(String[] args) throws Exception {
        Ogre ogre = new Ogre();

        Heroi h1 = new Guerrer("Corvan", ogre);
        Heroi h2 = new Mag("Greiflum", ogre);
        Heroi h3 = new Picar("Darrel", ogre);

        Thread t1 = new Thread(h1);
        Thread t2 = new Thread(h2);
        Thread t3 = new Thread(h3);

        t1.start();
        t2.start();
        t3.start();

        int temps = 0;

        while (ogre.estaViu() && (t1.isAlive() || t2.isAlive() || t3.isAlive())) {
            Thread.sleep(1000);
            temps++;

            int vida = ogre.getVida();
            int percent = vida * 100 / 3000;
            int blocs = percent / 5;

            String barra = "█".repeat(blocs) + "░".repeat(20 - blocs);

            int actius = 0;
            if (h1.estaViu()) actius++;
            if (h2.estaViu()) actius++;
            if (h3.estaViu()) actius++;

            System.out.printf(" %02ds | [%s] %d%% (%d/3000 HP)%n", temps, barra, percent, vida);
            System.out.println("Herois actius: " + actius);
        }

        if (!ogre.estaViu()) {
            System.out.println("L'OGRE HA MORT!");
            System.out.println("VICTÒRIA DELS HEROIS!");
        } else {
            System.out.println("DERROTA DELS HEROIS!");
        }
    }
}
