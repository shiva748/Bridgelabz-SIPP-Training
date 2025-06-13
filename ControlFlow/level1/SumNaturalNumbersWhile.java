import java.util.Scanner;

public class SumNaturalNumbersWhile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a natural number: ");
        int n = scanner.nextInt();

        if (n < 1) {
            System.out.println(n + " is not a natural number.");
        } else {
            int sum = 0;
            int i = 1;

            while (i <= n) {
                sum += i;
                i++;
            }

            int formulaSum = n * (n + 1) / 2;
            System.out.println("The sum of " + n + " natural numbers is " + sum);
            System.out.println("The sum calculated using the formula n*(n+1)/2 is " + formulaSum);

            if (sum == formulaSum) {
                System.out.println("Both computations are correct.");
            } else {
                System.out.println("There is a discrepancy in the computations.");
            }
        }

        scanner.close();
    }
}