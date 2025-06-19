import java.util.Scanner;

public class WordSplitComparator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = scanner.nextLine();
        
        String[] customSplit = splitText(text);
        String[] builtInSplit = text.split(" ");
        
        boolean areEqual = compareArrays(customSplit, builtInSplit);
        
        displayResults(customSplit, builtInSplit, areEqual);
        scanner.close();
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
    
    static String[] splitText(String text) {
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
    
    static boolean compareArrays(String[] arr1, String[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }
        
        for (int i = 0; i < arr1.length; i++) {
            if (!arr1[i].equals(arr2[i])) {
                return false;
            }
        }
        return true;
    }
    
    static void displayResults(String[] customSplit, String[] builtInSplit, boolean areEqual) {
        System.out.println("\nCustom split result:");
        for (String word : customSplit) {
            System.out.println(word);
        }
        
        System.out.println("\nBuilt-in split result:");
        for (String word : builtInSplit) {
            System.out.println(word);
        }
        
        System.out.println("\nResults match: " + areEqual);
    }
}
