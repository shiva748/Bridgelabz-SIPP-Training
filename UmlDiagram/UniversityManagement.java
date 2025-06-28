import java.util.ArrayList;
public class UniversityManagement {
    String name;
    ArrayList<Student> students;
    ArrayList<Professor> professors;
    ArrayList<Course> courses;
    UniversityManagement(String name) {
        this.name = name;
        this.students = new ArrayList<>();
        this.professors = new ArrayList<>();
        this.courses = new ArrayList<>();
    }
    void addStudent(Student student) {
        students.add(student);
    }
    void addProfessor(Professor professor) {
        professors.add(professor);
    }
    void addCourse(Course course) {
        courses.add(course);
    }
    void displayInfo() {
        System.out.println("University: " + name);
        System.out.println("Students:");
        for (Student student : students) {
            System.out.println("  " + student.name);
            student.displayCourses();
        }
        System.out.println("Professors:");
        for (Professor professor : professors) {
            System.out.println("  " + professor.name);
            professor.displayCourses();
        }
    }
    public static void main(String[] args) {
        UniversityManagement uni = new UniversityManagement("ABC University");
        Student s1 = new Student("John");
        Student s2 = new Student("Alice");
        Professor p1 = new Professor("Dr. Smith");
        Professor p2 = new Professor("Dr. Johnson");
        Course c1 = new Course("Java Programming");
        Course c2 = new Course("Data Structures");
        uni.addStudent(s1);
        uni.addStudent(s2);
        uni.addProfessor(p1);
        uni.addProfessor(p2);
        uni.addCourse(c1);
        uni.addCourse(c2);
        s1.enrollCourse(c1);
        s1.enrollCourse(c2);
        s2.enrollCourse(c1);
        c1.assignProfessor(p1);
        c2.assignProfessor(p2);
        uni.displayInfo();
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
        System.out.println(name + " enrolled in " + course.name);
    }
    void displayCourses() {
        System.out.println("    Courses:");
        for (Course course : courses) {
            System.out.println("      " + course.name);
        }
    }
}
class Professor {
    String name;
    ArrayList<Course> courses;
    Professor(String name) {
        this.name = name;
        this.courses = new ArrayList<>();
    }
    void displayCourses() {
        System.out.println("    Teaching:");
        for (Course course : courses) {
            System.out.println("      " + course.name);
        }
    }
}
class Course {
    String name;
    ArrayList<Student> students;
    Professor professor;
    Course(String name) {
        this.name = name;
        this.students = new ArrayList<>();
    }
    void addStudent(Student student) {
        students.add(student);
    }
    void assignProfessor(Professor professor) {
        this.professor = professor;
        professor.courses.add(this);
        System.out.println(professor.name + " assigned to " + name);
    }
} 