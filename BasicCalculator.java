import java.util.Scanner;

public class BasicCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the first number: ");
        double number1 = scanner.nextDouble();

        System.out.print("Enter the second number: ");
        double number2 = scanner.nextDouble();
        double addition = number1 + number2;
        double subtraction = number1 - number2;
        double multiplication = number1 * number2;
        double division = (number2 != 0) ? number1 / number2 : Double.NaN;
        System.out.println("The addition of " + number1 + " and " + number2 + " is: " + addition);
        System.out.println("The subtraction of " + number1 + " and " + number2 + " is: " + subtraction);
        System.out.println("The multiplication of " + number1 + " and " + number2 + " is: " + multiplication);
        System.out.println("The division of " + number1 + " and " + number2 + " is: " + division);

        scanner.close();
    }
}