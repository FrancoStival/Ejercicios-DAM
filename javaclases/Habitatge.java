package javaclases;
class Aparell {
    private int consum;
    private boolean ences;
    private static int consumTotal;

    public Aparell(int consum) {
        this.consum = consum;
        this.ences = false;
    }

    public void encendre() {
        if (!ences) {
            ences = true;
            System.out.println("L'aparell s'ha encès.");
            consumTotal += this.consum;
        } else {
            System.out.println("L'aparell ja està encès.");
        }
    }

    public void apagar() {
        if (ences) {
            ences = false;
            System.out.println("L'aparell s'ha apagat.");
            consumTotal -= this.consum;
        } else {
            System.out.println("L'aparell ja està apagat.");
        }
    }

    public static int obtenitConsumTotal() {
        return consumTotal;
    }

}

public class Habitatge {
    public static void main(String[] args) {

        Aparell bombeta = new Aparell(100);
        Aparell radiador = new Aparell(2000);
        Aparell planxa = new Aparell(1200);
        System.out.println("\n\nConsum total actual: " + Aparell.obtenitConsumTotal());
        bombeta.encendre();
        planxa.encendre();
        System.out.println("\n\nConsum Total: " + Aparell.obtenitConsumTotal());
        planxa.apagar();
        radiador.encendre();
        System.out.println("\n\nConsum Total: " + Aparell.obtenitConsumTotal());

    }
}
