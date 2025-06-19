public class StringConcatenationDemo {
    public static void main(String[] args) {
        String str1 = "Hello";
        String str2 = "World";
        
        String concatenated1 = str1 + " " + str2;
        System.out.println("Using + operator: " + concatenated1);
        
        String concatenated2 = str1.concat(" ").concat(str2);
        System.out.println("Using concat(): " + concatenated2);
        
        StringBuilder sb = new StringBuilder(str1);
        sb.append(" ").append(str2);
        System.out.println("Using StringBuilder: " + sb.toString());
        
        StringBuffer sbuf = new StringBuffer(str1);
        sbuf.append(" ").append(str2);
        System.out.println("Using StringBuffer: " + sbuf.toString());
        
        String formatted = String.format("%s %s", str1, str2);
        System.out.println("Using String.format(): " + formatted);
        
        String joined = String.join(" ", str1, str2);
        System.out.println("Using String.join(): " + joined);
    }
}
