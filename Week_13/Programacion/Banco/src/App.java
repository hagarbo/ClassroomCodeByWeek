import java.time.LocalDate;

public class App {
    public static void main(String[] args) throws Exception {

        Titular t1 = new Titular("Eugenio", LocalDate.of(2008, 1, 10), 'A');
        System.out.println(t1.toString());
        Cuenta cuenta = new Cuenta(t1);
        cuenta.ingresar(-200);
        System.out.println("Cantidad despues de ingresar -200 euros: " + cuenta.getCantidad());
        cuenta.ingresar(500);
        System.out.println("Cantidad despues de ingresar 500 euros: " + cuenta.getCantidad());
        cuenta.retirar(50);
        System.out.println("Cantidad despues de retirar 50 euros: " + cuenta.getCantidad());
        cuenta.retirar(500);
        System.out.println("Cantidad despues de ingresar 500 euros: " + cuenta.getCantidad());

    }
}
