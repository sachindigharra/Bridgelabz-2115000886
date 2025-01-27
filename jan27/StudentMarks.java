import java.util.*;
import java.text.DecimalFormat;

public class StudentMarks {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of students: ");
        int numStudents = scanner.nextInt();

        int[][] studentScores = generateScores(numStudents);
        double[][] studentResults = calculateResults(studentScores);

        displayScorecard(studentScores, studentResults);
    }

    public static int[][] generateScores(int numStudents) {
        int[][] scores = new int[numStudents][3]; // Physics, Chemistry, Math
        Random rand = new Random();

        for (int i = 0; i < numStudents; i++) {
            scores[i][0] = rand.nextInt(101); // Physics
            scores[i][1] = rand.nextInt(101); // Chemistry
            scores[i][2] = rand.nextInt(101); // Math
        }

        return scores;
    }

    public static double[][] calculateResults(int[][] scores) {
        double[][] results = new double[scores.length][3]; // Total, Average, Percentage

        for (int i = 0; i < scores.length; i++) {
            int total = scores[i][0] + scores[i][1] + scores[i][2];
            double average = (double) total / 3;
            double percentage = (double) total / 300 * 100;

            results[i][0] = total;
            results[i][1] = roundTo2Decimals(average);
            results[i][2] = roundTo2Decimals(percentage);
        }

        return results;
    }

    public static void displayScorecard(int[][] scores, double[][] results) {
        System.out.println("--------------------------------------------------");
        System.out.println("Student\tPhysics\tChemistry\tMath\tTotal\tAverage\tPercentage");
        System.out.println("--------------------------------------------------");

        for (int i = 0; i < scores.length; i++) {
            System.out.printf("%d\t%d\t\t%d\t\t%d\t\t%.2f\t\t%.2f%%\n",
                    i + 1, scores[i][0], scores[i][1], scores[i][2], results[i][0], results[i][2]);
        }

        System.out.println("--------------------------------------------------");
    }

    public static double roundTo2Decimals(double value) {
        DecimalFormat df = new DecimalFormat("#.##");
        return Double.parseDouble(df.format(value));
    }
}