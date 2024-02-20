public class App {
    public static void main(String[] args) throws Exception {

        Almacen almacen = new Almacen();

        // PRODUCTO 1
        Producto producto = new AguaMineral(1, "Aguarón 5L", 5, "Aguarón", "Ourense", "Cristal", "Gredos");
        almacen.añadirProducto(producto);
        // PRODUCTO 2
        producto = new Refresco(2, "Coca-cola", 10, "Coca-Cola", null, "lata", 0.2, true);
        almacen.añadirProducto(producto);
        almacen.añadirProducto(producto);// testea a meter un producto que ya existe
        // PRODUCTO 3
        producto = new Alimentacion(3, "Galletas Chiquilin", 10, "Cuetara", null, "Desayuno", false);
        almacen.añadirProducto(producto);
        // PRODUCTO 4
        producto = new Refresco(4, "Red-Bull", 15, "Red-Bull", null, "lata", 0.5, true);
        almacen.añadirProducto(producto);
        // PRODUCTO 5
        producto = new Refresco(5, "Fanta", 3, "Coca-Cola", null, "botella", 0.05, false);
        almacen.añadirProducto(producto);
        // PRODUCTO 6
        producto = new AguaMineral(6, "Cabreiroa botella", 5, "Cabreiroa", "Ourense", "Plastico", "Courel");
        almacen.añadirProducto(producto);

        System.out.println("Precio Bebidas = " + almacen.calcularPreciosBebidas());
        System.out.println("Precio Aguaron = " + almacen.calcularPreciosMarca("Aguarón"));
        almacen.mostrarInfoRefrescos();

        almacen.eliminarProducto(2);
        almacen.eliminarProducto(2);// testea eliminar un producto que no existe

        almacen.mostrarInfoRefrescos();
    }
}
