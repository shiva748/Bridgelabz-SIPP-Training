import java.util.*;

public class StudentManagementSystem {
    public static class Student {
        String id;
        String name;
        int age;
        Set<String> subjects;
        Map<String, Integer> grades;
        public Student(String id, String name, int age, Set<String> subjects, Map<String, Integer> grades) {
            this.id = id;
            this.name = name;
            this.age = age;
            this.subjects = subjects;
            this.grades = grades;
        }
        public int getAverageGrade() {
            if (grades.isEmpty()) return 0;
            int sum = 0;
            for (int g : grades.values()) sum += g;
            return sum / grades.size();
        }
    }
    public Map<String, Student> students = new HashMap<>();
    public void addStudent(Student s) { students.put(s.id, s); }
    public void removeStudent(String id) { students.remove(id); }
    public Student searchById(String id) { return students.get(id); }
    public Student searchByName(String name) {
        for (Student s : students.values()) if (s.name.equals(name)) return s;
        return null;
    }
    public List<Student> sortByName() {
        List<Student> list = new ArrayList<>(students.values());
        list.sort(Comparator.comparing(a -> a.name));
        return list;
    }
    public List<Student> sortByGrade() {
        List<Student> list = new ArrayList<>(students.values());
        list.sort(Comparator.comparing(Student::getAverageGrade).reversed());
        return list;
    }
    public List<Student> findBySubject(String subject) {
        List<Student> res = new ArrayList<>();
        for (Student s : students.values()) if (s.subjects.contains(subject)) res.add(s);
        return res;
    }
    public static void main(String[] args) {
        StudentManagementSystem sms = new StudentManagementSystem();
        Set<String> sub1 = new HashSet<>(Arrays.asList("Math", "Science"));
        Set<String> sub2 = new HashSet<>(Arrays.asList("Math", "English"));
        Map<String, Integer> g1 = new HashMap<>();
        g1.put("Math", 90); g1.put("Science", 80);
        Map<String, Integer> g2 = new HashMap<>();
        g2.put("Math", 85); g2.put("English", 95);
        sms.addStudent(new Student("1", "Alice", 20, sub1, g1));
        sms.addStudent(new Student("2", "Bob", 21, sub2, g2));
        System.out.println(sms.searchById("1").name);
        System.out.println(sms.searchByName("Bob").id);
        for (Student s : sms.sortByName()) System.out.println(s.name);
        for (Student s : sms.sortByGrade()) System.out.println(s.name + " " + s.getAverageGrade());
        for (Student s : sms.findBySubject("Math")) System.out.println(s.name);
    }
}
