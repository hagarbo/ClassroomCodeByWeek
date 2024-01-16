public class App {
    public static void main(String[] args) throws Exception {
        Television superTV = new Television(300, "negro", 'A', 30, 50, true);
        System.out.println("Precio Final: " + superTV.precioFinal());
        System.out.println(superTV.toString());

        Television superTV2 = new Television();
        System.out.println("Precio Final: " + superTV2.precioFinal());
        System.out.println(superTV2.toString());

        Electrodomestico[] tienda = new Electrodomestico[4];

        tienda[0] = new Electrodomestico();
        tienda[1] = new Lavavajillas();
        tienda[2] = superTV;
        tienda[3] = superTV2;

        int precioTotal = 0;
        int precioTV = 0;
        int precioL = 0;
        for (Electrodomestico e : tienda) {

        }
    }
}
