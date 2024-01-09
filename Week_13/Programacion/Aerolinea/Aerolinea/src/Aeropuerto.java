public class Aeropuerto {

    private String id;
    private String nombre;
    private Localizacion ubicacion;

    public Aeropuerto(String id, String nombre, Localizacion ubicacion) {
        this.id = id;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Localizacion getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(Localizacion ubicacion) {
        this.ubicacion = ubicacion;
    }

}
