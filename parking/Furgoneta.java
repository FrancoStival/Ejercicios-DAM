import java.util.Date;

class Furgoneta extends Vehicle {
    public Furgoneta(String matricula) {
        super(matricula);
    }

    @Override
    public double calcularPreu() {
        double preu = (new Date().getTime() - getDataHoraEntrada().getTime()) / 1000.0 * 3;
        return Math.max(preu * 2, 3);
    }
}
