public class Vegetal extends SerVivo {

    public Vegetal(String nombre, String nombreCientifico, int altura) {
        super(nombre, nombreCientifico, altura);
    }

    @Override
    public void alimentar() {
        System.out.println("Echándole agüita fresca a " + this.getNombre());
    }

}
