public class Bicicleta extends Vehiculo {

    private static final int RATIO_REPARACION = 3;

    public Bicicleta() {
        super();
    }

    public Bicicleta(String marca, int ruedas, String motor, int estadoMotor) throws Exception {
        super(marca, ruedas, motor, estadoMotor);
    }

    /*
     * Bicicleta: ((10 - estado del motor)/3) * motor
     */
    public double reparar() throws Exception {
        return ((10 - this.getEstadoMotor()) / RATIO_REPARACION) * this.constanteMotor();
    }

}
