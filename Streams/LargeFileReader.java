import java.io.*;

public class LargeFileReader {
    public static void main(String[] args) {
        String filename = "large_log.txt";
        
        createLargeLogFile(filename);
        
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            int lineNumber = 0;
            int errorCount = 0;
            
            while ((line = br.readLine()) != null) {
                lineNumber++;
                if (line.toLowerCase().contains("error")) {
                    System.out.println("Line " + lineNumber + ": " + line);
                    errorCount++;
                }
            }
            
            System.out.println("Total lines processed: " + lineNumber);
            System.out.println("Lines containing 'error': " + errorCount);
            
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
    
    private static void createLargeLogFile(String filename) {
        try (FileWriter fw = new FileWriter(filename)) {
            String[] logLevels = {"INFO", "WARNING", "ERROR", "DEBUG", "FATAL"};
            String[] messages = {
                "Application started successfully",
                "Database connection established",
                "User authentication failed",
                "File not found error occurred",
                "Memory allocation successful",
                "Network timeout error",
                "Configuration loaded",
                "Critical error in processing",
                "Backup completed",
                "System shutdown initiated"
            };
            
            for (int i = 0; i < 100000; i++) {
                String level = logLevels[i % logLevels.length];
                String message = messages[i % messages.length];
                fw.write("[" + level + "] " + message + " - Line " + (i + 1) + "\n");
            }
            
        } catch (IOException e) {
            System.out.println("Error creating test file: " + e.getMessage());
        }
    }
} 