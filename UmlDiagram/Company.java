import java.util.ArrayList;
public class Company {
    String name;
    ArrayList<Department> departments;
    Company(String name) {
        this.name = name;
        this.departments = new ArrayList<>();
    }
    void addDepartment(String deptName) {
        departments.add(new Department(deptName));
    }
    void addEmployee(String deptName, String empName) {
        for (Department dept : departments) {
            if (dept.name.equals(deptName)) {
                dept.addEmployee(empName);
                break;
            }
        }
    }
    void displayStructure() {
        System.out.println("Company: " + name);
        for (Department dept : departments) {
            System.out.println("Department: " + dept.name);
            dept.displayEmployees();
        }
    }
    public static void main(String[] args) {
        Company company = new Company("Tech Corp");
        company.addDepartment("IT");
        company.addDepartment("HR");
        company.addEmployee("IT", "John");
        company.addEmployee("IT", "Alice");
        company.addEmployee("HR", "Bob");
        company.displayStructure();
    }
}
class Department {
    String name;
    ArrayList<Employee> employees;
    Department(String name) {
        this.name = name;
        this.employees = new ArrayList<>();
    }
    void addEmployee(String empName) {
        employees.add(new Employee(empName));
    }
    void displayEmployees() {
        for (Employee emp : employees) {
            System.out.println("  Employee: " + emp.name);
        }
    }
}
class Employee {
    String name;
    Employee(String name) {
        this.name = name;
    }
} 