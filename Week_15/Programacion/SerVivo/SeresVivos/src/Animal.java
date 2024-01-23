public class Animal extends SerVivo {

    private int peso;

    public Animal(String nombre, String nombreCientifico, int altura, int peso) {
        super(nombre, nombreCientifico, altura);
        this.peso = peso;
    }

    @Override
    void alimentar() {
        System.out.println("Dándole un cuenco de pienso a " + this.getNombre());
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

}
