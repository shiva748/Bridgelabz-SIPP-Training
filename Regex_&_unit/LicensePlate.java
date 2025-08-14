
public class LicensePlate {
    public static void main(String[] args) {
        String plate = "AB1234";
        boolean valid = plate.matches("^[A-Z]{2}\\d{4}$");
        System.out.println(valid ? "Valid" : "Invalid");
    }
}
 