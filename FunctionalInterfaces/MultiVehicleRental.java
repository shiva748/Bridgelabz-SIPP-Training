
interface RentableVehicle {
    void rent();

    void returnVehicle();
}

class Car implements RentableVehicle {
    @Override
    public void rent() {
        System.out.println("Car rented successfully");
    }

    @Override
    public void returnVehicle() {
        System.out.println("Car returned successfully");
    }
}

class Bike implements RentableVehicle {
    @Override
    public void rent() {
        System.out.println("Bike rented successfully");
    }

    @Override
    public void returnVehicle() {
        System.out.println("Bike returned successfully");
    }
}

class Bus implements RentableVehicle {
    @Override
    public void rent() {
        System.out.println("Bus rented successfully");
    }

    @Override
    public void returnVehicle() {
        System.out.println("Bus returned successfully");
    }
}

public class MultiVehicleRental {
    public static void main(String[] args) {
        RentableVehicle car = new Car();
        RentableVehicle bike = new Bike();
        RentableVehicle bus = new Bus();

        car.rent();
        bike.rent();
        bus.rent();

        System.out.println("---");

        car.returnVehicle();
        bike.returnVehicle();
        bus.returnVehicle();
    }
}
