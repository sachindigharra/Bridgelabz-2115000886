package jan28;

import java.util.Scanner;

public class PalindromeChecker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String str = scanner.nextLine();

        if (isPalindrome(str)) {
            System.out.println(str + " is a palindrome.");
        } else {
            System.out.println(str + " is not a palindrome.");
        }

        scanner.close();
    }

    // Function to check if a string is a palindrome
    public static boolean isPalindrome(String str) {
        String reverse = new StringBuilder(str).reverse().toString();
        return str.equals(reverse);
    }
}