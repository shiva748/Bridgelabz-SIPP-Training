import java.io.*;

public class PipedStreams {
    public static void main(String[] args) {
        try {
            PipedInputStream pis = new PipedInputStream();
            PipedOutputStream pos = new PipedOutputStream(pis);
            
            Thread writerThread = new Thread(() -> {
                try (PipedOutputStream writer = pos) {
                    String[] messages = {"Hello", "World", "from", "PipedStreams", "!"};
                    for (String message : messages) {
                        writer.write(message.getBytes());
                        writer.write('\n');
                        Thread.sleep(500);
                    }
                } catch (IOException | InterruptedException e) {
                    System.out.println("Writer thread error: " + e.getMessage());
                }
            });
            
            Thread readerThread = new Thread(() -> {
                try (PipedInputStream reader = pis) {
                    BufferedReader br = new BufferedReader(new InputStreamReader(reader));
                    String line;
                    while ((line = br.readLine()) != null) {
                        System.out.println("Received: " + line);
                    }
                } catch (IOException e) {
                    System.out.println("Reader thread error: " + e.getMessage());
                }
            });
            
            writerThread.start();
            readerThread.start();
            
            writerThread.join();
            readerThread.join();
            
        } catch (IOException | InterruptedException e) {
            System.out.println("Error in main thread: " + e.getMessage());
        }
    }
} 