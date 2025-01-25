import java.util.Random;

public class Celsius_to_Fahrenheit {
    public static void main(String[] args) {
        Random r = new Random();
        double celsius = r.nextDouble() * 100;
        double fahrenheit = (celsius * 9/5) + 32;
        System.out.println(" formating is used to take Only Two digit After decimal");
        System.out.printf("%.2f°C is equal to %.2f°F%n", celsius, fahrenheit);  // %.2f is for displaying 2 decimal places
    }
}
