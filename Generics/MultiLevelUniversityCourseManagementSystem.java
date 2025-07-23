abstract class CourseType {}
class ExamCourse extends CourseType {}
class AssignmentCourse extends CourseType {}
class ResearchCourse extends CourseType {}
class Course<T extends CourseType> {
    private T type;
    public Course(T type) { this.type = type; }
    public T getType() { return type; }
}
class MultiLevelUniversityCourseManagementSystem {
    public static void displayCourses(java.util.List<? extends CourseType> courses) {
        for (CourseType c : courses) {
            System.out.println(c.getClass().getSimpleName());
        }
    }
    public static void main(String[] args) {
        java.util.List<CourseType> courseList = new java.util.ArrayList<>();
        courseList.add(new ExamCourse());
        courseList.add(new AssignmentCourse());
        courseList.add(new ResearchCourse());
        displayCourses(courseList);
    }
} 