import java.io.*;

public class UserInputToFile {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             FileWriter fw = new FileWriter("user_info.txt")) {
            
            System.out.print("Enter your name: ");
            String name = br.readLine();
            
            System.out.print("Enter your age: ");
            String age = br.readLine();
            
            System.out.print("Enter your favorite programming language: ");
            String language = br.readLine();
            
            fw.write("Name: " + name + "\n");
            fw.write("Age: " + age + "\n");
            fw.write("Favorite Programming Language: " + language + "\n");
            
            System.out.println("Information saved to user_info.txt successfully!");
            
        } catch (IOException e) {
            System.out.println("Error reading input or writing to file: " + e.getMessage());
        }
    }
} 