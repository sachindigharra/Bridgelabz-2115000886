import java.util.Scanner;

public class StudentGrades2DArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int numStudents = scanner.nextInt();

        // 2D array to store marks: [student][physics, chemistry, maths]
        double[][] marks = new double[numStudents][3];
        double[] percentages = new double[numStudents];
        char[] grades = new char[numStudents];

        for (int i = 0; i < numStudents; i++) {
            System.out.println("Enter marks for student " + (i + 1) + ":");

            System.out.print("Physics: ");
            while (!scanner.hasNextDouble() || scanner.nextDouble() < 0) {
                System.out.println("Invalid input. Please enter a positive value.");
                scanner.next(); // Clear invalid input
            }
            marks[i][0] = scanner.nextDouble();

            System.out.print("Chemistry: ");
            while (!scanner.hasNextDouble() || scanner.nextDouble() < 0) {
                System.out.println("Invalid input. Please enter a positive value.");
                scanner.next(); // Clear invalid input
            }
            marks[i][1] = scanner.nextDouble();

            System.out.print("Maths: ");
            while (!scanner.hasNextDouble() || scanner.nextDouble() < 0) {
                System.out.println("Invalid input. Please enter a positive value.");
                scanner.next(); // Clear invalid input
            }
            marks[i][2] = scanner.nextDouble();

            // Calculate percentage
            percentages[i] = (marks[i][0] + marks[i][1] + marks[i][2]) / 300 * 100;

            // Determine grade
            if (percentages[i] >= 90) {
                grades[i] = 'A';
            } else if (percentages[i] >= 80) {
                grades[i] = 'B';
            } else if (percentages[i] >= 70) {
                grades[i] = 'C';
            } else if (percentages[i] >= 60) {
                grades[i] = 'D';
            } else {
                grades[i] = 'F';
            }
        }

        // Display results
        System.out.println("\nStudent\tPhysics\tChemistry\tMaths\tPercentage\tGrade");
        for (int i = 0; i < numStudents; i++) {
            System.out.printf("%d\t\t%.2f\t\t%.2f\t\t%.2f\t\t%.2f\t\t%c\n",
                    i + 1, marks[i][0], marks[i][1], marks[i][2], percentages[i], grades[i]);
        }
    }
}