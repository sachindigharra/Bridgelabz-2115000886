import java.util.Scanner;

public class EmployeeBonus {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] salary = new double[10];
        double[] yearsOfService = new double[10];
        double[] bonus = new double[10];
        double[] newSalary = new double[10];

        double totalBonus = 0;
        double totalOldSalary = 0;
        double totalNewSalary = 0;

        for (int i = 0; i < 10; i++) {
            System.out.print("Enter salary for employee " + (i + 1) + ": ");
            while (!scanner.hasNextDouble() || scanner.nextDouble() < 0) {
                System.out.println("Invalid input. Please enter a positive salary.");
                scanner.next(); // Clear invalid input
            }
            salary[i] = scanner.nextDouble();

            System.out.print("Enter years of service for employee " + (i + 1) + ": ");
            while (!scanner.hasNextDouble() || scanner.nextDouble() < 0) {
                System.out.println("Invalid input. Please enter a positive number of years.");
                scanner.next(); // Clear invalid input
            }
            yearsOfService[i] = scanner.nextDouble();

            totalOldSalary += salary[i];
        }

        for (int i = 0; i < 10; i++) {
            if (yearsOfService[i] > 5) {
                bonus[i] = 0.05 * salary[i];
            } else {
                bonus[i] = 0.02 * salary[i];
            }
            newSalary[i] = salary[i] + bonus[i];

            totalBonus += bonus[i];
            totalNewSalary += newSalary[i];
        }

        System.out.println("\nTotal Bonus Payout: " + totalBonus);
        System.out.println("Total Old Salary: " + totalOldSalary);
        System.out.println("Total New Salary: " + totalNewSalary);
        scanner.close();
    }
}