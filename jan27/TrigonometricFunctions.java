package jan27;

import java.util.Scanner;

public class TrigonometricFunctions {

    public static double[] calculateTrigonometricFunctions(double angleInDegrees) {
        // Convert degrees to radians
        double angleInRadians = Math.toRadians(angleInDegrees);

        // Calculate sine, cosine, and tangent
        double sine = Math.sin(angleInRadians);
        double cosine = Math.cos(angleInRadians);
        double tangent = Math.tan(angleInRadians);

        // Store results in an array
        double[] results = {sine, cosine, tangent};

        return results;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the angle in degrees: ");
        double angleInDegrees = scanner.nextDouble();

        double[] results = calculateTrigonometricFunctions(angleInDegrees);

        System.out.println("Sine: " + results[0]);
        System.out.println("Cosine: " + results[1]);
        System.out.println("Tangent: " + results[2]);

        scanner.close();
    }
}