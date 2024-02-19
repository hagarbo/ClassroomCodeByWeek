public class Alimentacion extends Producto {

    private String categoria;
    private boolean glutenFree;

    public Alimentacion(int id, String nombre, double precio, String marca, String localizacion, String categoria,
            boolean glutenFree) {
        super(id, nombre, precio, marca, localizacion);
        this.categoria = categoria;
        this.glutenFree = glutenFree;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public boolean isGlutenFree() {
        return glutenFree;
    }

    public void setGlutenFree(boolean glutenFree) {
        this.glutenFree = glutenFree;
    }

    @Override
    double calcularPrecio() {
        return this.getPrecio();
    }

}
