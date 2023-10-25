public class Coche extends Vehiculo {

    private static final int RATIO_REPARACION = 2;
    private int puertas;
    private String matricula;

    public Coche() {
        super();
    }

    public Coche(String marca, int ruedas, String motor, int estadoMotor, int puertas, String matricula)
            throws Exception {
        super(marca, ruedas, motor, estadoMotor);
        this.puertas = puertas;
        this.matricula = matricula;
    }

    public int getPuertas() {
        return puertas;
    }

    public void setPuertas(int puertas) {
        this.puertas = puertas;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    /*
     * Coche: ((10 - estado del motor)/2) * motor
     */
    public double reparar() throws Exception {
        return ((10 - this.getEstadoMotor()) / RATIO_REPARACION) * this.constanteMotor();
    }

}
