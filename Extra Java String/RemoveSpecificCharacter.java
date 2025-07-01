
public class RemoveSpecificCharacter {

    public static void main(String[] args) {
        String input = "Hello World";
        char toRemove = 'l';
        StringBuilder result = new StringBuilder();
        for (char ch : input.toCharArray()) {
            if (ch != toRemove) {
                result.append(ch);
            }
        }
        System.out.println("Modified String: " + result.toString());
    }
}
