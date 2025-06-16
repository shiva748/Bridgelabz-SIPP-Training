import java.util.Scanner;

public class HarshadNumberFor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();
        scanner.close();

        int originalNumber = number;
        int sum = 0;

        for (int temp = number; temp > 0; temp /= 10) {
            int digit = temp % 10;
            sum += digit;
        }
        
        if (originalNumber % sum == 0) {
            System.out.println(originalNumber + " is a Harshad Number");
        } else {
            System.out.println(originalNumber + " is Not a Harshad Number");
        }
        scanner.close();
    }
} 