class Parking {
    private Plaça[] places;
    private int numPlacesOcupades;

    public Parking(int maxPlaces) {
        places = new Plaça[maxPlaces];
        for (int i = 0; i < maxPlaces; i++) {
            String planta = (i < maxPlaces / 2) ? "Planta 1" : "Planta 2";
            places[i] = new Plaça(i, planta);
        }
        numPlacesOcupades = 0;
    }

    public boolean aparcar(Vehicle vehicle) {
        for (Plaça plaça : places) {
            if (!plaça.estaOcupada()) {
                plaça.setVehicle(vehicle);
                numPlacesOcupades++;
                return true;
            }
        }
        return false;
    }

    public double desaparcar(String matricula) {
        for (Plaça plaça : places) {
            if (plaça.estaOcupada() && plaça.getVehicle().getMatricula().equals(matricula)) {
                double preu = plaça.getVehicle().calcularPreu();
                plaça.setVehicle(null);
                numPlacesOcupades--;
                return preu;
            }
        }
        return -1;
    }

    public double desaparcar(int codi) {
        if (codi >= 0 && codi < places.length && places[codi].estaOcupada()) {
            double preu = places[codi].getVehicle().calcularPreu();
            places[codi].setVehicle(null);
            numPlacesOcupades--;
            return preu;
        }
        return -1;
    }

    public void llistat() {
        for (Plaça plaça : places) {
            System.out.println(plaça);
        }
    }

    public boolean isPle() {
        return numPlacesOcupades == places.length;
    }

    public int numPlacesLliures() {
        return places.length - numPlacesOcupades;
    }
}