
import java.util.regex.*;

public class ExtractEmails {
    public static void main(String[] args) {
        String text = "Contact us at support@example.com and info@company.org";
        Matcher m = Pattern.compile("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}").matcher(text);
        while (m.find()) {
            System.out.println(m.group());
        }
    }
}
