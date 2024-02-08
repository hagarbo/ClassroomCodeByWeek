import java.util.HashMap;

public class Agenda {

    private int lastIndex = 0;
    private HashMap<Integer, EntradaAgenda> agenda = new HashMap<>();

    public boolean añadirEntrada(String nombre, String telefono) {
        try {
            this.agenda.put(lastIndex, new EntradaAgenda(nombre, telefono));
            this.lastIndex++;
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public void buscarContacto(String nombre) {
        this.agenda.entrySet()
                .stream()
                .filter(e -> nombre.equalsIgnoreCase(e.getValue().getNombre()))
                .forEach(e -> System.out.println(e.toString()));
    }

    public boolean eliminarContacto(String nombre) {
        try {
            this.agenda.entrySet().forEach(
                    e -> {
                        if (e.getValue().getNombre().equalsIgnoreCase(nombre))
                            this.agenda.remove(e.getKey());
                    });
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public void listarContactos() {
        this.agenda.entrySet()
                .stream()
                .forEach(e -> System.out.println(e.toString()));
    }

    public void listarContactosPorLetra(char letra) {
        this.agenda.entrySet()
                .stream()
                .filter(e -> Character.toLowerCase(letra) == e.getValue().getNombre().toLowerCase().charAt(0))
                .forEach(e -> System.out.println(e.toString()));
    }

}
