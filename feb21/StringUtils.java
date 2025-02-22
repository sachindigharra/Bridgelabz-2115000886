// Junit Programs
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
public class StringUtils {
    public static String reverse(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    public static boolean isPalindrome(String str) {
        return str.equalsIgnoreCase(reverse(str));
    }

    public static String toUpperCase(String str) {
        return str.toUpperCase();
    }
}


class StringUtilsTest {
    
    @Test
    void testReverse() {
        assertEquals("dcba", StringUtils.reverse("abcd"));
    }

    @Test
    void testPalindrome() {
        assertTrue(StringUtils.isPalindrome("madam"));
        assertFalse(StringUtils.isPalindrome("hello"));
    }

    @Test
    void testToUpperCase() {
        assertEquals("HELLO", StringUtils.toUpperCase("hello"));
    }
}

