import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int min = 1;
        int max = 100;
        int guesses = 0;
        
        System.out.println("Think of a number between 1 and 100.");
        System.out.println("After each guess, enter:");
        System.out.println("'h' if the guess is too high");
        System.out.println("'l' if the guess is too low");
        System.out.println("'c' if the guess is correct");
        
        while (true) {
            int guess = generateGuess(min, max);
            guesses++;
            
            System.out.println("\nMy guess is: " + guess);
            System.out.print("Enter feedback (h/l/c): ");
            char feedback = scanner.next().charAt(0);
            
            if (feedback == 'c') {
                System.out.println("I guessed it in " + guesses + " tries!");
                break;
            } else if (feedback == 'h') {
                max = guess - 1;
            } else if (feedback == 'l') {
                min = guess + 1;
            }
            
            if (min > max) {
                System.out.println("You may have made a mistake in your feedback.");
                break;
            }
        }
        
        scanner.close();
    }
    
    static int generateGuess(int min, int max) {
        return min + (max - min) / 2;
    }
}
