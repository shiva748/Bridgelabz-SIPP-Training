import java.util.ArrayList;
public class Hospital {
    String name;
    ArrayList<Doctor> doctors;
    ArrayList<Patient> patients;
    Hospital(String name) {
        this.name = name;
        this.doctors = new ArrayList<>();
        this.patients = new ArrayList<>();
    }
    void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }
    void addPatient(Patient patient) {
        patients.add(patient);
    }
    void displayInfo() {
        System.out.println("Hospital: " + name);
        System.out.println("Doctors:");
        for (Doctor doctor : doctors) {
            System.out.println("  " + doctor.name);
        }
        System.out.println("Patients:");
        for (Patient patient : patients) {
            System.out.println("  " + patient.name);
        }
    }
    public static void main(String[] args) {
        Hospital hospital = new Hospital("City Hospital");
        Doctor d1 = new Doctor("Dr. Smith");
        Doctor d2 = new Doctor("Dr. Johnson");
        Patient p1 = new Patient("John");
        Patient p2 = new Patient("Alice");
        hospital.addDoctor(d1);
        hospital.addDoctor(d2);
        hospital.addPatient(p1);
        hospital.addPatient(p2);
        d1.consult(p1);
        d1.consult(p2);
        d2.consult(p1);
        hospital.displayInfo();
    }
}
class Doctor {
    String name;
    ArrayList<Patient> patients;
    Doctor(String name) {
        this.name = name;
        this.patients = new ArrayList<>();
    }
    void consult(Patient patient) {
        patients.add(patient);
        patient.addDoctor(this);
        System.out.println(name + " consulting " + patient.name);
    }
}
class Patient {
    String name;
    ArrayList<Doctor> doctors;
    Patient(String name) {
        this.name = name;
        this.doctors = new ArrayList<>();
    }
    void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }
} 