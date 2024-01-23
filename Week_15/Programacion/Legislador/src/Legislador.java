public abstract class Legislador extends Persona {

    private String provinciaRepresentada;
    private String camara;
    private boolean nacional;
    private int anhosResidencia;

    public Legislador(String nombre, String apellido, int edad, String dni, String sexo, int peso, int altura,
            String provinciaRepresentada, String camara, boolean nacional, int anhosResidencia) {
        super(nombre, apellido, edad, dni, sexo, peso, altura);
        this.provinciaRepresentada = provinciaRepresentada;
        this.camara = camara;
        this.nacional = nacional;
        this.anhosResidencia = anhosResidencia;
    }

    public String getProvinciaRepresentada() {
        return provinciaRepresentada;
    }

    public void setProvinciaRepresentada(String provinciaRepresentada) {
        this.provinciaRepresentada = provinciaRepresentada;
    }

    public String getCamara() {
        return camara;
    }

    public void setCamara(String camara) {
        this.camara = camara;
    }

    public boolean isNacional() {
        return nacional;
    }

    public void setNacional(boolean nacional) {
        this.nacional = nacional;
    }

    public int getAnhosResidencia() {
        return anhosResidencia;
    }

    public void setAnhosResidencia(int anhosResidencia) {
        this.anhosResidencia = anhosResidencia;
    }

    public abstract String getCamaraEnQueTrabaja();

}
