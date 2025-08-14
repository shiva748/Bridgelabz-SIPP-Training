
public class Username {
    public static void main(String[] args) {
        String username = "user_123";
        boolean valid = username.matches("^[A-Za-z][A-Za-z0-9_]{4,14}$");
        System.out.println(valid ? "Valid" : "Invalid");
    }
}