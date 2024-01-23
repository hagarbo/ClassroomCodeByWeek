public class App {
    public static void main(String[] args) throws Exception {

        Vehiculo[] cosas = new Vehiculo[4];

        cosas[0] = new Motocicleta(100);
        cosas[1] = new Turismo(200);
        cosas[2] = new Motocicleta(180);
        cosas[3] = new Turismo(100);

        for (Vehiculo vehiculo : cosas) {
            vehiculo.acelerar(20);
            vehiculo.frenar(50);
        }
    }
}
