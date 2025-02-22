
public class ValidateStrongPassword {
    public static boolean isValidPassword(String password) {
        String regex = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@#$%^&+=!]).{8,}$";
        return password.matches(regex);
    }

    public static void main(String[] args) {
        System.out.println(isValidPassword("Str0ng@Pass")); // true
        System.out.println(isValidPassword("weakpass"));    // false
    }
}

