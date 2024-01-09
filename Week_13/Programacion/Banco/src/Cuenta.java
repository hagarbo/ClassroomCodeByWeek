public class Cuenta {

    private String titular;
    private double cantidad;

    public Cuenta(String titular, double cantidad) {
        this.titular = titular;
        this.cantidad = cantidad;
    }

    public Cuenta(String titular) {
        this.titular = titular;
        this.cantidad = 0.0;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public void ingresar(double cantidad) {
        if (cantidad > 0)
            this.cantidad += cantidad;
    }

    public void retirar(double cantidad) {
        this.cantidad = (this.cantidad - cantidad < 0) ? 0 : this.cantidad - cantidad;
    }
}