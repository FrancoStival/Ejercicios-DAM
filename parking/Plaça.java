class Plaça {
    private int numero;
    private String ubicacio;
    private Vehicle vehicle;

    public Plaça(int numero, String ubicacio) {
        this.numero = numero;
        this.ubicacio = ubicacio;
        this.vehicle = null;
    }

    public int getNumero() {
        return numero;
    }

    public String getUbicacio() {
        return ubicacio;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public boolean estaOcupada() {
        return vehicle != null;
    }

    @Override
    public String toString() {
        return "Plaça " + (numero + 1) + " (" + ubicacio + "): " + (estaOcupada() ? vehicle.getMatricula() : "Lliure");
    }
}