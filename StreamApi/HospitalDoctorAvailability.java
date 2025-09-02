package StreamApi;

import java.util.*;
import java.util.stream.Collectors;

class Doctor {
    String name;
    String specialty;
    boolean availableWeekends;

    public Doctor(String name, String specialty, boolean availableWeekends) {
        this.name = name;
        this.specialty = specialty;
        this.availableWeekends = availableWeekends;
    }

    public String getSpecialty() {
        return specialty;
    }

    public boolean isAvailableWeekends() {
        return availableWeekends;
    }

    @Override
    public String toString() {
        return name + " - " + specialty + " (Weekends: " + (availableWeekends ? "Yes" : "No") + ")";
    }
}

public class HospitalDoctorAvailability {
    public static void main(String[] args) {
        List<Doctor> doctors = Arrays.asList(
                new Doctor("Dr. Smith", "Cardiology", true),
                new Doctor("Dr. Johnson", "Neurology", false),
                new Doctor("Dr. Brown", "Cardiology", true),
                new Doctor("Dr. Davis", "Pediatrics", true),
                new Doctor("Dr. Wilson", "Neurology", true),
                new Doctor("Dr. Taylor", "Orthopedics", false));

        List<Doctor> availableDoctors = doctors.stream()
                .filter(Doctor::isAvailableWeekends)
                .sorted(Comparator.comparing(Doctor::getSpecialty))
                .collect(Collectors.toList());

        System.out.println("Doctors available on weekends (sorted by specialty):");
        availableDoctors.forEach(System.out::println);
    }
}
