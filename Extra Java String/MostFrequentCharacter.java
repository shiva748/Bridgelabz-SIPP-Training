
public class MostFrequentCharacter {

    public static void main(String[] args) {
        String input = "success";
        int[] freq = new int[256];
        for (char ch : input.toCharArray()) {
            freq[ch]++;
        }
        int max = 0;
        char result = ' ';
        for (char ch : input.toCharArray()) {
            if (freq[ch] > max) {
                max = freq[ch];
                result = ch;
            }
        }
        System.out.println("Most Frequent Character: '" + result + "'");
    }
}
