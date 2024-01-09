public class AvionTurbina extends Avion {

    private int turbinas;
    private String modeloMotor;

    public AvionTurbina(String id, int pasajeros, int autonomia, String modelo, int turbinas, String modeloMotor) {
        super(id, pasajeros, autonomia, modelo);
        this.turbinas = turbinas;
        this.modeloMotor = modeloMotor;
    }

    public int getTurbinas() {
        return turbinas;
    }

    public void setTurbinas(int turbinas) {
        this.turbinas = turbinas;
    }

    public String getModeloMotor() {
        return modeloMotor;
    }

    public void setModeloMotor(String modeloMotor) {
        this.modeloMotor = modeloMotor;
    }

}
