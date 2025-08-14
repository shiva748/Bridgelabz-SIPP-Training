
public class IPAddress {
    public static void main(String[] args) {
        String ip = "192.168.0.1";
        boolean valid = ip.matches(
            "^(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)\\." +
            "(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)\\." +
            "(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)\\." +
            "(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)$"
        );
        System.out.println(valid ? "Valid" : "Invalid");
    }
} 
