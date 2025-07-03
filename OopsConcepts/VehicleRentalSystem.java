abstract class Vehicle {
    private String vehicleNumber;
    private String type;
    private double rentalRate;
    public Vehicle(String vehicleNumber, String type, double rentalRate) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
    }
    public String getVehicleNumber() { return vehicleNumber; }
    public void setVehicleNumber(String vehicleNumber) { this.vehicleNumber = vehicleNumber; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public double getRentalRate() { return rentalRate; }
    public void setRentalRate(double rentalRate) { this.rentalRate = rentalRate; }
    public abstract double calculateRentalCost(int days);
}
interface Insurable {
    double calculateInsurance();
    String getInsuranceDetails();
}
class Car extends Vehicle implements Insurable {
    private String policyNumber;
    public Car(String vehicleNumber, double rentalRate, String policyNumber) {
        super(vehicleNumber, "Car", rentalRate);
        this.policyNumber = policyNumber;
    }
    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }
    public double calculateInsurance() {
        return getRentalRate() * 0.1;
    }
    public String getInsuranceDetails() {
        return policyNumber;
    }
}
class Bike extends Vehicle implements Insurable {
    private String policyNumber;
    public Bike(String vehicleNumber, double rentalRate, String policyNumber) {
        super(vehicleNumber, "Bike", rentalRate);
        this.policyNumber = policyNumber;
    }
    public double calculateRentalCost(int days) {
        return getRentalRate() * days * 0.5;
    }
    public double calculateInsurance() {
        return getRentalRate() * 0.05;
    }
    public String getInsuranceDetails() {
        return policyNumber;
    }
}
class Truck extends Vehicle implements Insurable {
    private String policyNumber;
    public Truck(String vehicleNumber, double rentalRate, String policyNumber) {
        super(vehicleNumber, "Truck", rentalRate);
        this.policyNumber = policyNumber;
    }
    public double calculateRentalCost(int days) {
        return getRentalRate() * days * 2;
    }
    public double calculateInsurance() {
        return getRentalRate() * 0.2;
    }
    public String getInsuranceDetails() {
        return policyNumber;
    }
}
class VehicleRentalDemo {
    public static void main(String[] args) {
        Vehicle[] vehicles = new Vehicle[3];
        vehicles[0] = new Car("C123", 1000, "P1001");
        vehicles[1] = new Bike("B456", 500, "P2002");
        vehicles[2] = new Truck("T789", 2000, "P3003");
        for (Vehicle v : vehicles) {
            System.out.println("Vehicle: " + v.getType() + ", Number: " + v.getVehicleNumber());
            System.out.println("Rental Cost (5 days): " + v.calculateRentalCost(5));
            System.out.println("Insurance: " + ((Insurable)v).calculateInsurance());
            System.out.println("Policy: " + ((Insurable)v).getInsuranceDetails());
        }
    }
} 