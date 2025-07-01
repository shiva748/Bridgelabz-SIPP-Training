
public class ReplaceWord {

    public static void main(String[] args) {
        String sentence = "Java is fun. Java is powerful.";
        String toReplace = "Java";
        String replacement = "Python";
        String result = "";
        int i = 0;
        while (i <= sentence.length() - toReplace.length()) {
            if (sentence.substring(i, i + toReplace.length()).equals(toReplace)) {
                result += replacement;
                i += toReplace.length();
            } else {
                result += sentence.charAt(i);
                i++;
            }
        }
        result += sentence.substring(i);
        System.out.println("Modified Sentence: " + result);
    }
}
