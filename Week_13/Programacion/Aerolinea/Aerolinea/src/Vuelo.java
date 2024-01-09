public class Vuelo {

    private Aeropuerto origen;
    private Aeropuerto destino;
    private Avion avion;

    public Vuelo(Aeropuerto origen, Aeropuerto destino, Avion avion) {
        this.origen = origen;
        this.destino = destino;
        this.avion = avion;
    }

    public Aeropuerto getOrigen() {
        return origen;
    }

    public void setOrigen(Aeropuerto origen) {
        this.origen = origen;
    }

    public Aeropuerto getDestino() {
        return destino;
    }

    public void setDestino(Aeropuerto destino) {
        this.destino = destino;
    }

    public Avion getAvion() {
        return avion;
    }

    public void setAvion(Avion avion) {
        this.avion = avion;
    }

}
