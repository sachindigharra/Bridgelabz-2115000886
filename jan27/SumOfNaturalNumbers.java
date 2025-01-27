package jan27;

import java.util.Scanner;

public class SumOfNaturalNumbers {

    public static int sumOfNaturalNumbers(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int n = scanner.nextInt();

        int sum = sumOfNaturalNumbers(n);

        System.out.println("Sum of first " + n + " natural numbers: " + sum);

        scanner.close();
    }
}