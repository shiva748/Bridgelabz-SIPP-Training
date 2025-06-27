public class Patient {
    static String hospitalName = "City Hospital";
    static int totalPatients = 0;
    final int patientID;
    String name;
    int age;
    String ailment;
    Patient(int patientID, String name, int age, String ailment) {
        this.patientID = patientID;
        this.name = name;
        this.age = age;
        this.ailment = ailment;
        totalPatients++;
    }
    static void getTotalPatients() {
        System.out.println("Total Patients: " + totalPatients);
    }
    void displayDetails() {
        if (this instanceof Patient) {
            System.out.println("Hospital: " + hospitalName);
            System.out.println("Patient ID: " + patientID);
            System.out.println("Name: " + name);
            System.out.println("Age: " + age);
            System.out.println("Ailment: " + ailment);
        }
    }
    public static void main(String[] args) {
        Patient p1 = new Patient(1, "John", 30, "Fever");
        Patient p2 = new Patient(2, "Alice", 25, "Cold");
        p1.displayDetails();
        p2.displayDetails();
        Patient.getTotalPatients();
    }
} 