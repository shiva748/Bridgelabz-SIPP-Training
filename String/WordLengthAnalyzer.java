import java.util.Scanner;

public class WordLengthAnalyzer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = scanner.nextLine();
        
        String[] words = splitIntoWords(text);
        String[][] analysis = analyzeWords(words);
        
        displayResults(analysis);
        scanner.close();
    }
    
    static String[] splitIntoWords(String text) {
        StringBuilder currentWord = new StringBuilder();
        int wordCount = 0;
        
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ') {
                if (currentWord.length() > 0) {
                    wordCount++;
                }
                currentWord.setLength(0);
            } else {
                currentWord.append(text.charAt(i));
            }
        }
        if (currentWord.length() > 0) {
            wordCount++;
        }
        
        String[] words = new String[wordCount];
        currentWord.setLength(0);
        int wordIndex = 0;
        
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ') {
                if (currentWord.length() > 0) {
                    words[wordIndex++] = currentWord.toString();
                    currentWord.setLength(0);
                }
            } else {
                currentWord.append(text.charAt(i));
            }
        }
        if (currentWord.length() > 0) {
            words[wordIndex] = currentWord.toString();
        }
        
        return words;
    }
    
    static int findLength(String str) {
        int length = 0;
        for (int i = 0; ; i++) {
            try {
                str.charAt(i);
                length++;
            } catch (IndexOutOfBoundsException e) {
                break;
            }
        }
        return length;
    }
    
    static String[][] analyzeWords(String[] words) {
        String[][] result = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            result[i][0] = words[i];
            result[i][1] = String.valueOf(findLength(words[i]));
        }
        return result;
    }
    
    static void displayResults(String[][] analysis) {
        System.out.println("\nWord Analysis:");
        System.out.println("Word | Length");
        System.out.println("-----|--------");
        for (String[] row : analysis) {
            System.out.printf("%-5s| %s%n", row[0], row[1]);
        }
    }
}
