import java.util.Scanner;

public class StringComparisonDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter first string: ");
        String str1 = scanner.nextLine();
        
        System.out.print("Enter second string: ");
        String str2 = scanner.nextLine();
        
        System.out.println("Using equals(): " + str1.equals(str2));
        System.out.println("Using equalsIgnoreCase(): " + str1.equalsIgnoreCase(str2));
        System.out.println("Using compareTo(): " + str1.compareTo(str2));
        System.out.println("Using compareToIgnoreCase(): " + str1.compareToIgnoreCase(str2));
        
        String str3 = new String(str1);
        System.out.println("Using == operator: " + (str1 == str3));
        System.out.println("Using equals() with new String: " + str1.equals(str3));
        
        System.out.println("Starts with 'Hello': " + str1.startsWith("Hello"));
        System.out.println("Ends with 'World': " + str1.endsWith("World"));
        
        scanner.close();
    }
}
