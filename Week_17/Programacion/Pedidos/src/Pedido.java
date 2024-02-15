import java.util.ArrayList;

public class Pedido {
    private String id;
    private Cliente cliente;
    private ArrayList<LineaPedido> pedidos = new ArrayList<>();

    public Pedido(String id, Cliente cliente) {
        this.id = id;
        this.cliente = cliente;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ArrayList<LineaPedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(ArrayList<LineaPedido> pedidos) {
        this.pedidos = pedidos;
    }

    public void añadirAlPedido(Producto p, int cantidad) {
        this.pedidos.add(new LineaPedido(p, cantidad));
    }

    @Override
    public String toString() {
        return "Pedido [id=" + id + ", cliente=" + cliente + ", pedidos=" + pedidos.toString() + "]";
    }
}
