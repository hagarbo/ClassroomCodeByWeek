
public class App {

    /*
     * [FrasesVectoriales]
     * Todo las funciones descritas a continuación deben de estar en una clase
     * llamada Main y serán funciones estáticas.
     * 
     * Vamos a trabajar con un vector de chars:
     * 
     * 1. Este método recibe el array de chars como parámetro y devuelve la frase
     * descifrada como un String.
     * getSentece(char[] array): String
     */
    public static String getSentence(char[] array) {
        return new String(array);
    }

    /*
     * 2. Otra función llamada "checkWord" que permite verificar si una palabra
     * existe dentro de la frase.
     * checkWord(char[], String secuencia): boolean
     * Debes utilizar la anterior función obtenerFrase() para trabajar con Strings
     * directamente.
     */

    public static boolean checkWord(char[] array, String secuencia) {
        return getSentence(array).contains(secuencia.toLowerCase());
    }

    /*
     * 3. checkWords es exactamente igual que la anterior, pero sirve para verificar
     * que existen varias palabras en la frase.
     * checkWords(char[] array, String[]): boolean
     */

    public static boolean checkWords(char[] array, String[] frases) {
        for (String secuencia : frases) {
            if (!getSentence(array).contains(secuencia.toLowerCase()))
                return false;
        }
        return true;
    }

    /*
     * 4. Este método comprueba que existe la frase completa. Evidentemente tiene
     * que estar en orden las palabras, no vale unicamente con verificar que
     * contiene dichas palabras.
     * checkSentence(char[] array, String sentence): boolean
     */

    public static boolean checkSentence(char[] array, String sentence) {
        return (getSentence(array).equalsIgnoreCase(sentence));
    }

    public static void main(String[] args) throws Exception {
        String s = "*";
        for (int i = 0; i < 5; i++) {
            System.out.println(s.repeat(i));
        }

    }
}