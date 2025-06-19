import java.util.Scanner;

public class TextCaseConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text to convert: ");
        String text = scanner.nextLine();
        
        String customUpperCase = convertToUpperCase(text);
        String builtInUpperCase = text.toUpperCase();
        
        boolean areEqual = compareStrings(customUpperCase, builtInUpperCase);
        System.out.println("\nConverted text (custom method): " + customUpperCase);
        System.out.println("Converted text (built-in): " + builtInUpperCase);
        System.out.println("Results match: " + areEqual);
        
        scanner.close();
    }
    
    static String convertToUpperCase(String text) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                result.append((char)(ch - 32));
            } else {
                result.append(ch);
            }
        }
        return result.toString();
    }
    
    static boolean compareStrings(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
