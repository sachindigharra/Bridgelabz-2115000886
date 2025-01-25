import java.util.Scanner;

public class DiscountCalculatorUpdate {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the course fee: ");
        double fee = scanner.nextDouble();
        System.out.print("Enter the discount percentage: ");
        double discountPercent = scanner.nextDouble();
        double discountAmount = (fee * discountPercent) / 100;
        double discountedFee = fee - discountAmount;
        System.out.println("The discount amount is INR " + discountAmount);
        System.out.println("The final discounted fee is INR " + discountedFee);

        scanner.close();
    }
}