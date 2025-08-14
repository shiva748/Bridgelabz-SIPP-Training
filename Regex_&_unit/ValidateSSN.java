
public class ValidateSSN {
    public static void main(String[] args) {
        String ssn = "123-45-6789";
        boolean valid = ssn.matches("^\\d{3}-\\d{2}-\\d{4}$");
        System.out.println(valid ? "Valid" : "Invalid");
    }
} 
