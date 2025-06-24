public class CarRental {
    String customerName;
    String carModel;
    int rentalDays;
    double ratePerDay;
    CarRental(String customerName, String carModel, int rentalDays, double ratePerDay) {
        this.customerName = customerName;
        this.carModel = carModel;
        this.rentalDays = rentalDays;
        this.ratePerDay = ratePerDay;
    }
    double totalCost() {
        return rentalDays * ratePerDay;
    }
    public static void main(String[] args) {
        CarRental rental = new CarRental("Sam", "Honda", 4, 800);
        System.out.println(rental.customerName + " " + rental.carModel + " " + rental.rentalDays + " " + rental.totalCost());
    }
} 