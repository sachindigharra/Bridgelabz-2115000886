import java.util.Scanner;

public class InputKilometer_to_miles {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter distance in kilometers: ");
        double km = input.nextDouble();
        double conversionFactor = 1.6;
        double miles = km / conversionFactor;
        System.out.printf("The total distance is %.2f miles for the given %.2f km.\n", miles, km);
        input.close();
    }
}
