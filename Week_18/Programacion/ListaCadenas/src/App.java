public class App {
    public static void main(String[] args) throws Exception {
        Cadenas lista = new Cadenas();
        lista.cargarDatos("Jose", "Antonio", "Juan", "Andrea", "Mercedes", "Jaime", "Silvia");
        lista.mostrarDatos();

        lista.eliminarElemento("Jose");
        System.out.println();
        lista.mostrarDatos();
    }
}
