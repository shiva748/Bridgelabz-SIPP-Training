import java.util.Scanner;

public class StringLengthFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = scanner.next();
        
        int customLength = findLength(text);
        int builtInLength = text.length();
        
        System.out.println("\nLength using custom method: " + customLength);
        System.out.println("Length using built-in method: " + builtInLength);
        System.out.println("Results match: " + (customLength == builtInLength));
        
        scanner.close();
    }
    
    static int findLength(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count);
                count++;
            }
        } catch (IndexOutOfBoundsException e) {
            return count;
        }
    }
}
