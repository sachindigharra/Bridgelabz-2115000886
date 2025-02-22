
public class ValidateHexColor {
    public static boolean isValidHexColor(String color) {
        String regex = "^#[0-9A-Fa-f]{6}$";
        return color.matches(regex);
    }

    public static void main(String[] args) {
        System.out.println(isValidHexColor("#FFA500"));  // true
        System.out.println(isValidHexColor("#ff4500"));  // true
        System.out.println(isValidHexColor("#123"));     // false
    }
}

