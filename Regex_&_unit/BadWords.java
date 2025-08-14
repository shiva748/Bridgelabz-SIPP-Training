
import java.util.*;

public class BadWords {
    public static void main(String[] args) {
        String text = "This is a damn bad example with some stupid words.";
        List<String> badWords = Arrays.asList("damn", "stupid");
        for (String bad : badWords) {
            text = text.replaceAll("(?i)\\b" + bad + "\\b", "****");
        }
        System.out.println(text);
    }
}
