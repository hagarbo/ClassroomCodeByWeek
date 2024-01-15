public class Moneda extends Sorteo {

    private final int MAX = 2;
    private final int MIN = 0;

    public Moneda(int posibilidades) {
        super(posibilidades);
    }

    @Override
    public int lanzar() {
        int tirada = (int) ((Math.random() * (MAX - MIN)) + MIN);
        System.out.println(tirada == 0 ? "Cara" : "Cruz");
        return tirada;
    }

}
