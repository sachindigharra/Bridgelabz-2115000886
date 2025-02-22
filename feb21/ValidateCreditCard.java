
public class ValidateCreditCard {
    public static boolean isValidCreditCard(String cardNumber) {
        String regex = "^\\d{16}$";
        return cardNumber.matches(regex);
    }

    public static void main(String[] args) {
        System.out.println(isValidCreditCard("1234567812345678")); // true
        System.out.println(isValidCreditCard("1234-5678-1234-5678")); // false
    }
}

