
import java.util.*;
import java.util.regex.*;

public class RepeatingWords {
    public static void main(String[] args) {
        String text = "This is is a repeated repeated word test.";
        Matcher m = Pattern.compile("\\b(\\w+)\\b\\s+\\1", Pattern.CASE_INSENSITIVE).matcher(text);
        Set<String> repeats = new LinkedHashSet<>();
        while (m.find()) {
            repeats.add(m.group(1));
        }
        repeats.forEach(System.out::println);
    }
} 
