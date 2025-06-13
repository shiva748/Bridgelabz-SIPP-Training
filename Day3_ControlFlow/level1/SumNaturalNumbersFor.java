
public class SumNaturalNumbersFor {

    public static void main(String[] args) {
        int n;
        int sumUsingLoop = 0;

        if (args.length > 0) {
            try {
                n = Integer.parseInt(args[0]);

                if (n > 0) {
                    for (int i = 1; i <= n; i++) {
                        sumUsingLoop += i;
                    }

                    int sumUsingFormula = n * (n + 1) / 2;

                    System.out.println("The sum of " + n + " natural numbers using for loop is: " + sumUsingLoop);
                    System.out.println("The sum of " + n + " natural numbers using formula is: " + sumUsingFormula);

                    if (sumUsingLoop == sumUsingFormula) {
                        System.out.println("Both computations are correct.");
                    } else {
                        System.out.println("There is a discrepancy between the two computations.");
                    }
                } else {
                    System.out.println(n + " is not a natural number.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
            }
        } else {
            System.out.println("Please provide a number as input.");
        }
    }
}
