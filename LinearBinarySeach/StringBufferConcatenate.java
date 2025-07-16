import java.util.Arrays;

public class StringBufferConcatenate {
    public static void main(String[] args) {
        String[] strings = {"Hello", " ", "World", "!", " ", "This", " ", "is", " ", "Java"};
        StringBuffer stringBuffer = new StringBuffer();
        
        for (String str : strings) {
            stringBuffer.append(str);
        }
        
        String result = stringBuffer.toString();
        System.out.println(result);
    }
}