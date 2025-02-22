
import java.util.regex.*;

public class ValidateUsername {
    public static boolean isValidUsername(String username) {
        String regex = "^[a-zA-Z][a-zA-Z0-9_]{4,14}$";
        return username.matches(regex);
    }

    public static void main(String[] args) {
        System.out.println(isValidUsername("user_123"));  // true
        System.out.println(isValidUsername("123user"));   // false
        System.out.println(isValidUsername("us"));        // false
    }
}

