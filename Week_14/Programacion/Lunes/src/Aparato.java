public class Aparato {

    public static int consumo = 0;
    private int potencia = 0;
    private boolean encendido = false;

    public Aparato(int potencia) {
        this.potencia = potencia;
        this.encendido = false;
    }

    public int getConsumo() {
        return consumo;
    }

    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    public void encender() {
        if (!this.encendido)
            consumo += this.potencia;
        this.encendido = true;
    }

    public void apagar() {
        if (this.encendido)
            consumo -= this.potencia;
        this.encendido = false;
    }

    @Override
    public String toString() {
        return "Aparato [potencia=" + potencia + ", encendido=" + encendido + "]";
    }

}
