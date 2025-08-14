
public class CreditCard {
    public static void main(String[] args) {
        String card = "4111111111111111";
        boolean valid = card.matches("^4\\d{15}$") || card.matches("^5\\d{15}$");
        System.out.println(valid ? "Valid" : "Invalid");
    }
}
