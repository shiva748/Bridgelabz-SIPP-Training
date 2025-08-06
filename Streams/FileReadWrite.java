import java.io.*;

public class FileReadWrite {
    public static void main(String[] args) {
        String sourceFile = "source.txt";
        String destinationFile = "destination.txt";
        
        try {
            FileInputStream fis = new FileInputStream(sourceFile);
            FileOutputStream fos = new FileOutputStream(destinationFile);
            
            int data;
            while ((data = fis.read()) != -1) {
                fos.write(data);
            }
            
            fis.close();
            fos.close();
            System.out.println("File copied successfully!");
            
        } catch (FileNotFoundException e) {
            System.out.println("Source file does not exist: " + sourceFile);
        } catch (IOException e) {
            System.out.println("Error reading or writing file: " + e.getMessage());
        }
    }
} 