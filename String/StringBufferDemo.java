public class StringBufferDemo {
    public static void main(String[] args) {
        StringBuffer buffer = new StringBuffer("Hello");
        
        System.out.println("Original: " + buffer);
        
        buffer.append(" World");
        System.out.println("After append: " + buffer);
        
        buffer.insert(5, " Beautiful");
        System.out.println("After insert: " + buffer);
        
        buffer.replace(6, 15, "Amazing");
        System.out.println("After replace: " + buffer);
        
        buffer.delete(6, 13);
        System.out.println("After delete: " + buffer);
        
        buffer.reverse();
        System.out.println("After reverse: " + buffer);
        
        System.out.println("Capacity: " + buffer.capacity());
        System.out.println("Length: " + buffer.length());
        
        buffer.setCharAt(0, 'h');
        System.out.println("After setCharAt: " + buffer);
        
        System.out.println("Substring(0,5): " + buffer.substring(0, 5));
    }
}
