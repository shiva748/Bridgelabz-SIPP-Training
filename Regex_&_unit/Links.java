
import java.util.regex.*;

public class Links {
    public static void main(String[] args) {
        String text = "Visit https://www.google.com and http://example.org for more info.";
        Matcher m = Pattern.compile("https?://[\\w.-]+(?:\\.[\\w\\.-]+)+[/\\w\\-._~:/?#[\\]@!$&'()*+,;=.]*").matcher(text);
        while (m.find()) {
            System.out.println(m.group());
        }
    }
}
 