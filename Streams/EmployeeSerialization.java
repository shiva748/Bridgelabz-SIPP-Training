import java.io.*;
import java.util.*;

public class EmployeeSerialization {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "John Doe", "Engineering", 75000.0));
        employees.add(new Employee(2, "Jane Smith", "Marketing", 65000.0));
        employees.add(new Employee(3, "Bob Johnson", "HR", 55000.0));
        
        String filename = "employees.dat";
        
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(employees);
            System.out.println("Employees serialized successfully!");
        } catch (IOException e) {
            System.out.println("Error serializing employees: " + e.getMessage());
        }
        
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            @SuppressWarnings("unchecked")
            List<Employee> retrievedEmployees = (List<Employee>) ois.readObject();
            System.out.println("Retrieved employees:");
            for (Employee emp : retrievedEmployees) {
                System.out.println(emp);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Error deserializing: " + e.getMessage());
        }
    }
} 