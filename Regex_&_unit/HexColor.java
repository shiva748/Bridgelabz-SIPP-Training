
public class HexColor {
    public static void main(String[] args) {
        String color = "#FFA500";
        boolean valid = color.matches("^#[0-9A-Fa-f]{6}$");
        System.out.println(valid ? "Valid" : "Invalid");
    }
}
 