/**
 * Serie
 */
public class Serie implements Operaciones {

    private String titulo;
    private int numTemporadas;
    private boolean entregado;
    private String genero;
    private String creador;

    public Serie() {
        this.titulo = "Sin titulo";
        this.numTemporadas = 0;
        this.entregado = false;
        this.genero = "Sin genero";
        this.creador = "Sin creador";
    }

    public Serie(String titulo, String creador) {
        this();
        this.titulo = titulo;
        this.creador = creador;
    }

    public Serie(String titulo, int numTemporadas, String genero, String creador) {
        this.titulo = titulo;
        this.numTemporadas = numTemporadas;
        this.genero = genero;
        this.creador = creador;
        this.entregado = false;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getNumTemporadas() {
        return numTemporadas;
    }

    public void setNumTemporadas(int numTemporadas) {
        this.numTemporadas = numTemporadas;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getCreador() {
        return creador;
    }

    public void setCreador(String creador) {
        this.creador = creador;
    }

    @Override
    public String toString() {
        return "Serie [titulo=" + titulo + ", numTemporadas=" + numTemporadas + ", entregado=" + entregado + ", genero="
                + genero + ", creador=" + creador + "]";
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