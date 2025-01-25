import java.util.*;
public class Perimeter_of_Rectangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the length of the rectangle:");
        int length = sc.nextInt();
        System.out.println("Enter the width of the rectangle:");
        int width = sc.nextInt();
        int perimeter = 2 * (length + width);
        System.out.println("The perimeter of the rectangle is: " + perimeter);
        sc.close();
    }
}
