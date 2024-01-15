public class Restaurante {

    public static int maxClientes(double papas, double chocos) {
        return (int) Math.min(Math.floor(papas), Math.floor(chocos * 2.0)) * 3;
    }
}
