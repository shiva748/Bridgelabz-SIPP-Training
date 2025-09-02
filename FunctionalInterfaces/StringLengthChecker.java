import java.util.function.Function;

public class StringLengthChecker {
    public static void main(String[] args) {
        // Using Function functional interface to check string length
        Function<String, Integer> stringLengthChecker = str -> str.length();

        String[] messages = {
                "Hello",
                "This is a longer message",
                "Short",
                "This message exceeds the character limit significantly"
        };

        int characterLimit = 20;

        System.out.println("String Length Checker:");
        for (String message : messages) {
            int length = stringLengthChecker.apply(message);
            if (length > characterLimit) {
                System.out.println(
                        "WARNING: Message '" + message + "' exceeds limit (" + length + " > " + characterLimit + ")");
            } else {
                System.out.println(
                        "OK: Message '" + message + "' is within limit (" + length + " <= " + characterLimit + ")");
            }
        }
    }
}
