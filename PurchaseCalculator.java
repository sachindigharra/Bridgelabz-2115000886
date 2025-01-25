import java.util.Scanner;

public class PurchaseCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the unit price of the item (INR): ");
        double unitPrice = scanner.nextDouble();
        System.out.print("Enter the quantity to be bought: ");
        int quantity = scanner.nextInt();
        double totalPrice = unitPrice * quantity;
        System.out.printf("The total purchase price is INR %.2f if the quantity is %d and unit price is INR %.2f\n", 
                totalPrice, quantity, unitPrice);

        scanner.close();
    }
}