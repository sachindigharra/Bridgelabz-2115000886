import java.util.Scanner;

public class BMICalculator2DArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of persons: ");
        int numPersons = scanner.nextInt();

        double[][] personData = new double[numPersons][3]; // 2D array: [person][weight, height, BMI]
        String[] weightStatus = new String[numPersons];

        for (int i = 0; i < numPersons; i++) {
            System.out.print("Enter weight for person " + (i + 1) + " (in kg): ");
            while (!scanner.hasNextDouble() || scanner.nextDouble() < 0) {
                System.out.println("Invalid input. Please enter a positive weight.");
                scanner.next(); // Clear invalid input
            }
            personData[i][0] = scanner.nextDouble();

            System.out.print("Enter height for person " + (i + 1) + " (in meters): ");
            while (!scanner.hasNextDouble() || scanner.nextDouble() < 0) {
                System.out.println("Invalid input. Please enter a positive height.");
                scanner.next(); // Clear invalid input
            }
            personData[i][1] = scanner.nextDouble();

            // Calculate BMI
            personData[i][2] = personData[i][0] / (personData[i][1] * personData[i][1]);

            // Determine weight status
            if (personData[i][2] < 18.5) {
                weightStatus[i] = "Underweight";
            } else if (personData[i][2] >= 18.5 && personData[i][2] < 25) {
                weightStatus[i] = "Normal";
            } else if (personData[i][2] >= 25 && personData[i][2] < 30) {
                weightStatus[i] = "Overweight";
            } else {
                weightStatus[i] = "Obese";
            }
        }

        System.out.println("Height\tWeight\tBMI\t\tStatus");
        for (int i = 0; i < numPersons; i++) {
            System.out.printf("%.2f\t%.2f\t%.2f\t%s\n", personData[i][1], personData[i][0], personData[i][2], weightStatus[i]);
        }
    }
}