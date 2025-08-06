import java.io.*;

public class BufferedFileCopy {
    public static void main(String[] args) {
        String sourceFile = "largefile.txt";
        String destFile1 = "copy1.txt";
        String destFile2 = "copy2.txt";
        
        createLargeFile(sourceFile);
        
        long startTime = System.nanoTime();
        copyWithBufferedStreams(sourceFile, destFile1);
        long bufferedTime = System.nanoTime() - startTime;
        
        startTime = System.nanoTime();
        copyWithNormalStreams(sourceFile, destFile2);
        long normalTime = System.nanoTime() - startTime;
        
        System.out.println("Buffered streams time: " + bufferedTime + " nanoseconds");
        System.out.println("Normal streams time: " + normalTime + " nanoseconds");
        System.out.println("Performance improvement: " + ((double)normalTime/bufferedTime) + "x faster");
    }
    
    private static void createLargeFile(String filename) {
        try (FileWriter fw = new FileWriter(filename)) {
            for (int i = 0; i < 1000000; i++) {
                fw.write("This is line " + i + " of the large file for testing buffered streams performance.\n");
            }
        } catch (IOException e) {
            System.out.println("Error creating test file: " + e.getMessage());
        }
    }
    
    private static void copyWithBufferedStreams(String source, String dest) {
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(source));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(dest))) {
            
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            System.out.println("Error with buffered copy: " + e.getMessage());
        }
    }
    
    private static void copyWithNormalStreams(String source, String dest) {
        try (FileInputStream fis = new FileInputStream(source);
             FileOutputStream fos = new FileOutputStream(dest)) {
            
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            System.out.println("Error with normal copy: " + e.getMessage());
        }
    }
} 