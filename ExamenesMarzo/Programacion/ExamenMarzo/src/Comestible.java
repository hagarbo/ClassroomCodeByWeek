import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Comestible extends Producto {

    private LocalDate fechaCaducidad;

    public Comestible() {
        super();
        this.fechaCaducidad = null;
    }

    public Comestible(double precio, String nombre, LocalDate fechaCaducidad) {
        super(precio, nombre);
        this.fechaCaducidad = fechaCaducidad;
    }

    public LocalDate getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(LocalDate fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    @Override
    public String toString() {
        return "\nProducto comestible: " + super.toString() + "\nfechaCaducidad: "
                + fechaCaducidad.format(DateTimeFormatter.ofPattern("d/MM/yyyy"));
    }

}
