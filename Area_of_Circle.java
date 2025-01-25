import java.util.*;
public class Area_of_Circle {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the radius of the circle:");
        int radius=sc.nextInt();
        double area=Math.PI*radius*radius;
        System.out.println("The area of the circle is: "+area);
        sc.close();
    }
}
