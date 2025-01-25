import java.util.Scanner;

public class StudentGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int numStudents = scanner.nextInt();

        double[] physicsMarks = new double[numStudents];
        double[] chemistryMarks = new double[numStudents];
        double[] mathsMarks = new double[numStudents];
        double[] percentages = new double[numStudents];
        char[] grades = new char[numStudents];

        for (int i = 0; i < numStudents; i++) {
            System.out.println("Enter marks for student " + (i + 1) + ":");

            System.out.print("Physics: ");
            while (!scanner.hasNextDouble() || scanner.nextDouble() < 0) {
                System.out.println("Invalid input. Please enter a positive value.");
                scanner.next(); // Clear invalid input
            }
            physicsMarks[i] = scanner.nextDouble();

            System.out.print("Chemistry: ");
            while (!scanner.hasNextDouble() || scanner.nextDouble() < 0) {
                System.out.println("Invalid input. Please enter a positive value.");
                scanner.next(); // Clear invalid input
            }
            chemistryMarks[i] = scanner.nextDouble();

            System.out.print("Maths: ");
            while (!scanner.hasNextDouble() || scanner.nextDouble() < 0) {
                System.out.println("Invalid input. Please enter a positive value.");
                scanner.next(); // Clear invalid input
            }
            mathsMarks[i] = scanner.nextDouble();

            // Calculate percentage
            percentages[i] = (physicsMarks[i] + chemistryMarks[i] + mathsMarks[i]) / 300 * 100;

            // Determine grade based on percentage
            if (percentages[i] >= 80) {
                grades[i] = 'A';
            } else if (percentages[i] >= 70) {
                grades[i] = 'B';
            } else if (percentages[i] >= 60) {
                grades[i] = 'C';
            } else if (percentages[i] >= 50) {
                grades[i] = 'D';
            } else if (percentages[i] >= 40) {
                grades[i] = 'E';
            } else {
                grades[i] = 'R';
            }
        }

        // Display results
        System.out.println("\nStudent\tPhysics\tChemistry\tMaths\tPercentage\tGrade");
        for (int i = 0; i < numStudents; i++) {
            System.out.printf("%d\t\t%.2f\t\t%.2f\t\t%.2f\t\t%.2f\t\t%c\n",
                    i + 1, physicsMarks[i], chemistryMarks[i], mathsMarks[i], percentages[i], grades[i]);
        }
    }
}