import java.util.Arrays;
import java.util.Map;

public class Electrodomestico {

    private final static String CONSUMOS = "ABCDE";
    private final static String[] COLORES = { "BLANCO", "NEGRO", "ROJO", "AZUL", "GRIS" };
    private final static String DEFAULT_COLOR = "BLANCO";
    private final static char DEFAULT_CONSUMO = 'F';
    private final static Map<Character, Integer> INCREMENTOS = Map.of(
            'A', 100,
            'B', 80,
            'C', 60,
            'D', 50,
            'E', 30,
            'F', 10);

    private int basePrice;
    private String color;
    private char consumo;
    private int peso;

    public Electrodomestico() {
        this(100, "blanco", 'F', 5);
    }

    public Electrodomestico(int basePrice, int peso) {
        this(basePrice, "blanco", 'F', peso);
    }

    public Electrodomestico(int basePrice, String color, char consumo, int peso) {
        this.basePrice = basePrice;
        this.color = comprobarColor(color);
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
        this.color = comprobarColor(color);
    }

    public char getConsumo() {
        return consumo;
    }

    public void setConsumo(char consumo) {
        this.consumo = comprobarConsumoEnergetico(consumo);
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    private char comprobarConsumoEnergetico(char letra) {
        if (CONSUMOS.contains(Character.toString(letra)))
            return letra;
        else
            return DEFAULT_CONSUMO;
    }

    private String comprobarColor(String color) {
        String checkedColor = Arrays.asList(COLORES).contains(color.toUpperCase()) ? color.toUpperCase()
                : DEFAULT_COLOR;
        return checkedColor;
    }

    public int precioFinal() {
        return this.basePrice + this.getIncremento();
    }

    private int getIncremento() {
        return INCREMENTOS.get(this.consumo) != null ? INCREMENTOS.get(this.consumo) : 0;
    }

    @Override
    public String toString() {
        return "Electrodomestico [precio=" + basePrice + ", color=" + color + ", consumo=" + consumo + ", peso="
                + peso + "]";
    }

}
