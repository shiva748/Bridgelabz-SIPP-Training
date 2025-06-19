import java.util.Scanner;

public class ArrayIndexOutOfBoundsDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of names: ");
        int size = scanner.nextInt();
        scanner.nextLine();
        
        String[] names = new String[size];
        for (int i = 0; i < size; i++) {
            System.out.print("Enter name " + (i + 1) + ": ");
            names[i] = scanner.nextLine();
        }
        
        generateException(names);
        handleException(names);
        scanner.close();
    }
    
    static void generateException(String[] names) {
        System.out.println("\nGenerating exception...");
        String name = names[names.length + 1];
        System.out.println("This line will not be executed");
    }
    
    static void handleException(String[] names) {
        System.out.println("\nHandling exception...");
        try {
            String name = names[names.length + 1];
            System.out.println("Name: " + name);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException caught: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Runtime Exception caught: " + e.getMessage());
        }
    }
}
