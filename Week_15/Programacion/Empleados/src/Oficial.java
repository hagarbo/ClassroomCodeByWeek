import java.time.LocalDate;

public class Oficial extends Empleado {

    private String lineaFabricacion;

    public Oficial(String nombre, double salario, LocalDate fechaIncorporacion, String lineaFabricacion) {
        super(nombre, salario, fechaIncorporacion);
        this.lineaFabricacion = lineaFabricacion;
    }

    public String getLineaFabricacion() {
        return lineaFabricacion;
    }

    public void setLineaFabricacion(String lineaFabricacion) {
        this.lineaFabricacion = lineaFabricacion;
    }

    @Override
    public String toString() {
        return super.toString() + "[lineaFabricacion=" + lineaFabricacion + "]";
    }

}
