import java.util.Random;

public class StringBufferVsStringBuilder {
    public static void main(String[] args) {
        int iterations = 1000000;
        StringBuilder stringBuilder = new StringBuilder();
        StringBuffer stringBuffer = new StringBuffer();
        String str = "hello";

        long startTime = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            stringBuilder.append(str);
        }
        long endTime = System.nanoTime();
        long stringBuilderTime = endTime - startTime;

        startTime = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            stringBuffer.append(str);
        }
        endTime = System.nanoTime();
        long stringBufferTime = endTime - startTime;

        System.out.println("StringBuilder time: " + stringBuilderTime + " ns");
        System.out.println("StringBuffer time: " + stringBufferTime + " ns");
    }
}