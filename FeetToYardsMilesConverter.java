import java.util.Scanner;

public class FeetToYardsMilesConverter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       
        System.out.print("Enter the distance in feet: ");
        double distanceInFeet = scanner.nextDouble();
        double feetPerYard = 3.0;
        double yardsPerMile = 1760.0;
        double distanceInYards = distanceInFeet / feetPerYard;       
        double distanceInMiles = distanceInYards / yardsPerMile;

        System.out.println("Distance in yards: " + distanceInYards);
        System.out.println("Distance in miles: " + distanceInMiles);

        scanner.close();
    }
}