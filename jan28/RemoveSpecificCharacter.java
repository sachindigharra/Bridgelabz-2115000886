package jan28;

public class RemoveSpecificCharacter {
    public static void main(String[] args) {
        String str = "Hello World";
        char charToRemove = 'l';
        String result = "";

        for (char ch : str.toCharArray()) {
            if (ch != charToRemove) {
                result += ch;
            }
        }

        System.out.println("Modified String: " + result);
    }
}