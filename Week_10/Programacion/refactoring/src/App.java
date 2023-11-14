import java.util.Arrays;
import java.util.HashMap;

public class App {
    public static void main(String[] args) {
        int[] numeros = { 2, 9, 7, 10, 12 };
        triple(numeros, 3);
        int[] distancias = { 100102, 100000, 5001234 };
        distance(distancias);
        System.out.println("******* CONTAR VOCALES: {murcielago,patata} *******");
        vowelCounter("murcielago"); // Después prueba con patata
        vowelCounter("patata");
        System.out.println("******* FRUTAS *******");
        String[] frutas = { "Pera", "Pera", "Manzana", "Naranja" };
        frutas(frutas);
        System.out.println("******* FRUTAS 2 *******");
        String[] frutas2 = { "Pera", "Pera", "Pera", "Pera" };
        frutas(frutas2);

        System.out.println("1999 en romano:" + DecimalRomanConverter.decimalToRoman(1999));
        System.out.println("4999 en romano:" + DecimalRomanConverter.decimalToRoman(4999));
        System.out.println("45 en romano:" + DecimalRomanConverter.decimalToRoman(45));
        System.out.println("495 en romano:" + DecimalRomanConverter.decimalToRoman(495));
        System.out.println("40 en romano:" + DecimalRomanConverter.decimalToRoman(40));
        System.out.println("1900 en romano:" + DecimalRomanConverter.decimalToRoman(1900));
        System.out.println("500 en romano:" + DecimalRomanConverter.decimalToRoman(500));
        System.out.println("800 en romano:" + DecimalRomanConverter.decimalToRoman(800));
        System.out.println("410 en romano:" + DecimalRomanConverter.decimalToRoman(410));

    }

    public static void triple(int[] numeros, int multiplier) {
        Arrays.stream(numeros).forEach(numero -> System.out.println(numero * multiplier));
    }

    public static void distance(int[] centimeters) {
        Arrays.stream(centimeters)
                .forEach(
                        value -> System.out.println(value / 100000 + " Kilometros " + (value % 100000) / 100
                                + " metros " + (value % 100) + " centimetros"));
    }

    final static char[] VOCALES = { 'a', 'e', 'i', 'o', 'u' };

    private static boolean isVowel(char c) {
        int matches = (int) new String(VOCALES).chars().mapToObj(i -> (char) i)
                .filter(letra -> Character.toUpperCase(letra) == Character.toUpperCase(c)).count();
        return (matches > 0);
    }

    public static void vowelCounter(String palabra) {
        char[] letras = palabra.toCharArray();
        int vowelCounter = (int) new String(letras).chars().mapToObj(i -> (char) i)
                .filter(letra -> isVowel(letra)).count();
        System.out.println("Número de vocales: " + vowelCounter);
    }

    // Nuestro programador no sabe como obtener el número de frutas iguales que
    // están las bolsas
    public static void frutas(String[] frutas) {
        // El siguiente tipo de estructura de datos se llama diccionario, HashMap o
        // clave/valor.
        // Permite encontrar un valor buscando por su clave.
        HashMap<String, Integer> fruitsCounter = new HashMap<>();

        Arrays.stream(frutas).forEach(
                fruta -> {
                    if (fruitsCounter.containsKey(fruta))
                        fruitsCounter.replace(fruta, fruitsCounter.get(fruta) + 1);
                    else
                        fruitsCounter.put(fruta, 1);
                });

        fruitsCounter.forEach((key, value) -> System.out.println("Número de " + key + "s: " + value));

    }
}
