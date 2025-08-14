
public class MultipleSpaces {
    public static void main(String[] args) {
        String text = "This   is   an   example    with   multiple   spaces.";
        String result = text.replaceAll("\\s+", " ");
        System.out.println(result);
    }
}
 