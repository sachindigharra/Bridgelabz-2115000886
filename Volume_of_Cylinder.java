import java.util.*;
public class Volume_of_Cylinder {
    public static void main(String[] args) {
        System.out.println("we Use MAth Library for pi& pow functions");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the radius of the cylinder:");
        double radius = sc.nextDouble();
        System.out.println("Enter the height of the cylinder:");
        double height = sc.nextDouble();
        double volume = Math.PI * Math.pow(radius, 2) * height;
        System.out.println("The volume of the cylinder is: " + volume);
        sc.close();
    }
}
