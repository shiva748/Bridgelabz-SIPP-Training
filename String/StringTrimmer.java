import java.util.Scanner;

public class StringTrimmer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter text with leading/trailing spaces:");
        String text = scanner.nextLine();
        
        int[] bounds = findTrimBounds(text);
        String customTrimmed = customSubstring(text, bounds[0], bounds[1]);
        String builtInTrimmed = text.trim();
        
        boolean areEqual = compareStrings(customTrimmed, builtInTrimmed);
        
        System.out.println("\nOriginal text: '" + text + "'");
        System.out.println("Custom trimmed: '" + customTrimmed + "'");
        System.out.println("Built-in trimmed: '" + builtInTrimmed + "'");
        System.out.println("Results match: " + areEqual);
        
        scanner.close();
    }
    
    static int[] findTrimBounds(String text) {
        int start = 0;
        int end = text.length() - 1;
        
        while (start < text.length() && text.charAt(start) == ' ') {
            start++;
        }
        
        while (end >= start && text.charAt(end) == ' ') {
            end--;
        }
        
        return new int[]{start, end + 1};
    }
    
    static String customSubstring(String text, int start, int end) {
        StringBuilder result = new StringBuilder();
        for (int i = start; i < end; i++) {
            result.append(text.charAt(i));
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
