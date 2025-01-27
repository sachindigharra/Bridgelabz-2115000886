package jan27;
import java.util.Scanner;

public class QuotientAndRemainder {

    public static int[] findRemainderAndQuotient(int number, int divisor) {
        int quotient = number / divisor;
        int remainder = number % divisor;

        return new int[]{remainder, quotient};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number: ");
        int number = scanner.nextInt();

        System.out.print("Enter the divisor: ");
        int divisor = scanner.nextInt();

        int[] result = findRemainderAndQuotient(number, divisor);

        System.out.println("Remainder: " + result[0]);
        System.out.println("Quotient: " + result[1]);

        scanner.close();
    }
}