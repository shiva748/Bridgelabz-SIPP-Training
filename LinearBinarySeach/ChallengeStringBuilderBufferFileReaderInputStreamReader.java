import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.HashSet;

public class ChallengeStringBuilderBufferFileReaderInputStreamReader {
    public static void main(String[] args) {
        long startTime, endTime;

        String[] strings = new String[1000000];
        for (int i = 0; i < strings.length; i++) {
            strings[i] = "hello";
        }

        StringBuilder stringBuilder = new StringBuilder();
        startTime = System.nanoTime();
        for (String str : strings) {
            stringBuilder.append(str);
        }
        endTime = System.nanoTime();
        System.out.println("StringBuilder time: " + (endTime - startTime) + " ns");

        StringBuffer stringBuffer = new StringBuffer();
        startTime = System.nanoTime();
        for (String str : strings) {
            stringBuffer.append(str);
        }
        endTime = System.nanoTime();
        System.out.println("StringBuffer time: " + (endTime - startTime) + " ns");

        try (BufferedReader fileReader = new BufferedReader(new FileReader("largefile.txt"))) {
            String line;
            int wordCount = 0;
            while ((line = fileReader.readLine()) != null) {
                String[] words = line.split("\\s+");
                wordCount += words.length;
            }
            System.out.println("Word count: " + wordCount);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (InputStreamReader inputStreamReader = new InputStreamReader(System.in);
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
             PrintWriter writer = new PrintWriter(new FileWriter("userinput.txt"))) {
            String userInput;
            System.out.println("Enter text (type 'exit' to quit):");
            while (!(userInput = bufferedReader.readLine()).equals("exit")) {
                writer.println(userInput);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}