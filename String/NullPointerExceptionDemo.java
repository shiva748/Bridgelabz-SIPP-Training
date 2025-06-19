public class NullPointerExceptionDemo {
    public static void main(String[] args) {
        generateException();
        handleException();
    }
    
    static void generateException() {
        System.out.println("Generating exception...");
        String text = null;
        int length = text.length();
        System.out.println("This line will not be executed");
    }
    
    static void handleException() {
        System.out.println("\nHandling exception...");
        String text = null;
        try {
            int length = text.length();
            System.out.println("Length: " + length);
        } catch (NullPointerException e) {
            System.out.println("NullPointerException caught: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Runtime Exception caught: " + e.getMessage());
        }
    }
}
