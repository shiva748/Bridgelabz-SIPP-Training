import java.util.Scanner;

public class StringBuilderReverse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string to reverse: ");
        String input = scanner.nextLine();
        StringBuilder stringBuilder = new StringBuilder(input);
        stringBuilder.reverse();
        String reversedString = stringBuilder.toString();
        System.out.println("Reversed string: " + reversedString);
        scanner.close();
    }
}