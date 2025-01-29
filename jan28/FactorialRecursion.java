package jan28;

import java.util.Scanner;

public class FactorialRecursion {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int n = scanner.nextInt();

        int factorial = calculateFactorial(n);

        System.out.println("Factorial of " + n + " is: " + factorial);
        scanner.close();
    }

    // Recursive function to calculate factorial
    public static int calculateFactorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * calculateFactorial(n - 1);
        }
    }
}