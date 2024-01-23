public class Turismo implements Vehiculo {

    private int velocidad;

    public Turismo(int velocidad) {
        this.velocidad = velocidad;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    @Override
    public void acelerar(int velocidad) {
        System.out.println("Y cuanto más acelero...");
        this.velocidad += velocidad;
    }

    @Override
    public void frenar(int velocidad) {
        System.out.println("Echa el freno...");
        this.velocidad -= velocidad;
    }

}
