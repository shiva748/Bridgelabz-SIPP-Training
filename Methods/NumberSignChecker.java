import java.util.Scanner;

public class NumberSignChecker {

    public static boolean isPositive(int number) {
        return number >= 0;
    }

    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

    public static int compare(int number1, int number2) {
        if (number1 > number2) {
            return 1;
        } else if (number1 == number2) {
            return 0;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[5];

        System.out.println("Enter 5 numbers:");

        for (int i = 0; i < 5; i++) {
            numbers[i] = scanner.nextInt();
        }

        for (int i = 0; i < 5; i++) {
            if (isPositive(numbers[i])) {
                if (isEven(numbers[i])) {
                    System.out.println(numbers[i] + " is positive and even.");
                } else {
                    System.out.println(numbers[i] + " is positive and odd.");
                }
            } else {
                if (isEven(numbers[i])) {
                    System.out.println(numbers[i] + " is negative and even.");
                } else {
                    System.out.println(numbers[i] + " is negative and odd.");
                }
            }
        }
        scanner.close();
    }
}
