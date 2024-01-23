public abstract class Maquina {

    private String numeroSerie;
    private String modelo;
    private int horasFuncionamiento;

    public Maquina(String numeroSerie, String modelo, int horasFuncionamiento) {
        this.numeroSerie = numeroSerie;
        this.modelo = modelo;
        this.horasFuncionamiento = horasFuncionamiento;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getHorasFuncionamiento() {
        return horasFuncionamiento;
    }

    public void setHorasFuncionamiento(int horasFuncionamiento) {
        this.horasFuncionamiento = horasFuncionamiento;
    }

    public abstract void encender();

    public abstract void apagar();

}