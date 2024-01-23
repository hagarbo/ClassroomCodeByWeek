public class App {
    public static void main(String[] args) throws Exception {
        Legislador[] lista = new Legislador[2];

        lista[0] = new Diputado(null, null, 0, null, null, 0, 0, null, "Congreso", false, 0);
        lista[1] = new Senador(null, null, 0, null, null, 0, 0, null, "Senado", false, 0);

        for (Legislador legislador : lista) {
            System.out.println(legislador.getCamaraEnQueTrabaja());
        }
    }
}
