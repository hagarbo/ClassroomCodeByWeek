public class Palindromo {

    public static boolean esPalindromo(String s) {

        for (int i = 0; i < s.length() / 2; i++) {
            String s1 = s.substring(i, i + 1);
            String s2 = s.substring(s.length() - 1 - i, s.length() - 1);
            if (!s.substring(i, i + 1).equalsIgnoreCase(s.substring(s.length() - 1 - i, s.length() - 1)))
                return false;
        }
        return true;
    }
}
