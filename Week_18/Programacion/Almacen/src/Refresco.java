public class Refresco extends Bebida {

    private static final double DESCUENTO_OFERTA = 0.15;
    private static final double DESCUENTO_LATA = 0.05;
    private static final double UMBRAL_AZUCAR = 0.10;
    private static final double RECARGO_AZUCAR = 0.10;

    private double porcentajeAzucar;
    private boolean tieneDescuento;

    public Refresco(int id, String nombre, double precio, String marca, String localizacion, String tipoEnvase,
            double porcentajeAzucar, boolean tieneDescuento) {
        super(id, nombre, precio, marca, localizacion, tipoEnvase);
        this.porcentajeAzucar = porcentajeAzucar;
        this.tieneDescuento = tieneDescuento;
    }

    public double getPorcentajeAzucar() {
        return porcentajeAzucar;
    }

    public void setPorcentajeAzucar(double porcentajeAzucar) {
        this.porcentajeAzucar = porcentajeAzucar;
    }

    public boolean isTieneDescuento() {
        return tieneDescuento;
    }

    public void setTieneDescuento(boolean tieneDescuento) {
        this.tieneDescuento = tieneDescuento;
    }

    @Override
    double calcularPrecio() {
        double precioBase = this.getPrecio();
        if (this.getTipoEnvase().equalsIgnoreCase(Bebida.LATA))
            precioBase -= precioBase * DESCUENTO_LATA;
        if (this.porcentajeAzucar > UMBRAL_AZUCAR)
            precioBase += precioBase * RECARGO_AZUCAR;
        if (this.tieneDescuento)
            precioBase -= precioBase * DESCUENTO_OFERTA;
        return precioBase;
    }

    @Override
    public String toString() {
        return super.toString() + "[porcentajeAzucar=" + porcentajeAzucar + ", tieneDescuento=" + tieneDescuento + "]";
    }

}
