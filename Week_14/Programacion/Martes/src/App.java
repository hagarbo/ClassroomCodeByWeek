import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        Television superTV = new Television(300, "negro", 'A', 30, 50, true);
        System.out.println("Precio Final: " + superTV.precioFinal());
        System.out.println(superTV.toString());

        Television superTV2 = new Television();
        System.out.println("Precio Final: " + superTV2.precioFinal());
        System.out.println(superTV2.toString());

        Electrodomestico[] tienda = new Electrodomestico[10];

        /*
         * tienda[0] = new Electrodomestico();
         * tienda[1] = new Lavavajillas();
         * tienda[2] = superTV;
         * tienda[3] = superTV2;
         */

        for (int i = 0; i < tienda.length; i++) {
            int n = (int) (Math.random() * 3);
            if (n == 0)
                tienda[i] = new Electrodomestico();
            if (n == 1)
                tienda[i] = new Lavavajillas();
            if (n == 2)
                tienda[i] = new Television();
        }

        int precioTotal = 0;
        int precioTV = 0;
        int precioL = 0;
        /*
         * for (Electrodomestico e : tienda) {
         * int p = e.precioFinal();
         * precioTotal += p;
         * if (e instanceof Television)
         * precioTV += p;
         * if (e instanceof Lavavajillas)
         * precioL += p;
         * System.out.println("Procesando: " + e.toString() + ", precio total= " + p);
         * }
         */

        precioTotal = Arrays.asList(tienda).stream()
                .reduce(0, (accum, obj) -> accum + obj.precioFinal(), Integer::sum);
        // precioTotal = Arrays.asList(tienda).stream().map(e ->
        // e.precioFinal()).reduce(0, Integer::sum);
        precioTV = Arrays.asList(tienda).stream()
                .filter(e -> (e instanceof Television))
                .map(e -> e.precioFinal())
                .reduce(0, Integer::sum);
        precioL = Arrays.asList(tienda).stream()
                .filter(e -> (e instanceof Lavavajillas))
                .map(e -> e.precioFinal())
                .reduce(0, Integer::sum);
        System.out.println("Precio de todos los objetos : " + precioTotal);
        System.out.println("Precio de los lavavajillas : " + precioL);
        System.out.println("Precio de las televisiones : " + precioTV);

    }
}
