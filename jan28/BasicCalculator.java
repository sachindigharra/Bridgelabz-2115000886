package jan28;

import java.util.Scanner;

public class BasicCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nChoose an operation:");
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");
            System.out.println("5. Exit");

            int choice = getValidChoice(scanner, 1, 5);

            if (choice == 5) {
                System.out.println("Exiting calculator.");
                break;
            }

            System.out.print("Enter the first number: ");
            double num1 = scanner.nextDouble();
            System.out.print("Enter the second number: ");
            double num2 = scanner.nextDouble();

            double result = 0.0;
            switch (choice) {
                case 1:
                    result = add(num1, num2);
                    break;
                case 2:
                    result = subtract(num1, num2);
                    break;
                case 3:
                    result = multiply(num1, num2);
                    break;
                case 4:
                    result = divide(num1, num2);
                    break;
            }

            System.out.println("Result: " + result);
        }

        scanner.close();
    }

    // Helper function to get valid user input for choices
    public static int getValidChoice(Scanner scanner, int min, int max) {
        int choice;
        do {
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Clear invalid input
            }
            choice = scanner.nextInt();
        } while (choice < min || choice > max);
        return choice;
    }

    // Function for addition
    public static double add(double a, double b) {
        return a + b;
    }

    // Function for subtraction
    public static double subtract(double a, double b) {
        return a - b;
    }

    // Function for multiplication
    public static double multiply(double a, double b) {
        return a * b;
    }

    // Function for division
    public static double divide(double a, double b) {
        if (b == 0) {
            System.out.println("Error: Division by zero.");
            return Double.NaN; // Return Not-a-Number
        }
        return a / b;
    }
}