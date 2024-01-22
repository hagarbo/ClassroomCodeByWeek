import java.time.LocalDate;

public class Tecnico extends Empleado {

    private String seccion;

    public Tecnico(String nombre, double salario, LocalDate fechaIncorporacion, String seccion) {
        super(nombre, salario, fechaIncorporacion);
        this.seccion = seccion;
    }

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

    @Override
    public String toString() {
        return super.toString() + "[seccion=" + seccion + "]";
    }

}
