import java.io.*;

public class FilterStreams {
    public static void main(String[] args) {
        String sourceFile = "uppercase.txt";
        String destFile = "lowercase.txt";
        
        createTestFile(sourceFile);
        
        try (BufferedReader br = new BufferedReader(new FileReader(sourceFile));
             BufferedWriter bw = new BufferedWriter(new FileWriter(destFile))) {
            
            String line;
            while ((line = br.readLine()) != null) {
                String lowercaseLine = line.toLowerCase();
                bw.write(lowercaseLine);
                bw.newLine();
            }
            
            System.out.println("File converted from uppercase to lowercase successfully!");
            
        } catch (IOException e) {
            System.out.println("Error processing file: " + e.getMessage());
        }
    }
    
    private static void createTestFile(String filename) {
        try (FileWriter fw = new FileWriter(filename)) {
            fw.write("THIS IS A TEST FILE WITH UPPERCASE TEXT.\n");
            fw.write("ANOTHER LINE WITH ALL CAPITAL LETTERS.\n");
            fw.write("MIXED CASE: Some Words Are Capitalized.\n");
        } catch (IOException e) {
            System.out.println("Error creating test file: " + e.getMessage());
        }
    }
} 