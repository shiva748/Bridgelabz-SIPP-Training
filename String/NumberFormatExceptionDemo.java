import java.util.Scanner;

public class NumberFormatExceptionDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a text containing a number: ");
        String text = scanner.nextLine();
        generateException(text);
        handleException(text);
        scanner.close();
    }
    
    static void generateException(String text) {
        System.out.println("\nGenerating exception...");
        int number = Integer.parseInt(text);
        System.out.println("This line will not be executed if text is not a number");
    }
    
    static void handleException(String text) {
        System.out.println("\nHandling exception...");
        try {
            int number = Integer.parseInt(text);
            System.out.println("Parsed number: " + number);
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException caught: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Runtime Exception caught: " + e.getMessage());
        }
    }
}
