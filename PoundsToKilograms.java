import java.util.*;
public class PoundsToKilograms {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the weight in pounds: ");
        double weightInPounds = scanner.nextDouble();

        double weightInKilograms = weightInPounds / 2.2;

        System.out.println("The weight of the person in pound is " + weightInPounds + " and in kg is " + weightInKilograms);

        scanner.close();
    }
}