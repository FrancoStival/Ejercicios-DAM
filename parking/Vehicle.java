import java.util.Date;

abstract class Vehicle {
    private String matricula;
    private Date dataHoraEntrada;

    public Vehicle(String matricula) {
        this.matricula = matricula;
        this.dataHoraEntrada = new Date();
    }

    public String getMatricula() {
        return matricula;
    }

    public Date getDataHoraEntrada() {
        return dataHoraEntrada;
    }

    public abstract double calcularPreu();
}