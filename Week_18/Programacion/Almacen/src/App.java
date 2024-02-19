public class App {
    public static void main(String[] args) throws Exception {

        Almacen almacen = new Almacen();
        Producto producto = new AguaMineral(1, "Aguarón 5L", 5, "Aguarón", "Ourense", "Cristal", "Gredos");

        almacen.añadirProducto(producto);

        producto = new Refresco(2, "Coca-cola", 10, "Coca-Cola", null, "lata", 0.2, true);
        almacen.añadirProducto(producto);
        almacen.añadirProducto(producto);

        System.out.println("Precio Bebidas = " + almacen.calcularPreciosBebidas());
        System.out.println("Precio Aguaron = " + almacen.calcularPreciosMarca("Aguarón"));
        almacen.mostrarInfoRefrescos();

        almacen.eliminarProducto(2);
        almacen.eliminarProducto(2);

        almacen.mostrarInfoRefrescos();
    }
}
