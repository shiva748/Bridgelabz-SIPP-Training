import java.util.Arrays;

public class LinearSearchWordInSentences {
    public static void main(String[] args) {
        String[] sentences = {
            "The quick brown fox jumps over the lazy dog.",
            "Hello world, this is a test sentence.",
            "Java is a programming language.",
            "Linear search is simple and effective."
        };
        String targetWord = "test";
        String result = findSentenceContainingWord(sentences, targetWord);
        System.out.println(result);
    }

    public static String findSentenceContainingWord(String[] sentences, String targetWord) {
        for (String sentence : sentences) {
            if (sentence.contains(targetWord)) {
                return sentence;
            }
        }
        return "Not Found";
    }
}