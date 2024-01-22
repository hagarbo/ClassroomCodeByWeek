public class Deportivo extends Vehiculo {

    private int cilindrada;

    public Deportivo(String matricula, String marca, String modelo, String color, String tarifa, int cilindrada) {
        super(matricula, marca, modelo, color, tarifa);
        this.cilindrada = cilindrada;
    }

    public int getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }

    @Override
    public String toString() {
        return super.toString() + "[cilindrada=" + cilindrada + "]";
    }

}
