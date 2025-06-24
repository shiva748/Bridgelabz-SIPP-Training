public class Vehicle {
    String ownerName;
    String vehicleType;
    static double registrationFee = 5000;
    Vehicle(String ownerName, String vehicleType) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }
    void displayVehicleDetails() {
        System.out.println(ownerName + " " + vehicleType + " " + registrationFee);
    }
    static void updateRegistrationFee(double fee) {
        registrationFee = fee;
    }
    public static void main(String[] args) {
        Vehicle v1 = new Vehicle("John", "Car");
        v1.displayVehicleDetails();
        Vehicle.updateRegistrationFee(6000);
        v1.displayVehicleDetails();
    }
} 