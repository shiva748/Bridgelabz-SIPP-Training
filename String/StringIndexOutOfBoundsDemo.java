import java.util.Scanner;

public class StringIndexOutOfBoundsDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = scanner.next();
        generateException(text);
        handleException(text);
        scanner.close();
    }

    static void generateException(String text) {
        char ch = text.charAt(text.length() + 1);
        System.out.println("Character: " + ch);
    }

    static void handleException(String text) {
        try {
            char ch = text.charAt(text.length() + 1);
            System.out.println("Character: " + ch);
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("StringIndexOutOfBoundsException caught: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("RuntimeException caught: " + e.getMessage());
        }
    }
}
