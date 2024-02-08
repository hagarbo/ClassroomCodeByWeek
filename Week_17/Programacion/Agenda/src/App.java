public class App {
    public static void main(String[] args) throws Exception {

        Agenda agenda = new Agenda();

        agenda.añadirEntrada("Jose", "8754232323");
        agenda.añadirEntrada("Marcos Aguirre", "099898979");
        agenda.añadirEntrada("Miguel San Juan", "434356345634");
        agenda.listarContactos();
        System.out.println();
        agenda.listarContactosPorLetra('m');
        System.out.println();
        agenda.buscarContacto("jose");
        agenda.eliminarContacto("jose");
        System.out.println();
        agenda.listarContactos();
    }
}
