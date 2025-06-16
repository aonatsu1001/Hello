import java.util.Scanner;
import java.lang.Math;

public class kazuate {

    public static void main(String[] args) {
        // 1. Set the secret number (a 2-digit positive integer from 10 to 99)
        int answer = 76;
        int maxAttempts = 5;
        boolean isCorrect = false;

        // Welcome messages in English
        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("Guess a 2-digit positive integer. You have " + maxAttempts + " attempts.");
        System.out.println("------------------------------------");

        // Use try-with-resources to safely handle the Scanner
        try (Scanner scanner = new Scanner(System.in)) {

            // 2. Loop for the number of attempts
            for (int i = 1; i <= maxAttempts; i++) {
                System.out.print("Enter your guess #" + i + ": ");

                // Get user input
                int userInput = scanner.nextInt();

                // 3. Check if the guess is correct
                if (userInput == answer) {
                    System.out.println("🎉 Correct! You win!");
                    isCorrect = true;
                    break; // Exit the loop on correct guess
                } else {
                    // 4. Provide a hint if the guess is wrong
                    String hint;
                    if (userInput < answer) {
                        hint = "Too small.";
                    } else {
                        hint = "Too large.";
                    }
                    System.out.print(hint);

                    // 5. Check if the difference is 20 or more
                    if (Math.abs(userInput - answer) >= 20) {
                        System.out.println(" (Hint: You are more than 20 away!)");
                    } else {
                        System.out.println(); // Just a newline after the regular hint
                    }
                }
            }
        }

        System.out.println("------------------------------------");
        // 6. Final message at the end of the game
        if (!isCorrect) {
            System.out.println("Sorry, you've run out of attempts. The correct answer was " + answer + ".");
        }
        System.out.println("Game Over.");
    }
}