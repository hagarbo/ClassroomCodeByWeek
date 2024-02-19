import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Almacen {

    private ArrayList<Producto> catalogo;

    public Almacen() {
        this.catalogo = new ArrayList<>();
    }

    public double calcularPreciosBebidas() {
        return catalogo.stream()
                .filter(p -> p instanceof Bebida)
                .mapToDouble(p -> p.calcularPrecio())
                .sum();
    }

    public double calcularPreciosMarca(String marca) {
        return catalogo.stream()
                .filter(e -> e.getMarca().equalsIgnoreCase(marca))
                .mapToDouble(e -> e.calcularPrecio())
                .sum();
    }

    public void añadirProducto(Producto producto) {
        try {
            Producto p = this.catalogo.stream()
                    .filter(e -> (e.getId() == producto.getId()))
                    .findFirst().get();
            System.out.println("Producto repetido, no me hagas trampa");
        } catch (NoSuchElementException e) {
            this.catalogo.add(producto);
        }
    }

    public void eliminarProducto(int id) {

        try {
            Producto p = this.catalogo.stream()
                    .filter(e -> (e.getId() == id))
                    .findFirst().get();
            this.catalogo.remove(p);
        } catch (NoSuchElementException e) {
            System.out.println("Producto no encontrado!!");
        }
    }

    public void mostrarInfoRefrescos() {
        this.catalogo.stream()
                .filter(p -> p instanceof Refresco)
                .forEach(p -> System.out.println(p.toString()));
    }
}
