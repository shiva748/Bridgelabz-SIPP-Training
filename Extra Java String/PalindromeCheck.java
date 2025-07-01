
public class PalindromeCheck {

    public static void main(String[] args) {
        String input = "madam";
        boolean isPalindrome = true;
        int n = input.length();
        for (int i = 0; i < n / 2; i++) {
            if (input.charAt(i) != input.charAt(n - i - 1)) {
                isPalindrome = false;
                break;
            }
        }
        if (isPalindrome) {
            System.out.println(input + " is a palindrome"); 
        }else {
            System.out.println(input + " is not a palindrome");
        }
    }
}
