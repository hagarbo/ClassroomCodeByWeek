import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidadorDni {

    private static final int LONGITUD_DNI = 9;
    private static final String PATRON_DNI = "[0-9]{8}[a-zA-Z]";
    private static final String[] ARRAY_LETRAS = { "T", "R", "W", "A", "G", "M", "Y", "F", "P", "D", "X", "B", "N", "J",
            "Z", "S", "Q", "V", "H", "L", "C", "K", "E" };
    private static final String[] ARRAY_INVALIDOS = { "00000000T", "00000001R", "99999999R" };

    public static boolean validar(String dni) {

        return (comprobarLongitud(dni) && tienePatronValido(dni) && tieneletraValida(dni)
                && estaEnInvalidos(dni));
    }

    private static boolean estaEnInvalidos(String dni) {

        for (int i = 0; i < ARRAY_INVALIDOS.length; i++) {
            if (dni.equalsIgnoreCase(ARRAY_INVALIDOS[i]))
                return false;
        }
        return true;
    }

    private static boolean tieneletraValida(String dni) {

        int dniInt = Integer.parseInt(dni.substring(0, LONGITUD_DNI - 1));
        String letraDNI = dni.substring(LONGITUD_DNI - 1, LONGITUD_DNI);

        if (letraDNI.equalsIgnoreCase(ARRAY_LETRAS[dniInt % ARRAY_LETRAS.length]))
            return true;
        else
            return false;
    }

    private static boolean tienePatronValido(String dni) {
        Pattern pattern = Pattern.compile(PATRON_DNI);
        Matcher matcher = pattern.matcher(dni);
        if (matcher.find())
            return true;
        else
            return false;
    }

    private static boolean comprobarLongitud(String dni) {
        if (dni.length() == LONGITUD_DNI)
            return true;
        else
            return false;
    }

}
