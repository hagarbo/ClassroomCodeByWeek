public class Television extends Electrodomestico {

    private static final int UMBRAL_RES = 40;
    private static final double COSTE_UMBRAL_RES = 1.3;
    private static final int COSTE_TDT = 50;
    private int resolucion;
    private boolean tdt;

    public Television() {
        this.resolucion = 32;
        this.tdt = false;
    }

    public Television(int basePrice, int peso) {
        super(basePrice, peso);
        this.resolucion = 32;
        this.tdt = false;
    }

    public Television(int basePrice, String color, char consumo, int peso, int resolucion, boolean tdt) {
        super(basePrice, color, consumo, peso);
        this.resolucion = resolucion;
        this.tdt = tdt;
    }

    public int getResolucion() {
        return resolucion;
    }

    public void setResolucion(int resolucion) {
        this.resolucion = resolucion;
    }

    public boolean isTdt() {
        return tdt;
    }

    public void setTdt(boolean tdt) {
        this.tdt = tdt;
    }

    @Override
    public int precioFinal() {
        int precioFinal = super.precioFinal();
        if (this.resolucion > UMBRAL_RES)
            precioFinal *= COSTE_UMBRAL_RES;
        if (this.tdt)
            precioFinal += COSTE_TDT;
        return precioFinal;
    }

    @Override
    public String toString() {
        return "Television [precio=" + super.getBasePrice() + ", color=" + super.getColor() + ", consumo="
                + super.getConsumo() + ", peso=" + super.getPeso() + ", resolucion=" + resolucion + ", tdt=" + tdt
                + "]";
    }

}
