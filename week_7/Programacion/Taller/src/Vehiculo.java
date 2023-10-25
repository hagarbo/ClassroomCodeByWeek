public abstract class Vehiculo {

    private final double PRECIO_HORA = 23.5;
    private final String GASOLINA_STRING = "gasolina";
    private final String DIESEL_STRING = "diesel";
    private final String ELECTRICO_STRING = "electrico";
    private final int GASOLINA_RATIO = 2;
    private final int DIESEL_RATIO = 3;
    private final int ELECTRICO_RATIO = 1;

    private String marca;
    private int ruedas;
    private String motor;
    private int estadoMotor;

    public Vehiculo() {

    }

    public Vehiculo(String marca, int ruedas, String motor, int estadoMotor) throws Exception {
        this.marca = marca;
        this.ruedas = ruedas;
        if (validarMotor(motor))
            this.motor = motor;
        else
            throw new Exception(
                    "Motor Invalido: debe ser:" + GASOLINA_STRING + " o " + DIESEL_STRING + " o " + ELECTRICO_STRING,
                    null);
        this.estadoMotor = estadoMotor;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getRuedas() {
        return ruedas;
    }

    public void setRuedas(int ruedas) {
        this.ruedas = ruedas;
    }

    public String getMotor() {
        return motor;
    }

    public void setMotor(String motor) throws Exception {
        if (validarMotor(motor))
            this.motor = motor;
        else
            throw new Exception(
                    "Motor Invalido: debe ser:" + GASOLINA_STRING + " o " + DIESEL_STRING + " o " + ELECTRICO_STRING,
                    null);
    }

    public int getEstadoMotor() {
        return estadoMotor;
    }

    public void setEstadoMotor(int estadoMotor) {
        this.estadoMotor = estadoMotor;
    }

    private boolean validarMotor(String motor) {
        return (motor.equals(GASOLINA_STRING) || motor.equals(DIESEL_STRING) || motor.equals(ELECTRICO_STRING));
    }

    /*
     * Float Reparar (devuelve el número de horas de mano de obra):
     * Si es gasolina el número de horas se multiplica por 2,
     * si es diesel por 3
     * y si es eléctrico no se modifica o se multiplica por 1.
     */
    protected int constanteMotor() throws Exception {
        if (this.getMotor().equals(GASOLINA_STRING))
            return GASOLINA_RATIO;
        if (this.getMotor().equals(DIESEL_STRING))
            return DIESEL_RATIO;
        if (this.getMotor().equals(ELECTRICO_STRING))
            return ELECTRICO_RATIO;
        throw new Exception("Ha habido un problema, el motor no es válido o no está definido.", null);
    }

    public abstract double reparar() throws Exception;

    public double cobrar(double numHorasTaller) {
        return numHorasTaller * PRECIO_HORA;
    }

}