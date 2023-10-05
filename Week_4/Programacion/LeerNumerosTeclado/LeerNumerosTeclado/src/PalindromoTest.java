import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PalindromoTest {
    @Test
    public void testEsPalindromo() {
        String input = "Otto";
        assertEquals(true, Palindromo.esPalindromo(input));
    }
}
