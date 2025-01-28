package jan28;

public class CompareStrings {
    public static void main(String[] args) {
        String str1 = "apple";
        String str2 = "banana";

        int len1 = str1.length();
        int len2 = str2.length();
        int limit = Math.min(len1, len2);

        for (int i = 0; i < limit; i++) {
            if (str1.charAt(i) < str2.charAt(i)) {
                System.out.println(str1 + " comes before " + str2 + " in lexicographical order");
                return;
            } else if (str1.charAt(i) > str2.charAt(i)) {
                System.out.println(str2 + " comes before " + str1 + " in lexicographical order");
                return;
            }
        }

        // If all characters are equal up to the shorter string's length
        if (len1 < len2) {
            System.out.println(str1 + " comes before " + str2 + " in lexicographical order");
        } else if (len1 > len2) {
            System.out.println(str2 + " comes before " + str1 + " in lexicographical order");
        } else {
            System.out.println("The strings are equal.");
        }
    }
}