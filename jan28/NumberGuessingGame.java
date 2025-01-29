package jan28;

import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int secretNumber = random.nextInt(100) + 1;
        int guess;
        int attempts = 0;
       

        System.out.println("Think of a number between 1 and 100.");

        do {
            guess = generateGuess();
            attempts++;
            System.out.println("Is it " + guess + "?");
            System.out.println("Enter 'h' if higher, 'l' if lower, or 'c' if correct:");
            char feedback = scanner.next().charAt(0);

            if (feedback == 'h') {
                // Adjust guessing range accordingly
            } else if (feedback == 'l') {
                // Adjust guessing range accordingly
            } 
        } while (feedback != 'c');

        System.out.println("I guessed it in " + attempts + " attempts!");
        scanner.close();
    }

    // Function to generate a random guess within the specified range
    public static int generateGuess() {
        // Implement your guessing logic here
        // For example, you could use a random number generator
        // or a more sophisticated algorithm
        return 0; // Replace with your actual guess generation logic
    }
}