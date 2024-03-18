public class Bazar extends Producto {

    private String tipo;

    public Bazar() {
        super();
        this.tipo = "";
    }

    public Bazar(double precio, String nombre, String tipo) {
        super(precio, nombre);
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "\nProducto de Bazar:" + super.toString() + "\ntipo: " + tipo;
    }

}
