public class Palindromo {

    public static boolean esPalindromo(String s) {

        for (int i = 0; i <= s.length() / 2; i++) {
            char s1 = s.charAt(i);
            char s2 = s.charAt(s.length() - 1 - i);
            if (s.charAt(i) == s.charAt(s.length() - 1 - i))
                return false;
        }
        return true;
    }
}
