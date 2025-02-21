public class InterestCalculator {
    public static double calculateInterest(double amount, double rate, int years) throws IllegalArgumentException {
        if (amount < 0 || rate < 0) {
            throw new IllegalArgumentException("Amount and rate must be positive");
        }
        return amount * rate * years;
    }

    public static void main(String[] args) {
        try {
            double interest = calculateInterest(1000, 0.05, 5);
            System.out.println("Interest: " + interest);
            interest = calculateInterest(-1000, 0.05, 5); // Example: Invalid input
            System.out.println("Interest: " + interest);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
} 
