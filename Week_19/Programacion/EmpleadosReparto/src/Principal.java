import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author nccasares
 */

/**
 * Implementar un programa que gestione empleados.
 *
 * Características:
 * Nombre
 * Edad
 * Salario
 * También existirá una constante llamada PLUS, que tendrá un valor de 300€
 *
 * La clase empleado no necesitará ser instanciada.
 * Existen dos tipos de empleados: repartidor y comercial.
 *
 * El comercial, aparte de los atributos anteriores, tiene uno propio llamado
 * comisión (double).
 *
 * El repartidor, aparte de los atributos de empleado, tiene otro propio zona
 * (String).
 *
 * Crea sus constructores, getters and setters y toString.
 *
 * Las clases tendrán un método llamado plus, que según en cada clase tendrá una
 * implementación distinta.
 * En comercial, si tiene más de 30 años y cobra una comisión de más de 200
 * euros, se le aplicará el plus.
 * En repartidor, si tiene menos de 25 y reparte en la “zona 3”, recibirá el
 * plus.
 *
 * Crea una clase ejecutable donde crees distintos empleados y le apliques el
 * plus para comprobar que funciona.
 */

public class Principal {

    private static Scanner myScanner = new Scanner(System.in);

    public static int mostrarMenu() {
        System.out.println("*******************************************");
        System.out.println("Seleccione que opcion desea realizar:");
        System.out.println("1.- Añadir Empleado");
        System.out.println("2.- Mostrar Empleados");
        System.out.println("0.- Salir");
        System.out.println("*******************************************");
        boolean opcionInvalida = true;
        int opcion;
        do {
            opcion = myScanner.nextInt();
            if (opcion == 1 || opcion == 2 || opcion == 0)
                opcionInvalida = false;
            else
                System.out.println("Elija una opcion valida!!");
        } while (opcionInvalida);
        myScanner.nextLine();
        return opcion;
    }

    public static String solicitarNombre() {
        String nombre = "";
        boolean opcionInvalida = true;
        do {
            System.out.println("Introduzca el nombre del empleado:");
            nombre = myScanner.nextLine();
            try {
                validarNombre(nombre);
                opcionInvalida = false;
            } catch (EmpleadoInputException e) {
                System.out.println(e.getMessage());
            }
        } while (opcionInvalida);
        return nombre;
    }

    public static boolean validarNombre(String nombre) throws EmpleadoInputException {
        if (nombre.matches("[A-Za-z]{0,20}"))
            return true;
        else
            throw new EmpleadoInputException(EmpleadoInputException.INVALID_NOMBRE);
    }

    public static int solicitarEdad() {
        int edad = 0;
        boolean opcionInvalida = true;
        do {
            System.out.println("Introduzca el nombre del empleado:");
            edad = myScanner.nextInt();
            try {
                validarEdad(edad);
                opcionInvalida = false;
            } catch (EmpleadoInputException e) {
                System.out.println(e.getMessage());
            }
        } while (opcionInvalida);
        myScanner.nextLine();
        return edad;
    }

    public static boolean validarEdad(int edad) throws EmpleadoInputException {
        if (edad > 0 && edad < 1000)
            return true;
        else
            throw new EmpleadoInputException(EmpleadoInputException.INVALID_EDAD);
    }

    public static double solicitarSalario() {
        double salario = 0;
        boolean opcionInvalida = true;
        do {
            System.out.println("Introduzca el nombre del empleado:");
            salario = myScanner.nextDouble();
            try {
                validarSalario(salario);
                opcionInvalida = false;
            } catch (EmpleadoInputException e) {
                System.out.println(e.getMessage());
            }
        } while (opcionInvalida);
        myScanner.nextLine();
        return salario;
    }

    public static boolean validarSalario(double salario) throws EmpleadoInputException {
        if (salario > 0 && salario < 100000)
            return true;
        else
            throw new EmpleadoInputException(EmpleadoInputException.INVALID_SALARIO);
    }

    public static void main(String[] args) {

        Comercial c1 = new Comercial(300, "Francisco", 37, 1000);
        Repartidor r1 = new Repartidor("zona 3", "María", 26, 900);

        ArrayList<Empleado> empleados = new ArrayList<>();
        empleados.add(c1);
        empleados.add(r1);

        boolean exit = false;
        String nombre;
        int edad;
        double salario;
        int task;

        do {
            task = mostrarMenu();
            if (task == 1) {
                // Añadir EMpleado
                nombre = solicitarNombre();
                edad = solicitarEdad();
                salario = solicitarSalario();
                empleados.add(new Comercial(300, nombre, edad, salario));
            } else if (task == 2) {
                // Mostra empleados
                System.out.println("Lista de empleados:");
                empleados.stream().forEach(
                        empleado -> System.out.println(empleado.toString()));
                System.out.println();
            } else
                exit = true;

        } while (exit != true);
    }
}
