public abstract class Avion {

    private String id;
    private int pasajeros;
    private int autonomia;
    private String modelo;

    public Avion(String id, int pasajeros, int autonomia, String modelo) {
        this.id = id;
        this.pasajeros = pasajeros;
        this.autonomia = autonomia;
        this.modelo = modelo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getPasajeros() {
        return pasajeros;
    }

    public void setPasajeros(int pasajeros) {
        this.pasajeros = pasajeros;
    }

    public int getAutonomia() {
        return autonomia;
    }

    public void setAutonomia(int autonomia) {
        this.autonomia = autonomia;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

}