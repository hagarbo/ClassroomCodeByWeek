import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

public class AlmacenPrincipal {

    private static final int MAX_OPCIONES_MENU = 7;
    private static ArrayList<Producto> listaProductos = new ArrayList<>();
    private static ArrayList<Comercial> listaComerciales = new ArrayList<>();

    public static void main(String[] args) {
        int opcion;
        generarDatos();
        // mostrarProductos();
        do {
            menu();
            opcion = leerOpcion(MAX_OPCIONES_MENU);
            switch (opcion) {
                case 1:
                    Producto producto = altaProducto();
                    listaProductos.add(producto);
                    System.out.println("\nProducto creado correctamente!" + producto.toString());
                    break;
                case 2:
                    Comercial comercial = altaComercial();
                    listaComerciales.add(comercial);
                    System.out.println("\nComercial creado correctamente!" + comercial.toString());
                    break;
                case 3:
                    eliminarProductosLimpieza();
                    break;
                case 4:
                    especialidadComerciales();
                    break;
                case 5:
                    costeProductos();
                    break;
                case 6:
                    productosCaducidadProxima();
                    break;
                default:
                    break;
            }

        } while (opcion != 7);
    }

    private static int leerOpcion(int maxOpciones) {
        Scanner sc = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("Introduzca una opcion válida:");
            opcion = sc.nextInt();
        } while (opcion < 1 && opcion > maxOpciones);
        sc.nextLine();
        return opcion;
    }

    private static void generarDatos() {
        Comercial c1 = new Comercial("Andres", "Perez Perez", 25, "Zona 3", crearRegistroComercial());
        Comercial c2 = new Comercial("Sheila", "Gonzalez Gomez", 37, "Zona 1", crearRegistroComercial());
        Comercial c3 = new Comercial("Iria", "Martinez Santos", 55, "Zona 2", crearRegistroComercial());

        listaComerciales.add(c1);
        listaComerciales.add(c2);
        listaComerciales.add(c3);

        Producto p1 = new Comestible(2.95, "Yogurt Danone", LocalDate.now());
        Producto p2 = new Bazar(5.95, "Pilas Duracell AAA", "Varios");
        Producto p3 = new Bazar(2.95, "Plato Blanco plano", "Vajilla");
        Producto p4 = new Comestible(8.95, "Turron Blando", LocalDate.now());
        Producto p5 = new Bazar(312.95, "Lavadora Bosh", "Electrodomesticos");
        Producto p6 = new Bazar(312.95, "Don limpio", "Limpieza");
        Producto p7 = new Bazar(312.95, "Disiclin", "Limpieza");

        listaProductos.add(p1);
        listaProductos.add(p2);
        listaProductos.add(p3);
        listaProductos.add(p4);
        listaProductos.add(p5);
        listaProductos.add(p6);
        listaProductos.add(p7);

    }

    private static void menu() {
        // Encabezado
        System.out.println("--------------------");
        System.out.println("Menú de Almacen");
        System.out.println("--------------------");

        System.out.println("Seleccione lo que desea realizar:");
        System.out.println("1: Alta productos");
        System.out.println("2: Alta comerciales");
        System.out.println("3: Eliminar productos de Limpieza");
        System.out.println("4: Mostrar especialidades de los comerciales");
        System.out.println("5: Coste medio de comestibles");
        System.out.println("6: Productos de caducidad próxima");
        System.out.println("7: Salir");
    }

    private static Producto altaProducto() {
        Scanner sc = new Scanner(System.in);
        Producto p;
        double precio;
        String nombre, categoria, tipo;
        LocalDate fechaCaducidad;
        do {
            try {
                System.out.println("-------- Alta productos ---------");

                System.out.println("Introduzca nombre");
                nombre = sc.nextLine();

                System.out.println("Introduzca precio");
                String precioString = sc.nextLine();
                precio = Double.parseDouble(precioString);
                Validaciones.validarPrecio(precio);

                System.out.println("Introduzca categoría (Comestible/Bazar)");
                categoria = sc.nextLine();
                Validaciones.validarCategoria(categoria);

                if (categoria.equalsIgnoreCase("Bazar")) {
                    System.out.println("Introduzca el tipo");
                    tipo = sc.nextLine();
                    p = new Bazar(precio, nombre, tipo);
                } else {
                    System.out.println("Introduzca la fecha de caducidad (Fomato: dd-mm-yyyy)");
                    fechaCaducidad = LocalDate.parse(sc.nextLine(), DateTimeFormatter.ofPattern("d-MM-yyyy"));
                    Validaciones.validarFecha(fechaCaducidad);
                    p = new Comestible(precio, nombre, fechaCaducidad);
                }

                return p;
            } catch (FechaInvalidaException e) {
                System.out.println(e.getMessage());
            } catch (PrecioInvalidoException e) {
                System.out.println(e.getMessage());
            } catch (DateTimeParseException e) {
                System.out.println("El formato debe ser dd-mm-yyy");
            } catch (Exception e) {
                System.out.println("El dato introducido no es valido!");
            }
        } while (true);

    }

    private static Comercial altaComercial() {
        Scanner sc = new Scanner(System.in);
        int edad;
        String nombre, apellidos, zona;
        do {
            try {
                System.out.println("-------- Alta comerciales ---------");

                System.out.println("Introduzca nombre");
                nombre = sc.nextLine();

                System.out.println("Introduzca apellidos");
                apellidos = sc.nextLine();

                System.out.println("Introduzca zona");
                zona = sc.nextLine();

                System.out.println("Introduzca edad");
                edad = sc.nextInt();

                return new Comercial(nombre, apellidos, edad, zona, crearRegistroComercial());

            } catch (Exception e) {
                System.out.println("Ha ocurrido un error al introducir los datos, vuelva a intentarlo!");
            }

        } while (true);

    }

    // En el siguiente método, cambiar tipo de dato de retorno al tipo de colección
    // elegida para el registro de los comerciales
    // Los elementos en el registro pueden introducirse manualmente, sin necesidad
    // de solicitarlos por teclado.
    private static HashMap<Integer, Producto> crearRegistroComercial() {
        HashMap<Integer, Producto> reg = new HashMap<>();
        reg.put(0, new Bazar(5.95, "Pilas Duracell AAA", "Varios"));
        reg.put(1, new Bazar(2.95, "Plato Blanco plano", "Vajilla"));
        reg.put(2, new Comestible(2.95, "Yogurt Danone", LocalDate.of(2024, 3, 31)));
        reg.put(3, new Comestible(8.95, "Turron Blando", LocalDate.of(2024, 3, 15)));
        reg.put(4, new Bazar(312.95, "Lavadora Bosh", "Electrodomesticos"));

        return reg;
    }

    private static void eliminarProductosLimpieza() {
        // mostrarProductos();
        listaProductos.removeIf(e -> e instanceof Bazar && ((Bazar) e).getTipo().equalsIgnoreCase("limpieza"));

        // mostrarProductos();
    }

    private static void especialidadComerciales() {
        for (Comercial comercial : listaComerciales) {
            int ventasBazar = (int) comercial.getVentas().values().stream().filter(e -> e instanceof Bazar).count();
            int ventasComestible = (int) comercial.getVentas().values().stream().filter(e -> e instanceof Comestible)
                    .count();
            String especialidad = (ventasBazar > ventasComestible) ? "Productos de Bazar" : "Productos Comestibles";
            System.out.println(
                    "Comercial: " + comercial.getNombre() + " " + comercial.getApellidos() + " Especialidad: "
                            + especialidad);
        }

    }

    private static void costeProductos() {
        double costeMedio = listaProductos.stream().filter(e -> e instanceof Comestible).map(Comestible.class::cast)
                .mapToDouble(e -> e.getPrecio()).average().getAsDouble();
        System.out.printf("El coste medio de los productos Comestible es: .2f" + costeMedio + " euros\n");
    }

    private static void productosCaducidadProxima() {
        LocalDate hoy = LocalDate.now();
        int totalProductos = 0;
        for (Comercial comercial : listaComerciales) {
            for (Producto p : comercial.getVentas().values()) {
                if (p instanceof Comestible) {
                    LocalDate fechaCaducidad = ((Comestible) p).getFechaCaducidad();
                    if (hoy.until(fechaCaducidad).getDays() < 5) {
                        System.out.println(p.toString());
                        totalProductos++;
                    }
                }
            }
        }
        System.out.println("Total de productos proximos a caducar: " + totalProductos);
    }

    private static void mostrarProductos() {
        System.out.println("LISTA DE PRODUCTOS:");
        listaProductos.stream().forEach(e -> System.out.println(e.toString()));
    }

}
