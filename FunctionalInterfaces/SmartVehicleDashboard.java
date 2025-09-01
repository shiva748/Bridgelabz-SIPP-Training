// Smart Vehicle Interface with default methods
interface Vehicle {
    void displaySpeed();

    default void displayBatteryPercentage() {
        System.out.println("Battery percentage: Not applicable (non-electric vehicle)");
    }
}

class Car implements Vehicle {
    @Override
    public void displaySpeed() {
        System.out.println("Car speed: 60 km/h");
    }
}

class ElectricCar implements Vehicle {
    @Override
    public void displaySpeed() {
        System.out.println("Electric car speed: 80 km/h");
    }

    @Override
    public void displayBatteryPercentage() {
        System.out.println("Battery percentage: 75%");
    }
}

class Bike implements Vehicle {
    @Override
    public void displaySpeed() {
        System.out.println("Bike speed: 30 km/h");
    }
}

public class SmartVehicleDashboard {
    public static void main(String[] args) {
        Vehicle car = new Car();
        Vehicle electricCar = new ElectricCar();
        Vehicle bike = new Bike();

        System.out.println("Regular Car Dashboard:");
        car.displaySpeed();
        car.displayBatteryPercentage();

        System.out.println("\nElectric Car Dashboard:");
        electricCar.displaySpeed();
        electricCar.displayBatteryPercentage();

        System.out.println("\nBike Dashboard:");
        bike.displaySpeed();
        bike.displayBatteryPercentage();
    }
}
