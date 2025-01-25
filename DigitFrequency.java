import java.util.Scanner;

public class DigitFrequency {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        // Find the count of digits
        int temp = number;
        int digitCount = 0;
        while (temp != 0) {
            temp /= 10;
            digitCount++;
        }

        // Extract digits and store in an array
        int[] digits = new int[digitCount];
        int index = 0;
        temp = number;
        while (temp != 0) {
            digits[index] = temp % 10;
            temp /= 10;
            index++;
        }

        // Initialize frequency array
        int[] frequency = new int[10]; // Array to store frequency of digits 0-9

        // Calculate frequency of each digit
        for (int i = 0; i < digitCount; i++) {
            frequency[digits[i]]++;
        }

        // Display frequency of each digit
        System.out.println("Frequency of digits:");
        for (int i = 0; i < 10; i++) {
            System.out.println(i + ": " + frequency[i]);
        }
    }
}