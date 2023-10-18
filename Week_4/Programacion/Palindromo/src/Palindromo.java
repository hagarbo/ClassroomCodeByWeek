public class Palindromo {

    public static boolean esPalindromo(String s) {

        for (int i = 0; i <= (s.length() / 2); i++) {

            if (s.charAt(i) != s.charAt(s.length() - 1 - i))// longitud de la cadena - 1 porque los indices empiezan en
                                                            // 0 y no
                                                            // en 1
                return false;
        }
        return true;
    }
}
