public class Motocicleta extends Vehiculo {

    private final double RATIO_REPARACION = 2.5;
    private String matricula;

    public Motocicleta() {
        super();
    }

    public Motocicleta(String matricula) {
        super();
        this.matricula = matricula;
    }

    public Motocicleta(String marca, int ruedas, String motor, int estadoMotor, String matricula) throws Exception {
        super(marca, ruedas, motor, estadoMotor);
        this.matricula = matricula;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    /*
     * Moto: ((10 - estado del motor)/2.5) * motor
     */

    public double reparar() throws Exception {
        return ((10 - this.getEstadoMotor()) / RATIO_REPARACION) * this.constanteMotor();
    }

}
