
import static org.junit.jupiter.api.Assertions.*;
public class UserRegistration {
    public static void registerUser(String username, String email, String password) {
        if (username == null || username.isEmpty()) {
            throw new IllegalArgumentException("Username cannot be empty");
        }
        if (!email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            throw new IllegalArgumentException("Invalid email format");
        }
        if (!PasswordValidator.isValid(password)) {
            throw new IllegalArgumentException("Password is too weak");
        }
    }
}


import org.junit.jupiter.api.Test;

class UserRegistrationTest {

    @Test
    void testValidUserRegistration() {
        assertDoesNotThrow(() -> UserRegistration.registerUser("Sachin", "sachin@example.com", "StrongPass1"));
    }

    @Test
    void testEmptyUsername() {
        assertThrows(IllegalArgumentException.class, () -> UserRegistration.registerUser("", "sachin@example.com", "StrongPass1"));
    }

    @Test
    void testInvalidEmail() {
        assertThrows(IllegalArgumentException.class, () -> UserRegistration.registerUser("Sachin", "invalid-email", "StrongPass1"));
    }

    @Test
    void testWeakPassword() {
        assertThrows(IllegalArgumentException.class, () -> UserRegistration.registerUser("Sachin", "sachin@example.com", "weak"));
    }
}

