public class University {
    public static void main(String[] args) {
        Course cs101 = new Course("Computer Science", "CS101");
        Course math101 = new Course("Mathematics", "MATH101");
        Course physics101 = new Course("Physics", "PHY101");
        
        Faculty profSmith = new Faculty("Dr. Smith", "Computer Science");
        Faculty profJohnson = new Faculty("Dr. Johnson", "Mathematics");
        
        Student alice = new Undergraduate("Alice", 1, "Computer Science");
        Student bob = new Postgraduate("Bob", 2, "Mathematics");
        Student charlie = new Undergraduate("Charlie", 3, "Physics");
        
        Enrollment e1 = new Enrollment(alice, cs101);
        Enrollment e2 = new Enrollment(bob, math101);
        Enrollment e3 = new Enrollment(charlie, physics101);
        
        profSmith.assignGrade(e1, 85);
        profJohnson.assignGrade(e2, 92);
        profSmith.assignGrade(e3, 78);
        
        System.out.println("Student: " + e1.getStudent().getName() + ", Student Id: " + e1.getStudent().getId() + 
                           ", Enrolled Course: " + e1.getCourse().getTitle() + 
                           ", GPA: " + e1.getStudent().getGPA());
        System.out.println("Student: " + e2.getStudent().getName() + ", Student Id: " + e2.getStudent().getId() + 
                           ", Enrolled Course: " + e2.getCourse().getTitle() + 
                           ", GPA: " + e2.getStudent().getGPA());
        System.out.println("Student: " + e3.getStudent().getName() + ", Student Id: " + e3.getStudent().getId() + 
                           ", Enrolled Course: " + e3.getCourse().getTitle() + 
                           ", GPA: " + e3.getStudent().getGPA());
    }
}

interface Graded {
    void assignGrade(Enrollment enrollment, int score);
}

class Student {
    private String name;
    private int id;
    private String major;
    private double gpa;
    private int totalCredits;
    private double totalGradePoints;
    
    Student(String name, int id, String major) {
        this.name = name;
        this.id = id;
        this.major = major;
        this.gpa = 0.0;
        this.totalCredits = 0;
        this.totalGradePoints = 0.0;
    }
    
    Student(String name, int id) {
        this.name = name;
        this.id = id;
        this.major = "Undeclared";
        this.gpa = 0.0;
        this.totalCredits = 0;
        this.totalGradePoints = 0.0;
    }
    
    String getName() {
        return name;
    }
    
    int getId() {
        return id;
    }
    
    String getMajor() {
        return major;
    }
    
    double getGPA() {
        return gpa;
    }
    
    void updateGPA(int grade, int credits) {
        totalGradePoints = totalGradePoints + (grade * credits);
        totalCredits = totalCredits + credits;
        gpa = totalGradePoints / totalCredits;
    }
}

class Undergraduate extends Student {
    private String electivePreference;
    
    Undergraduate(String name, int id, String major) {
        super(name, id, major);
        this.electivePreference = "General";
    }
    
    Undergraduate(String name, int id, String major, String electivePreference) {
        super(name, id, major);
        this.electivePreference = electivePreference;
    }
    
    String getElectivePreference() {
        return electivePreference;
    }
}

class Postgraduate extends Student {
    private String researchArea;
    
    Postgraduate(String name, int id, String major) {
        super(name, id, major);
        this.researchArea = "General Research";
    }
    
    Postgraduate(String name, int id, String major, String researchArea) {
        super(name, id, major);
        this.researchArea = researchArea;
    }
    
    String getResearchArea() {
        return researchArea;
    }
}

class Course {
    private String title;
    private String code;
    private int credits;
    
    Course(String title, String code) {
        this.title = title;
        this.code = code;
        this.credits = 3;
    }
    
    Course(String title, String code, int credits) {
        this.title = title;
        this.code = code;
        this.credits = credits;
    }
    
    String getTitle() {
        return title;
    }
    
    String getCode() {
        return code;
    }
    
    int getCredits() {
        return credits;
    }
}

class Faculty implements Graded {
    private String name;
    private String department;
    
    Faculty(String name, String department) {
        this.name = name;
        this.department = department;
    }
    
    String getName() {
        return name;
    }
    
    String getDepartment() {
        return department;
    }
    
    public void assignGrade(Enrollment enrollment, int score) {
        if (enrollment.getStudent() instanceof Undergraduate) {
            if (score >= 60) {
                enrollment.setGrade("P");
                enrollment.setGradePoints(4.0);
            } else {
                enrollment.setGrade("F");
                enrollment.setGradePoints(0.0);
            }
        } else {
            if (score >= 90) {
                enrollment.setGrade("A");
                enrollment.setGradePoints(4.0);
            } else if (score >= 80) {
                enrollment.setGrade("B");
                enrollment.setGradePoints(3.0);
            } else if (score >= 70) {
                enrollment.setGrade("C");
                enrollment.setGradePoints(2.0);
            } else if (score >= 60) {
                enrollment.setGrade("D");
                enrollment.setGradePoints(1.0);
            } else {
                enrollment.setGrade("F");
                enrollment.setGradePoints(0.0);
            }
        }
        enrollment.getStudent().updateGPA((int)enrollment.getGradePoints(), enrollment.getCourse().getCredits());
    }
}

class Enrollment {
    private Student student;
    private Course course;
    private String grade;
    private double gradePoints;
    
    Enrollment(Student student, Course course) {
        this.student = student;
        this.course = course;
        this.grade = "Not Graded";
        this.gradePoints = 0.0;
    }
    
    Student getStudent() {
        return student;
    }
    
    Course getCourse() {
        return course;
    }
    
    String getGrade() {
        return grade;
    }
    
    double getGradePoints() {
        return gradePoints;
    }
    
    void setGrade(String grade) {
        this.grade = grade;
    }
    
    void setGradePoints(double gradePoints) {
        this.gradePoints = gradePoints;
    }
}