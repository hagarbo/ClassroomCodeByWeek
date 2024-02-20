/**
 * Videojuego
 */
public class Videojuego implements Operaciones {

    private String titulo;
    private int horasEstimadas;
    private boolean entregado;
    private String genero;
    private String compañia;

    public Videojuego() {
        this.titulo = "Sin titulo";
        this.horasEstimadas = 10;
        this.entregado = false;
        this.genero = "Sin genero";
        this.compañia = "Sin compañia";
    }

    public Videojuego(String titulo, int horasEstimadas) {
        this();
        this.titulo = titulo;
        this.horasEstimadas = horasEstimadas;
    }

    public Videojuego(String titulo, int horasEstimadas, String genero, String compañia) {
        this.titulo = titulo;
        this.horasEstimadas = horasEstimadas;
        this.genero = genero;
        this.compañia = compañia;
        this.entregado = false;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getHorasEstimadas() {
        return horasEstimadas;
    }

    public void setHorasEstimadas(int horasEstimadas) {
        this.horasEstimadas = horasEstimadas;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getCompañia() {
        return compañia;
    }

    public void setCompañia(String compañia) {
        this.compañia = compañia;
    }

    @Override
    public String toString() {
        return "Videojuego [titulo=" + titulo + ", horasEstimadas=" + horasEstimadas + ", entregado=" + entregado
                + ", genero=" + genero + ", compañia=" + compañia + "]";
    }

    @Override
    public void entregar() {
        this.entregado = true;
    }

    @Override
    public void devolver() {
        this.entregado = false;
    }

    @Override
    public boolean isEntregado() {
        return this.entregado;
    }

}
