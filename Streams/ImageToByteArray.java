import java.io.*;

public class ImageToByteArray {
    public static void main(String[] args) {
        String sourceImage = "source.jpg";
        String destImage = "copy.jpg";
        
        try {
            byte[] imageBytes = imageToByteArray(sourceImage);
            byteArrayToImage(imageBytes, destImage);
            System.out.println("Image converted to byte array and back successfully!");
            
            if (filesAreIdentical(sourceImage, destImage)) {
                System.out.println("Verification: Files are identical!");
            } else {
                System.out.println("Verification: Files are different!");
            }
            
        } catch (IOException e) {
            System.out.println("Error processing image: " + e.getMessage());
        }
    }
    
    private static byte[] imageToByteArray(String filename) throws IOException {
        try (FileInputStream fis = new FileInputStream(filename);
             ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }
            return baos.toByteArray();
        }
    }
    
    private static void byteArrayToImage(byte[] imageBytes, String filename) throws IOException {
        try (ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes);
             FileOutputStream fos = new FileOutputStream(filename)) {
            
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = bais.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
        }
    }
    
    private static boolean filesAreIdentical(String file1, String file2) throws IOException {
        try (FileInputStream fis1 = new FileInputStream(file1);
             FileInputStream fis2 = new FileInputStream(file2)) {
            
            int byte1, byte2;
            while ((byte1 = fis1.read()) != -1) {
                byte2 = fis2.read();
                if (byte1 != byte2) {
                    return false;
                }
            }
            return fis2.read() == -1;
        }
    }
} 