package jan27;

import java.util.Scanner;

public class SmallestAndLargest {

    public static int[] findSmallestAndLargest(int number1, int number2, int number3) {
        int smallest = Math.min(Math.min(number1, number2), number3);
        int largest = Math.max(Math.max(number1, number2), number3);

        return new int[]{smallest, largest};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number 1: ");
        int number1 = scanner.nextInt();

        System.out.print("Enter number 2: ");
        int number2 = scanner.nextInt();

        System.out.print("Enter number 3: ");
        int number3 = scanner.nextInt();

        int[] result = findSmallestAndLargest(number1, number2, number3);

        System.out.println("Smallest: " + result[0]);
        System.out.println("Largest: " + result[1]);

        scanner.close();
    }
}