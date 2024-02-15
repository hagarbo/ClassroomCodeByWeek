import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Map;

public class Tienda {

    private Map<String, Producto> catalogo = Map.of(
            "colacao", new Producto("p1", "colacao", 5.99),
            "patatas", new Producto("p2", "patatas", 0.99),
            "chorizo", new Producto("p3", "chorizo", 7.98),
            "mermelada", new Producto("p4", "mermelada", 2.95));

    private ArrayList<Cliente> cartera = new ArrayList<>();

    private ArrayDeque<Pedido> pedidos = new ArrayDeque<>();

    public void añadirCliente(Cliente c) {
        this.cartera.add(c);
    }

    public void añadirPedido(Pedido p) {
        this.pedidos.addLast(p);
    }

    public void procesarPedido() {
        System.out.println("Procesando pedido...");
        System.out.println(this.pedidos.getFirst().toString());
        this.pedidos.removeFirst();
    }

    public Map<String, Producto> getProductos() {
        return this.catalogo;
    }
}
