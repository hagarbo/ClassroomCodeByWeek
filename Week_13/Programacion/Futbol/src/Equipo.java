/**
 * Equipo
 */
public class Equipo {

    private String nombre;
    private Integer presupuesto;

    public Equipo(String nombre, Integer presupuesto) {
        this.nombre = nombre;
        this.presupuesto = presupuesto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(Integer presupuesto) {
        this.presupuesto = presupuesto;
    }

}