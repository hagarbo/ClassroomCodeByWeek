import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {

        Tienda superTienda = new Tienda();

        Cliente jose = new Cliente("Pepe", "Romero", "888888888");
        Cliente antonia = new Cliente("Antornia", "Barros", "555555555");

        Map<String, Producto> catalogo = superTienda.getProductos();

        superTienda.añadirCliente(jose);
        superTienda.añadirCliente(antonia);

        Pedido pedidoJose = new Pedido("1", jose);
        pedidoJose.añadirAlPedido(catalogo.get("colacao"), 4);
        pedidoJose.añadirAlPedido(catalogo.get("mermelada"), 1);

        superTienda.añadirPedido(pedidoJose);

        Pedido pedidoAntonia = new Pedido("2", antonia);
        pedidoAntonia.añadirAlPedido(catalogo.get("chorizo"), 3);
        pedidoAntonia.añadirAlPedido(catalogo.get("patatas"), 2);
        pedidoAntonia.añadirAlPedido(catalogo.get("mermelada"), 2);

        superTienda.añadirPedido(pedidoAntonia);

        superTienda.procesarPedido();

    }
}
