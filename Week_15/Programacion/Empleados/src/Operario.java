import java.time.LocalDate;

public class Operario extends Empleado {

    private String area;
    private String nave;

    public Operario(String nombre, double salario, LocalDate fechaIncorporacion, String area, String nave) {
        super(nombre, salario, fechaIncorporacion);
        this.area = area;
        this.nave = nave;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getNave() {
        return nave;
    }

    public void setNave(String nave) {
        this.nave = nave;
    }

    @Override
    public String toString() {
        return super.toString() + "[area=" + area + ", nave=" + nave + "]";
    }

}
