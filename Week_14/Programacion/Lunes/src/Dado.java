public class Dado extends Sorteo {

    private final int MAX = 7;
    private final int MIN = 1;

    public Dado(int posibilidades) {
        super(posibilidades);
    }

    @Override
    public int lanzar() {
        int tirada = (int) ((Math.random() * (MAX - MIN)) + MIN);
        System.out.println(tirada);
        return tirada;
    }

}
