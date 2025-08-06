import java.io.*;
import java.util.*;

public class WordCounter {
    public static void main(String[] args) {
        String filename = "sample_text.txt";
        
        createSampleTextFile(filename);
        
        Map<String, Integer> wordCount = new HashMap<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.toLowerCase().split("\\s+");
                for (String word : words) {
                    word = word.replaceAll("[^a-zA-Z]", "");
                    if (!word.isEmpty()) {
                        wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                    }
                }
            }
            
            List<Map.Entry<String, Integer>> sortedWords = new ArrayList<>(wordCount.entrySet());
            sortedWords.sort((a, b) -> b.getValue().compareTo(a.getValue()));
            
            System.out.println("Top 5 most frequent words:");
            for (int i = 0; i < Math.min(5, sortedWords.size()); i++) {
                Map.Entry<String, Integer> entry = sortedWords.get(i);
                System.out.println((i + 1) + ". '" + entry.getKey() + "' - " + entry.getValue() + " times");
            }
            
            System.out.println("Total unique words: " + wordCount.size());
            
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
    
    private static void createSampleTextFile(String filename) {
        try (FileWriter fw = new FileWriter(filename)) {
            fw.write("The quick brown fox jumps over the lazy dog.\n");
            fw.write("A quick brown dog jumps over the lazy fox.\n");
            fw.write("The lazy fox sleeps while the quick brown dog runs.\n");
            fw.write("Quick brown foxes are faster than lazy dogs.\n");
            fw.write("The dog and fox are both animals in the forest.\n");
            fw.write("Quick animals like foxes and dogs are common.\n");
            fw.write("The forest is home to many animals including foxes and dogs.\n");
            fw.write("Lazy animals sleep while quick animals hunt.\n");
            fw.write("The quick brown fox is a clever animal.\n");
            fw.write("Dogs and foxes are both members of the canine family.\n");
            
        } catch (IOException e) {
            System.out.println("Error creating sample file: " + e.getMessage());
        }
    }
} 