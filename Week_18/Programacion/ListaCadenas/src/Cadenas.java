import java.util.ArrayList;

public class Cadenas {

    private ArrayList<String> cadenas;

    public Cadenas() {
        this.cadenas = new ArrayList<>();
    }

    public void cargarDatos(String... nombres) {
        if (this.cadenas.size() != 0)
            return;
        for (String nombre : nombres) {
            this.cadenas.add(nombre);
        }
    }

    public void mostrarDatos() {
        if (this.cadenas.size() == 0)
            System.out.println("Lista Vacia, inserte datos primero");
        else {
            for (String nombre : this.cadenas) {
                System.out.println("Nombre " + this.cadenas.indexOf(nombre) + ":" + nombre);
            }
        }
    }

    public int getPosicion(String nombre) {
        return this.cadenas.indexOf(nombre);
    }

    public void eliminarElemento(String nombre) {
        int index = this.cadenas.indexOf(nombre);
        this.eliminarElementoPorIndice(index);
    }

    public void eliminarElementoPorIndice(int index) {
        if (index >= 0)
            this.cadenas.remove(index);
    }
}
