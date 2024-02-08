import java.util.Scanner;
import java.util.Random;

public class numbergame {
    private static final int MAX_ATTEMPTS = 10;
    private static final int MAX_ROUNDS = 3;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int score = 0;
        boolean playAgain = true;

        while (playAgain) {
            int correctNumber = random.nextInt(100) + 1;
            int attempts = 0;
            boolean guessedCorrectly = false;

            while (!guessedCorrectly && attempts < MAX_ATTEMPTS) {
                System.out.print("Guess a number between 1 and 100: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == correctNumber) {
                    System.out.println("Congratulations! You guessed the correct number.");
                    guessedCorrectly = true;
                    score++;
                } else if (userGuess > correctNumber) {
                    System.out.println("Your guess is too high. Try again.");
                } else {
                    System.out.println("Your guess is too low. Try again.");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry, you've run out of attempts. The correct number was " + correctNumber + ".");
            }

            System.out.print("Do you want to play again? (y/n): ");
            String response = scanner.next();
            playAgain = response.equalsIgnoreCase("y");
        }

        System.out.println("Thanks for playing! Your score is " + score + ".");
    }
}