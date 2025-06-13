import java.util.Scanner;

public class FactorsWhile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a positive integer: ");
        int number = scanner.nextInt();

        if (number > 0) {
            int counter = 1;
            System.out.println("Factors of " + number + " are:");
            while (counter < number) {
                if (number % counter == 0) {
                    System.out.println(counter);
                }
                counter++;
            }
        } else {
            System.out.println("Please enter a positive integer.");
        }

        scanner.close();
    }
}