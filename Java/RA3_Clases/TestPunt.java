package javaclases;
class Punt {
    private double x, y;

    // Constructor per defecte (punt a l'origen)
    public Punt() {
        this.x = 0;
        this.y = 0;
    }

    // Constructor amb coordenades
    public Punt(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Mètodes get
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    // Mètode per calcular la distància entre dos punts
    public double distancia(Punt altre) {
        return Math.sqrt(Math.pow(this.x - altre.x, 2) + Math.pow(this.y - altre.y, 2));
    }

    // Representació en String del punt
    @Override
    public String toString() {
        return String.format("(%.1f,%.1f)", x, y);
    }
}

public class TestPunt {
    public static void main(String[] args) {
        // Instanciar els punts
        Punt p1 = new Punt();
        Punt p2 = new Punt(5, 3);
        Punt p3 = new Punt(2, -1);
        Punt p4 = new Punt((p2.getX() + p3.getX()) / 2, (p2.getY() + p3.getY()) / 2);

        // Imprimir els punts
        System.out.println("P1 = " + p1);
        System.out.println("P2 = " + p2);
        System.out.println("P3 = " + p3);
        System.out.println("P4 = " + p4);

        // Instanciar el punt en (4,3) i calcular la distància a l'origen
        Punt p5 = new Punt(4, 3);
        System.out.println("Distància entre " + p5 + " i " + p1 + ": " + p5.distancia(p1));
    }
}
