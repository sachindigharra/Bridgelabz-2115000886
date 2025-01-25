import java.util.Scanner;

public class YoungestTallestFriends {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] ages = new int[3];
        double[] heights = new double[3];

        for (int i = 0; i < 3; i++) {
            System.out.print("Enter age for friend " + (i + 1) + ": ");
            ages[i] = scanner.nextInt();

            System.out.print("Enter height for friend " + (i + 1) + ": ");
            heights[i] = scanner.nextDouble();
        }

        int youngestAge = ages[0];
        int youngestIndex = 0;
        double tallestHeight = heights[0];
        int tallestIndex = 0;

        for (int i = 1; i < 3; i++) {
            if (ages[i] < youngestAge) {
                youngestAge = ages[i];
                youngestIndex = i;
            }
            if (heights[i] > tallestHeight) {
                tallestHeight = heights[i];
                tallestIndex = i;
            }
        }

        System.out.println("Youngest friend: Friend " + (youngestIndex + 1));
        System.out.println("Tallest friend: Friend " + (tallestIndex + 1));
    }
}