abstract class JobRole {}
class SoftwareEngineer extends JobRole {}
class DataScientist extends JobRole {}
class ProductManager extends JobRole {}
class Resume<T extends JobRole> {
    private T role;
    public Resume(T role) { this.role = role; }
    public T getRole() { return role; }
}
class AIDrivenResumeScreeningSystem {
    public static void processResumes(java.util.List<? extends JobRole> roles) {
        for (JobRole r : roles) {
            System.out.println(r.getClass().getSimpleName());
        }
    }
    public static void main(String[] args) {
        java.util.List<JobRole> jobRoles = new java.util.ArrayList<>();
        jobRoles.add(new SoftwareEngineer());
        jobRoles.add(new DataScientist());
        jobRoles.add(new ProductManager());
        processResumes(jobRoles);
    }
} 