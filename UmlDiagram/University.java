import java.util.ArrayList;
public class University {
    String name;
    ArrayList<Department> departments;
    ArrayList<Faculty> faculties;
    University(String name) {
        this.name = name;
        this.departments = new ArrayList<>();
        this.faculties = new ArrayList<>();
    }
    void addDepartment(String deptName) {
        departments.add(new Department(deptName));
    }
    void addFaculty(Faculty faculty) {
        faculties.add(faculty);
    }
    void displayStructure() {
        System.out.println("University: " + name);
        System.out.println("Departments:");
        for (Department dept : departments) {
            System.out.println("  " + dept.name);
        }
        System.out.println("Faculties:");
        for (Faculty faculty : faculties) {
            System.out.println("  " + faculty.name);
        }
    }
    public static void main(String[] args) {
        University uni = new University("ABC University");
        uni.addDepartment("Computer Science");
        uni.addDepartment("Mathematics");
        Faculty f1 = new Faculty("Dr. Smith");
        Faculty f2 = new Faculty("Dr. Johnson");
        uni.addFaculty(f1);
        uni.addFaculty(f2);
        uni.displayStructure();
        f1.displayInfo();
        f2.displayInfo();
    }
}
class Department {
    String name;
    Department(String name) {
        this.name = name;
    }
}
class Faculty {
    String name;
    Faculty(String name) {
        this.name = name;
    }
    void displayInfo() {
        System.out.println("Faculty: " + name + " (can exist independently)");
    }
} 