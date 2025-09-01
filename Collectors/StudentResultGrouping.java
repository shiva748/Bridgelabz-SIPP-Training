import java.util.*;
import java.util.stream.Collectors;

public class StudentResultGrouping {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("Alice", 10),
                new Student("Bob", 10),
                new Student("Charlie", 11),
                new Student("David", 11));

        Map<Integer, List<String>> groupedByGrade = students.stream()
                .collect(Collectors.groupingBy(Student::getGrade,
                        Collectors.mapping(Student::getName, Collectors.toList())));

        System.out.println(groupedByGrade);
    }
}

class Student {
    private String name;
    private int grade;

    public Student(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public int getGrade() {
        return grade;
    }
}
