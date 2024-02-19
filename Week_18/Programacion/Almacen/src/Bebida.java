abstract class Bebida extends Producto {

    public static final String LATA = "LATA";
    public static final String CRISTAL = "CRISTAL";

    private String tipoEnvase;

    public Bebida(int id, String nombre, double precio, String marca, String localizacion, String tipoEnvase) {
        super(id, nombre, precio, marca, localizacion);
        this.tipoEnvase = tipoEnvase;
    }

    public String getTipoEnvase() {
        return tipoEnvase;
    }

    public void setTipoEnvase(String tipoEnvase) {
        this.tipoEnvase = tipoEnvase;
    }

    @Override
    public String toString() {
        return super.toString() + "[tipoEnvase=" + tipoEnvase + "]";
    }

}
