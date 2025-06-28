import java.util.ArrayList;
public class School {
    String name;
    ArrayList<Student> students;
    School(String name) {
        this.name = name;
        this.students = new ArrayList<>();
    }
    void addStudent(Student student) {
        students.add(student);
    }
    void displayStudents() {
        System.out.println("School: " + name);
        for (Student student : students) {
            System.out.println("Student: " + student.name);
            student.displayCourses();
        }
    }
    public static void main(String[] args) {
        School school = new School("ABC School");
        Student s1 = new Student("John");
        Student s2 = new Student("Alice");
        Course c1 = new Course("Math");
        Course c2 = new Course("Science");
        s1.enrollCourse(c1);
        s1.enrollCourse(c2);
        s2.enrollCourse(c1);
        school.addStudent(s1);
        school.addStudent(s2);
        school.displayStudents();
        c1.displayStudents();
        c2.displayStudents();
    }
}
class Student {
    String name;
    ArrayList<Course> courses;
    Student(String name) {
        this.name = name;
        this.courses = new ArrayList<>();
    }
    void enrollCourse(Course course) {
        courses.add(course);
        course.addStudent(this);
    }
    void displayCourses() {
        System.out.println("  Courses:");
        for (Course course : courses) {
            System.out.println("    " + course.name);
        }
    }
}
class Course {
    String name;
    ArrayList<Student> students;
    Course(String name) {
        this.name = name;
        this.students = new ArrayList<>();
    }
    void addStudent(Student student) {
        students.add(student);
    }
    void displayStudents() {
        System.out.println("Course: " + name);
        for (Student student : students) {
            System.out.println("  Student: " + student.name);
        }
    }
} 