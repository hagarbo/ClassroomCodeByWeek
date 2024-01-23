public abstract class SerVivo {

    private String nombre;
    private String nombreCientifico;
    private int altura;

    public SerVivo(String nombre, String nombreCientifico, int altura) {
        this.nombre = nombre;
        this.nombreCientifico = nombreCientifico;
        this.altura = altura;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreCientifico() {
        return nombreCientifico;
    }

    public void setNombreCientifico(String nombreCientifico) {
        this.nombreCientifico = nombreCientifico;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    abstract void alimentar();

}