import java.util.Date;

class Motocicleta extends Vehicle {
    public Motocicleta(String matricula) {
        super(matricula);
    }

    @Override
    public double calcularPreu() {
        double preu = (new Date().getTime() - getDataHoraEntrada().getTime()) / 1000.0 * 3;
        return Math.max(preu * 0.5, 3);
    }
}