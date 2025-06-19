import java.util.Scanner;

public class StringLengthExtremes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = scanner.nextLine();
        
        String[] words = splitIntoWords(text);
        String[][] wordAnalysis = analyzeWordLengths(words);
        int[] extremes = findExtremes(wordAnalysis);
        
        displayResults(wordAnalysis, extremes);
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
    
    static String[][] analyzeWordLengths(String[] words) {
        String[][] analysis = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            analysis[i][0] = words[i];
            analysis[i][1] = String.valueOf(words[i].length());
        }
        return analysis;
    }
    
    static int[] findExtremes(String[][] wordAnalysis) {
        if (wordAnalysis.length == 0) {
            return new int[]{-1, -1};
        }
        
        int shortest = 0;
        int longest = 0;
        
        for (int i = 1; i < wordAnalysis.length; i++) {
            int currentLength = Integer.parseInt(wordAnalysis[i][1]);
            int shortestLength = Integer.parseInt(wordAnalysis[shortest][1]);
            int longestLength = Integer.parseInt(wordAnalysis[longest][1]);
            
            if (currentLength < shortestLength) {
                shortest = i;
            }
            if (currentLength > longestLength) {
                longest = i;
            }
        }
        
        return new int[]{shortest, longest};
    }
    
    static void displayResults(String[][] analysis, int[] extremes) {
        System.out.println("\nWord Length Analysis:");
        System.out.println("Word | Length");
        System.out.println("-----|--------");
        for (String[] word : analysis) {
            System.out.printf("%-5s| %s%n", word[0], word[1]);
        }
        
        if (extremes[0] != -1 && extremes[1] != -1) {
            System.out.println("\nExtremes:");
            System.out.println("Shortest word: " + analysis[extremes[0]][0] + 
                             " (length: " + analysis[extremes[0]][1] + ")");
            System.out.println("Longest word: " + analysis[extremes[1]][0] + 
                             " (length: " + analysis[extremes[1]][1] + ")");
        }
    }
}
