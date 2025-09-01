import java.util.*;
import java.util.stream.Collectors;

public class WordFrequencyCounter {
    public static void main(String[] args) {
        String paragraph = "This is a test. This test is only a test.";
        Map<String, Long> wordCount = Arrays.stream(paragraph.split("\\W+"))
                .collect(Collectors.groupingBy(String::toLowerCase, Collectors.counting()));

        System.out.println(wordCount);
    }
}
