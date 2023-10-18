import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PalindromoTest {
    @Test
    public void testEsPalindromo() {
        String input = "otto";
        assertEquals(true, Palindromo.esPalindromo(input));

        input = "adrian";
        assertEquals(false, Palindromo.esPalindromo(input));

        input = "abcdefedcba";
        assertEquals(true, Palindromo.esPalindromo(input));

        input = "supercalifragilistoespialidoso";
        assertEquals(false, Palindromo.esPalindromo(input));
    }

}
