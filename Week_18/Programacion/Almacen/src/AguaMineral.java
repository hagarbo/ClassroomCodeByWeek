public class AguaMineral extends Bebida {

    private static final double INCREMENTO = 0.1;// 10%
    private static final double RECARGO_AGUARON = 0.3;
    private static final String AGUARON = "AGUARÓN";

    private String origen;

    public AguaMineral(int id, String nombre, double precio, String marca, String localizacion, String tipoEnvase,
            String origen) {
        super(id, nombre, precio, marca, localizacion, tipoEnvase);
        this.origen = origen;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    @Override
    double calcularPrecio() {
        double precioBase = this.getPrecio();
        if (this.getTipoEnvase().equalsIgnoreCase(Bebida.CRISTAL))
            precioBase *= (1 + INCREMENTO);
        if (this.getMarca().equalsIgnoreCase(AGUARON))
            precioBase += RECARGO_AGUARON;
        return precioBase;
    }

}
