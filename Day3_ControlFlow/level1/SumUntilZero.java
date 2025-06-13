import java.util.Scanner;

public class SumUntilZero {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double total = 0.0;
        double userInput;

        System.out.println("Enter numbers to sum (enter 0 to stop):");

        while (true) {
            userInput = scanner.nextDouble();
            if (userInput == 0) {
                break;
            }
            total += userInput;
        }

        System.out.println("The total sum is: " + total);
        scanner.close();
    }
}