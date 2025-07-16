import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderWordCount {
    public static void main(String[] args) {
        String filePath = "path/to/your/file.txt";
        String targetWord = "yourWord";
        int count = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    if (word.equals(targetWord)) {
                        count++;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("The word '" + targetWord + "' occurs " + count + " times.");
    }
}