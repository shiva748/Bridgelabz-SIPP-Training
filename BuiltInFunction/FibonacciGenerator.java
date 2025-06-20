import java.util.Scanner;

public class FibonacciGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter number of terms: ");
        int terms = scanner.nextInt();
        
        generateFibonacci(terms);
        
        scanner.close();
    }
    
    static void generateFibonacci(int terms) {
        if (terms <= 0) {
            System.out.println("Please enter a positive number");
            return;
        }
        
        long first = 0;
        long second = 1;
        
        System.out.print("Fibonacci Series: ");
        
        for (int i = 1; i <= terms; i++) {
            System.out.print(first + " ");
            
            long sum = first + second;
            first = second;
            second = sum;
        }
        
        System.out.println();
    }
}
