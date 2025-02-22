
import java.util.regex.*;

public class ValidateEmail {
    public static boolean isValidEmail(String email) {
        // Regex pattern for a valid email address
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(isValidEmail("example@gmail.com")); // true
        System.out.println(isValidEmail("user.name@domain.com")); // true
        System.out.println(isValidEmail("user@domain")); // false
        System.out.println(isValidEmail("user@.com")); // false
        System.out.println(isValidEmail("user@domain..com")); // false
    }
}

