abstract class Vehicle {
    private String vehicleId;
    private String driverName;
    private double ratePerKm;
    public Vehicle(String vehicleId, String driverName, double ratePerKm) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
    }
    public String getVehicleId() { return vehicleId; }
    public void setVehicleId(String vehicleId) { this.vehicleId = vehicleId; }
    public String getDriverName() { return driverName; }
    public void setDriverName(String driverName) { this.driverName = driverName; }
    public double getRatePerKm() { return ratePerKm; }
    public void setRatePerKm(double ratePerKm) { this.ratePerKm = ratePerKm; }
    public abstract double calculateFare(double distance);
    public void getVehicleDetails() {
        System.out.println("Vehicle: " + vehicleId + ", Driver: " + driverName + ", Rate/Km: " + ratePerKm);
    }
}
interface GPS {
    String getCurrentLocation();
    void updateLocation(String location);
}
class Car extends Vehicle implements GPS {
    private String location;
    public Car(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
    }
    public double calculateFare(double distance) {
        return getRatePerKm() * distance;
    }
    public String getCurrentLocation() { return location; }
    public void updateLocation(String location) { this.location = location; }
}
class Bike extends Vehicle implements GPS {
    private String location;
    public Bike(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
    }
    public double calculateFare(double distance) {
        return getRatePerKm() * distance * 0.8;
    }
    public String getCurrentLocation() { return location; }
    public void updateLocation(String location) { this.location = location; }
}
class Auto extends Vehicle implements GPS {
    private String location;
    public Auto(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
    }
    public double calculateFare(double distance) {
        return getRatePerKm() * distance * 0.6;
    }
    public String getCurrentLocation() { return location; }
    public void updateLocation(String location) { this.location = location; }
}
class RideHailingDemo {
    public static void processRides(Vehicle[] vehicles, double distance) {
        for (Vehicle v : vehicles) {
            v.getVehicleDetails();
            System.out.println("Fare: " + v.calculateFare(distance));
        }
    }
    public static void main(String[] args) {
        Vehicle[] vehicles = new Vehicle[3];
        vehicles[0] = new Car("V1", "Amit", 20);
        vehicles[1] = new Bike("V2", "Ravi", 15);
        vehicles[2] = new Auto("V3", "Sunil", 10);
        processRides(vehicles, 10);
    }
} 