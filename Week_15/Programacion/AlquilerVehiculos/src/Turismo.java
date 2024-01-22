public class Turismo extends Vehiculo {

    private int puertas;
    private boolean automatico;

    public Turismo(String matricula, String marca, String modelo, String color, String tarifa, int puertas,
            boolean automatico) {
        super(matricula, marca, modelo, color, tarifa);
        this.puertas = puertas;
        this.automatico = automatico;
    }

    public int getPuertas() {
        return puertas;
    }

    public void setPuertas(int puertas) {
        this.puertas = puertas;
    }

    public boolean isAutomatico() {
        return automatico;
    }

    public void setAutomatico(boolean automatico) {
        this.automatico = automatico;
    }

    @Override
    public String toString() {
        return super.toString() + "[puertas=" + puertas + ", automatico=" + automatico + "]";
    }

}
