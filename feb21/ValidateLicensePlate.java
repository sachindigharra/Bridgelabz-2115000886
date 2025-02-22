
import java.util.regex.*;

public class ValidateLicensePlate {
    public static boolean isValidLicensePlate(String plate) {
        String regex = "^[A-Z]{2}\\d{4}$";
        return plate.matches(regex);
    }

    public static void main(String[] args) {
        System.out.println(isValidLicensePlate("AB1234"));  // true
        System.out.println(isValidLicensePlate("A12345"));  // false
    }
}

