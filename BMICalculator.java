import java.util.Scanner;

public class BMICalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of persons: ");
        int numPersons = scanner.nextInt();

        double[] weight = new double[numPersons];
        double[] height = new double[numPersons];
        double[] bmi = new double[numPersons];
        String[] weightStatus = new String[numPersons];

        for (int i = 0; i < numPersons; i++) {
            System.out.print("Enter weight for person " + (i + 1) + " (in kg): ");
            while (!scanner.hasNextDouble() || scanner.nextDouble() < 0) {
                System.out.println("Invalid input. Please enter a positive weight.");
                scanner.next(); // Clear invalid input
            }
            weight[i] = scanner.nextDouble();

            System.out.print("Enter height for person " + (i + 1) + " (in meters): ");
            while (!scanner.hasNextDouble() || scanner.nextDouble() < 0) {
                System.out.println("Invalid input. Please enter a positive height.");
                scanner.next(); // Clear invalid input
            }
            height[i] = scanner.nextDouble();

            bmi[i] = weight[i] / (height[i] * height[i]);

            if (bmi[i] < 18.5) {
                weightStatus[i] = "Underweight";
            } else if (bmi[i] >= 18.5 && bmi[i] < 25) {
                weightStatus[i] = "Normal";
            } else if (bmi[i] >= 25 && bmi[i] < 30) {
                weightStatus[i] = "Overweight";
            } else {
                weightStatus[i] = "Obese";
            }
        }

        System.out.println("Height\tWeight\tBMI\t\tStatus");
        for (int i = 0; i < numPersons; i++) {
            System.out.printf("%.2f\t%.2f\t%.2f\t%s\n", height[i], weight[i], bmi[i], weightStatus[i]);
        }
    }
}