abstract class Patient {
    private int patientId;
    private String name;
    private int age;
    public Patient(int patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
    }
    public int getPatientId() { return patientId; }
    public void setPatientId(int patientId) { this.patientId = patientId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
    public abstract double calculateBill();
    public void getPatientDetails() {
        System.out.println("ID: " + patientId + ", Name: " + name + ", Age: " + age);
    }
}
interface MedicalRecord {
    void addRecord(String record);
    String viewRecords();
}
class InPatient extends Patient implements MedicalRecord {
    private double roomCharge;
    private String records = "";
    public InPatient(int patientId, String name, int age, double roomCharge) {
        super(patientId, name, age);
        this.roomCharge = roomCharge;
    }
    public double calculateBill() {
        return roomCharge + 5000;
    }
    public void addRecord(String record) { records += record + "; "; }
    public String viewRecords() { return records; }
}
class OutPatient extends Patient implements MedicalRecord {
    private double consultationFee;
    private String records = "";
    public OutPatient(int patientId, String name, int age, double consultationFee) {
        super(patientId, name, age);
        this.consultationFee = consultationFee;
    }
    public double calculateBill() {
        return consultationFee + 500;
    }
    public void addRecord(String record) { records += record + "; "; }
    public String viewRecords() { return records; }
}
class HospitalDemo {
    public static void main(String[] args) {
        Patient[] patients = new Patient[2];
        patients[0] = new InPatient(1, "Sam", 30, 2000);
        patients[1] = new OutPatient(2, "Tom", 25, 300);
        for (Patient p : patients) {
            p.getPatientDetails();
            System.out.println("Bill: " + p.calculateBill());
            ((MedicalRecord)p).addRecord("Checked");
            System.out.println("Records: " + ((MedicalRecord)p).viewRecords());
        }
    }
} 