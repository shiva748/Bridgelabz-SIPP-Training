public class PalindromeChecker {
    String text;
    PalindromeChecker(String text) {
        this.text = text;
    }
    boolean isPalindrome() {
        int i = 0, j = text.length() - 1;
        while (i < j) {
            if (text.charAt(i) != text.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
    void displayResult() {
        System.out.println("Text: " + text);
        System.out.println("Palindrome: " + isPalindrome());
    }
    public static void main(String[] args) {
        PalindromeChecker pc = new PalindromeChecker("level");
        pc.displayResult();
    }
} 