
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
public class PasswordValidator {
    public static boolean isValid(String password) {
        if (password.length() < 8) return false;
        if (!password.matches(".*[A-Z].*")) return false;
        if (!password.matches(".*\\d.*")) return false;
        return true;
    }
}



class PasswordValidatorTest {

    @Test
    void testValidPassword() {
        assertTrue(PasswordValidator.isValid("Secure123"));
    }

    @Test
    void testShortPassword() {
        assertFalse(PasswordValidator.isValid("Short1"));
    }

    @Test
    void testNoUppercasePassword() {
        assertFalse(PasswordValidator.isValid("secure123"));
    }

    @Test
    void testNoDigitPassword() {
        assertFalse(PasswordValidator.isValid("SecurePass"));
    }
}

