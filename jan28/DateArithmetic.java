package jan28;

import java.time.LocalDate;

public class DateArithmetic {

    public static void main(String[] args) {
        LocalDate today = LocalDate.now();

        // Add 7 days, 1 month, and 2 years
        LocalDate futureDate = today.plusDays(7).plusMonths(1).plusYears(2);

        // Subtract 3 weeks
        LocalDate finalDate = futureDate.minusWeeks(3);

        System.out.println("Original Date: " + today);
        System.out.println("Future Date: " + futureDate);
        System.out.println("Final Date: " + finalDate);
    }
}