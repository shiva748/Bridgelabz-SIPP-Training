import java.util.Scanner;

public class StringMethodsDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = scanner.nextLine();
        
        System.out.println("Length: " + text.length());
        System.out.println("Uppercase: " + text.toUpperCase());
        System.out.println("Lowercase: " + text.toLowerCase());
        
        if (text.length() > 0) {
            System.out.println("First character: " + text.charAt(0));
            System.out.println("Last character: " + text.charAt(text.length() - 1));
        }
        
        System.out.print("Enter a substring to find: ");
        String substr = scanner.nextLine();
        System.out.println("Index of '" + substr + "': " + text.indexOf(substr));
        
        System.out.print("Enter replacement string: ");
        String replacement = scanner.nextLine();
        System.out.println("After replacing '" + substr + "' with '" + replacement + "': " + 
                         text.replace(substr, replacement));
                         
        System.out.println("Trimmed string: '" + text.trim() + "'");
        System.out.println("Contains 'hello': " + text.contains("hello"));
        System.out.println("Empty string: " + text.isEmpty());
        
        scanner.close();
    }
}
