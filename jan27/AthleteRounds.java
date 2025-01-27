package jan27;

import java.util.Scanner;

public class AthleteRounds {

    public static double calculateRounds(double side1, double side2, double side3, double targetDistance) {
        double perimeter = side1 + side2 + side3;
        return targetDistance / perimeter;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter side 1 of the park: ");
        double side1 = scanner.nextDouble();

        System.out.print("Enter side 2 of the park: ");
        double side2 = scanner.nextDouble();

        System.out.print("Enter side 3 of the park: ");
        double side3 = scanner.nextDouble();

        double targetDistance = 5000; // 5 km in meters

        double rounds = calculateRounds(side1, side2, side3, targetDistance);

        System.out.println("Number of rounds: " + rounds);

        scanner.close();
    }
}