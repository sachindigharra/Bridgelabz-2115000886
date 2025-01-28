package jan28;

public class RemoveDuplicates {
    public static void main(String[] args) {
        String str = "hello";
        String result = "";

        for (int i = 0; i < str.length(); i++) {
            if (!result.contains(String.valueOf(str.charAt(i)))) {
                result += str.charAt(i);
            }
        }

        System.out.println("String without duplicates: " + result);
    }
}