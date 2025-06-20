import java.util.Scanner;

public class MaximumOfThree {
    public static void main(String[] args) {
        int[] numbers = getInputNumbers();
        int max = findMaximum(numbers);
        displayResult(max);
    }
    
    static int[] getInputNumbers() {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[3];
        
        for (int i = 0; i < 3; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            numbers[i] = scanner.nextInt();
        }
        
        scanner.close();
        return numbers;
    }
    
    static int findMaximum(int[] numbers) {
        int max = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }
        return max;
    }
    
    static void displayResult(int max) {
        System.out.println("Maximum number is: " + max);
    }
}
