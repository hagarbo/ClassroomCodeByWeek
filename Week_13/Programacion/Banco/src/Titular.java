import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Titular {
    private final DateTimeFormatter FORMATO_FECHA = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    private final char HOMBRE = 'H';
    private final char MUJER = 'M';
    private String nombre;
    private LocalDate fechaNacimiento;
    private String dni;
    private char sexo;
    private String direccion;

    public Titular() {
        this("", LocalDate.now(), "", 'H', "");
    }

    public Titular(String nombre, LocalDate fechaNacimiento, char sexo) {
        this(nombre, fechaNacimiento, "", sexo, "");
    }

    public Titular(String nombre, LocalDate fechaNacimiento, String dni, char sexo, String direccion) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.dni = dni;
        this.comprobarSexo(sexo);
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento.format(FORMATO_FECHA);
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.comprobarSexo(sexo);
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public boolean esMayorDeEdad() {
        long age = LocalDate.from(this.fechaNacimiento).until(LocalDate.now(), ChronoUnit.YEARS);
        if (age >= 18)
            return true;
        else
            return false;
    }

    private void comprobarSexo(char sexo) {
        char sexCaps = Character.toUpperCase(sexo);
        this.sexo = (sexCaps == HOMBRE || sexCaps == MUJER) ? sexCaps : HOMBRE;
    }

    @Override
    public String toString() {
        return "Titular [nombre=" + nombre + ", fechaNacimiento=" + fechaNacimiento.format(FORMATO_FECHA) + ", dni="
                + dni + ", sexo=" + sexo
                + ", direccion=" + direccion + "]";
    }

}
