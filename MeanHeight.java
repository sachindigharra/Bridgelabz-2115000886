import java.util.Scanner;

public class MeanHeight {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] heights = new double[11];

        System.out.println("Enter the heights of 11 players:");
        for (int i = 0; i < heights.length; i++) {
            heights[i] = scanner.nextDouble();
        }

        double sum = 0;
        for (double height : heights) {
            sum += height;
        }

        double meanHeight = sum / heights.length;
        System.out.println("Mean height of players: " + meanHeight);

        scanner.close();
    }
}