package jan28;

public class ReverseString {
    public static void main(String[] args) {
        String str = "hello";
        String reversedStr = "";

        for (int i = str.length() - 1; i >= 0; i--) {
            reversedStr += str.charAt(i);
        }

        System.out.println("Reversed String: " + reversedStr);
    }
}