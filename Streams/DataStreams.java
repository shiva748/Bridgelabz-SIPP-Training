import java.io.*;

public class DataStreams {
    public static void main(String[] args) {
        String filename = "students.dat";
        
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(filename))) {
            dos.writeInt(101);
            dos.writeUTF("Alice Johnson");
            dos.writeDouble(3.85);
            
            dos.writeInt(102);
            dos.writeUTF("Bob Smith");
            dos.writeDouble(3.92);
            
            dos.writeInt(103);
            dos.writeUTF("Carol Davis");
            dos.writeDouble(3.78);
            
            System.out.println("Student data written successfully!");
            
        } catch (IOException e) {
            System.out.println("Error writing data: " + e.getMessage());
        }
        
        try (DataInputStream dis = new DataInputStream(new FileInputStream(filename))) {
            System.out.println("Retrieved student data:");
            
            while (dis.available() > 0) {
                int rollNumber = dis.readInt();
                String name = dis.readUTF();
                double gpa = dis.readDouble();
                
                System.out.println("Roll Number: " + rollNumber);
                System.out.println("Name: " + name);
                System.out.println("GPA: " + gpa);
                System.out.println("---");
            }
            
        } catch (IOException e) {
            System.out.println("Error reading data: " + e.getMessage());
        }
    }
} 