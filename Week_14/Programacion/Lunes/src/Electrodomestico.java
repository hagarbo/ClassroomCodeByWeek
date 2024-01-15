public class Electrodomestico {

    private final String CONSUMOS = "ABCDE";

    private int basePrice;
    private String color;
    private char consumo;
    private int peso;

    public Electrodomestico() {
        this(100, "blanco", 'F', 5);
    }

    public Electrodomestico(int basePrice, String color, char consumo, int peso) {
        this.basePrice = basePrice;
        this.color = color;
        this.consumo = comprobarConsumoEnergetico(consumo);
        this.peso = peso;
    }

    public int getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(int basePrice) {
        this.basePrice = basePrice;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public char getConsumo() {
        return consumo;
    }

    public void setConsumo(char consumo) {
        this.consumo = consumo;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public char comprobarConsumoEnergetico(char letra) {
        if (CONSUMOS.contains(Character.toString(letra)))
            return letra;
        else
            return 'F';
    }
}
