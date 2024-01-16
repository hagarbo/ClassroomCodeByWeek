public class Lavavajillas extends Electrodomestico {

    private static final int UMBRAL = 12;
    private static final int COSTE_UMBRAL = 60;
    private int numServicios;

    public Lavavajillas() {
        this.numServicios = 0;
    }

    public Lavavajillas(int basePrice, int peso) {
        super(basePrice, peso);
        this.numServicios = 0;
    }

    public Lavavajillas(int basePrice, String color, char consumo, int peso, int numServicios) {
        super(basePrice, color, consumo, peso);
        this.numServicios = numServicios;
    }

    public int getNumServicios() {
        return numServicios;
    }

    public void setNumServicios(int numServicios) {
        this.numServicios = numServicios;
    }

    @Override
    public int precioFinal() {
        int recargo = this.numServicios > UMBRAL ? COSTE_UMBRAL : 0;
        return super.precioFinal() + recargo;
    }

    @Override
    public String toString() {
        return "Lavavajillas [precio=" + super.getBasePrice() + ", color=" + super.getColor() + ", consumo="
                + super.getConsumo() + ", peso=" + super.getPeso() + ", servicios=" + numServicios + "]";
    }
}
