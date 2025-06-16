import java.util.Scanner;

public class OddEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a natural number: ");
        int number = scanner.nextInt();
        scanner.close();
        if (number < 1) {
            System.out.println("The number " + number + " is not a natural number.");
            return;
        }

        System.out.println("Odd and Even numbers between 1 and " + number + ":");
        for (int i = 1; i <= number; i++) {
            if (i % 2 == 0) {
                System.out.println(i + " is an even number.");
            } else {
                System.out.println(i + " is an odd number.");
            }
        }
    }
}