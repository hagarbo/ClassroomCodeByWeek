public class Empleado {
    private String nombre;
    private String dni;
    private double salario;
    private String categoria;

    public Empleado(String nombre, String dni, String categoria) {
        this.nombre = nombre;
        this.dni = dni;
        this.categoria = categoria;
        this.salario = this.setSalarioInicial(categoria);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    private double setSalarioInicial(String categoria){
        switch (categoria) {
            case "responsable":return 50000.77;
            case "coordinador":return 85000.99;
            case "empleado":return 23000.53;
            default: return 0;
        }
    }
}
