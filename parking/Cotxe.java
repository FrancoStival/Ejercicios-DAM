import java.util.Date;

class Cotxe extends Vehicle {
    public Cotxe(String matricula) {
        super(matricula);
    }

    @Override
    public double calcularPreu() {
        double preu = (new Date().getTime() - getDataHoraEntrada().getTime()) / 1000.0 * 3;
        return Math.max(preu * 0.9, 3);
    }
}