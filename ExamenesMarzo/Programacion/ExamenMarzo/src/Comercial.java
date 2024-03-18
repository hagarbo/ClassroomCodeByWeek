import java.util.HashMap;

public class Comercial {

    private String nombre;
    private String apellidos;
    private int edad;
    private String zonaAsignada;
    private HashMap<Integer, Producto> ventas;
    private int nextKey = 0;

    public Comercial() {
        this.nombre = "";
        this.apellidos = "";
        this.edad = 0;
        this.zonaAsignada = "Zona 1";
        this.ventas = new HashMap<>();
        this.nextKey = 0;
    }

    public Comercial(String nombre, String apellidos, int edad, String zonaAsignada,
            HashMap<Integer, Producto> ventas) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.zonaAsignada = zonaAsignada;
        validarZona();
        this.ventas = ventas;
        this.nextKey = ventas.size() + 1;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getZonaAsignada() {
        return zonaAsignada;
    }

    public void setZonaAsignada(String zonaAsignada) {
        this.zonaAsignada = zonaAsignada;
    }

    public HashMap<Integer, Producto> getVentas() {
        return ventas;
    }

    public void engadirVenta(Producto producto) {
        this.ventas.put(this.nextKey, producto);
        this.nextKey++;
    }

    private void validarZona() {
        if (!this.zonaAsignada.equalsIgnoreCase("Zona 1") && !this.zonaAsignada.equalsIgnoreCase("Zona 2")
                && !this.zonaAsignada.equalsIgnoreCase("Zona 3"))
            this.zonaAsignada = "Zona 1";
    }

    @Override
    public String toString() {
        return "Comercial: " + nombre + " " + apellidos + " Edad: " + edad + " Zona: "
                + zonaAsignada;
    }

}
