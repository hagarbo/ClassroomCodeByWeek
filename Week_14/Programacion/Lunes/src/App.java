public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Maximo numero de clientes: " + Restaurante.maxClientes(3.5, 1.4));

        Dado dado = new Dado(6);
        Moneda moneda = new Moneda(2);
        for (int i = 0; i < 10; i++) {
            // dado.lanzar();
            // moneda.lanzar();
        }

        Aparato[] instalacion = new Aparato[5];
        for (int i = 0; i < instalacion.length; i++) {
            int potencia = (int) ((Math.random() * (21 - 1)) + 1);
            instalacion[i] = new Aparato(potencia);
            System.out.println(instalacion[i].toString());
        }

        for (Aparato aparato : instalacion) {
            aparato.encender();
            System.out.println("Encendido " + aparato.toString());
            System.out.println("Consumo Actual: " + Aparato.consumo);
        }

        Electrodomestico e1 = new Electrodomestico();
        System.out.println("PF: " + e1.precioFinal());

        Electrodomestico e2 = new Electrodomestico(200, "negro", 'A', 5);
        System.out.println("PF: " + e2.precioFinal());

    }
}
