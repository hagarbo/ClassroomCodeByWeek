public class Furgoneta extends Vehiculo {

    private int carga;
    private int volumen;

    public Furgoneta(String matricula, String marca, String modelo, String color, String tarifa, int carga,
            int volumen) {
        super(matricula, marca, modelo, color, tarifa);
        this.carga = carga;
        this.volumen = volumen;
    }

    public int getCarga() {
        return carga;
    }

    public void setCarga(int carga) {
        this.carga = carga;
    }

    public int getVolumen() {
        return volumen;
    }

    public void setVolumen(int volumen) {
        this.volumen = volumen;
    }

    @Override
    public String toString() {
        return super.toString() + "[carga=" + carga + ", volumen=" + volumen + "]";
    }

}
