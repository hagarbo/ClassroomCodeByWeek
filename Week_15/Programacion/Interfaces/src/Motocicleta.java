public class Motocicleta implements Vehiculo {

    private int velocidad;

    public Motocicleta(int velocidad) {
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
        System.out.println("... más calentito me pongo.");
        this.velocidad += velocidad;
    }

    @Override
    public void frenar(int velocidad) {
        System.out.println("... Magdaleno.");
        this.velocidad -= velocidad;
    }

}
