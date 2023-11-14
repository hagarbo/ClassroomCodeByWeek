import java.util.LinkedHashMap;
import java.util.Set;

public class DecimalRomanConverter {

    public static String decimalToRoman(int decimalNum) {
        LinkedHashMap<Integer, String> conversionTable = new LinkedHashMap<>();
        conversionTable.put(1000, "M");
        conversionTable.put(900, "CM");
        conversionTable.put(500, "D");
        conversionTable.put(400, "CD");
        conversionTable.put(100, "C");
        conversionTable.put(90, "XC");
        conversionTable.put(50, "L");
        conversionTable.put(40, "XL");
        conversionTable.put(10, "X");
        conversionTable.put(9, "IX");
        conversionTable.put(5, "V");
        conversionTable.put(4, "IV");
        conversionTable.put(1, "I");

        /*
         * String resultado = "";
         * int resto = decimalNum;
         * 
         * Set<Integer> keys = conversionTable.keySet();
         * for (Integer key : keys) {
         * int times = (int) (resto / key);
         * resto = resto % key;
         * resultado += conversionTable.get(key).repeat(times);
         * }
         */

        var restoWrapper = new Object() {
            int resto = decimalNum;
        };
        var resultWrapper = new Object() {
            String result = "";
        };
        conversionTable.forEach(
                (key, value) -> {
                    int times = (int) (restoWrapper.resto / key);
                    restoWrapper.resto = restoWrapper.resto % key;
                    resultWrapper.result += conversionTable.get(key).repeat(times);
                });
        return resultWrapper.result;
    }
}
