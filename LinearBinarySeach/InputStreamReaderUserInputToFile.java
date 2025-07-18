import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputStreamReaderUserInputToFile {
    public static void main(String[] args) {
        try (InputStreamReader isr = new InputStreamReader(System.in);
             BufferedReader br = new BufferedReader(isr);
             FileWriter writer = new FileWriter("user_input.txt", true)) {
             
            String input;
            System.out.println("Enter text (type 'exit' to quit):");
            while (!(input = br.readLine()).equalsIgnoreCase("exit")) {
                writer.write(input + System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}