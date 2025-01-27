import java.util.Scanner;

public class SumOfNaturalNumbersN {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a natural number: ");
        int n = scanner.nextInt();

        if (n <= 0) {
            System.out.println("Invalid input. Please enter a positive integer.");
        } else {
            System.out.println("Sum of " + n + " natural numbers (recursive): " + sumOfNaturalNumbersRecursive(n));
            System.out.println("Sum of " + n + " natural numbers (formula): " + sumOfNaturalNumbersFormula(n));
        }

        scanner.close();
    }

    public static int sumOfNaturalNumbersRecursive(int n) {
        if (n == 1) {
            return 1;
        }
        return n + sumOfNaturalNumbersRecursive(n - 1);
    }

    public static int sumOfNaturalNumbersFormula(int n) {
        return n * (n + 1) / 2;
    }
}