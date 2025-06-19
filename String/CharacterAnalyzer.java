import java.util.Scanner;

public class CharacterAnalyzer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = scanner.nextLine();
        
        String[][] analysis = analyzeCharacters(text);
        displayResults(analysis);
        
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
    
    static String[][] analyzeCharacters(String text) {
        String[][] result = new String[text.length()][2];
        for (int i = 0; i < text.length(); i++) {
            result[i][0] = String.valueOf(text.charAt(i));
            result[i][1] = checkCharacterType(text.charAt(i));
        }
        return result;
    }
    
    static void displayResults(String[][] analysis) {
        System.out.println("\nCharacter Analysis:");
        System.out.println("Character | Type");
        System.out.println("----------|-------");
        for (String[] row : analysis) {
            System.out.printf("%-10s| %s%n", row[0], row[1]);
        }
    }
}
