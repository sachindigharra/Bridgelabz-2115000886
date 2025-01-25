import java.util.*;
public class Addition {
    public static void main(String[] args) {
        Random rand = new Random();
        int num1 = rand.nextInt(100) + 1;
        int num2 = rand.nextInt(100) + 1;
        int sum = num1 + num2;
        System.out.println("Additon of " + num1 + "+ " + num2+" : " + sum);
    }
}
