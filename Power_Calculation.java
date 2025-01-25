import java.util.*;
public class Power_Calculation {
 public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the base number:");
    double base = sc.nextDouble();
    System.out.println("Enter the exponent:");
    int exponent = sc.nextInt();
    double power = Math.pow(base, exponent);
    
    System.out.println("The result of " + base + " raised to the power of " + exponent + " is: " + power);
    sc.close();
 }   
}
