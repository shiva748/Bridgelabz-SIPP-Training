import java.util.Scanner;

public class SumOfNaturalNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a natural number: ");
        int number = scanner.nextInt();

        if (number < 1) {
            System.out.println("The number " + number + " is not a natural number.");
        } else {
            int sum = 0;
            for (int i = 1; i <= number; i++) {
                sum += i;
            }
            System.out.println("The sum of " + number + " natural numbers is " + sum + ".");
        }
        scanner.close();
    }
}