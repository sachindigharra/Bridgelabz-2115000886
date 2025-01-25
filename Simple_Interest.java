import java.util.*;
public class Simple_Interest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the principal amount:");
        double principal = sc.nextDouble();
        System.out.println("Enter the rate of interest per annum:");
        double rate = sc.nextDouble();
        System.out.println("Enter the time in years:");
        double time = sc.nextDouble();

        double simpleInterest = (principal * rate * time) / 100;
        System.out.println("The simple interest is: " + simpleInterest);
        sc.close();
    }
}
