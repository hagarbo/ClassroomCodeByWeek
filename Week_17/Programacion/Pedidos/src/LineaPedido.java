
public class LineaPedido {

    private Producto producto;
    private int unidades;

    @Override
    public String toString() {
        return "LineaPedido [producto=" + producto + ", unidades=" + unidades + "]";
    }

    public LineaPedido(Producto producto, int unidades) {
        this.producto = producto;
        this.unidades = unidades;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

}
