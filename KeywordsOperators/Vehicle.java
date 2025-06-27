public class Vehicle {
    static double registrationFee = 5000;
    final String registrationNumber;
    String ownerName;
    String vehicleType;
    Vehicle(String ownerName, String vehicleType, String registrationNumber) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
        this.registrationNumber = registrationNumber;
    }
    static void updateRegistrationFee(double fee) {
        registrationFee = fee;
    }
    void displayDetails() {
        if (this instanceof Vehicle) {
            System.out.println("Owner: " + ownerName);
            System.out.println("Type: " + vehicleType);
            System.out.println("Registration Number: " + registrationNumber);
            System.out.println("Registration Fee: " + registrationFee);
        }
    }
    public static void main(String[] args) {
        Vehicle v1 = new Vehicle("John", "Car", "MH12AB1234");
        Vehicle v2 = new Vehicle("Alice", "Bike", "MH12XY5678");
        v1.displayDetails();
        v2.displayDetails();
        Vehicle.updateRegistrationFee(6000);
        v1.displayDetails();
    }
} 