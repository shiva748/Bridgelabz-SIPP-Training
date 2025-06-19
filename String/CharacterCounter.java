import java.util.Scanner;

public class CharacterCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = scanner.nextLine();
        
        int[] counts = countCharacterTypes(text);
        
        System.out.println("\nCharacter Analysis:");
        System.out.println("Vowels: " + counts[0]);
        System.out.println("Consonants: " + counts[1]);
        
        scanner.close();
    }
    
    static String checkCharacterType(char ch) {
        ch = (char)(ch >= 'A' && ch <= 'Z' ? ch + 32 : ch);
        
        if (ch >= 'a' && ch <= 'z') {
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                return "Vowel";
            }
            return "Consonant";
        }
        return "Not a Letter";
    }
    
    static int[] countCharacterTypes(String text) {
        int vowels = 0;
        int consonants = 0;
        
        for (int i = 0; i < text.length(); i++) {
            String type = checkCharacterType(text.charAt(i));
            if (type.equals("Vowel")) {
                vowels++;
            } else if (type.equals("Consonant")) {
                consonants++;
            }
        }
        
        return new int[]{vowels, consonants};
    }
}
