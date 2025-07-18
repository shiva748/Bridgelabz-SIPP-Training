import java.io.*;
public class FileReadComparison {
    public static void main(String[] args) throws Exception {
        String file = "largefile.txt";
        int[] sizes = {1024*1024, 100*1024*1024, 500*1024*1024};
        for (int size : sizes) {
            try (FileOutputStream fos = new FileOutputStream(file)) {
                byte[] buf = new byte[1024*1024];
                for (int i = 0; i < size / buf.length; i++) fos.write(buf);
            }
            long start = System.nanoTime();
            try (FileReader fr = new FileReader(file)) {
                while (fr.read() != -1) {}
            }
            long frTime = System.nanoTime() - start;
            start = System.nanoTime();
            try (InputStreamReader isr = new InputStreamReader(new FileInputStream(file))) {
                while (isr.read() != -1) {}
            }
            long isrTime = System.nanoTime() - start;
            System.out.println(size/1024/1024+"MB " + frTime/1e6 + "ms " + isrTime/1e6 + "ms");
            new File(file).delete();
        }
    }
} 