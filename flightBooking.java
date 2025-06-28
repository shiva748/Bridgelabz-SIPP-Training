
import java.util.*;

public class flightBooking {

    private static String[] flights = {
        "AI101 - Delhi to Mumbai",
        "AI102 - Mumbai to Bangalore",
        "AI103 - Bangalore to Chennai",
        "AI104 - Chennai to Kolkata",
        "AI105 - Kolkata to Delhi"
    };

    private static List<String> bookings = new ArrayList<>();

    public static void searchFlights(String keyword) {
        System.out.println("Available flights matching \"" + keyword + "\":");
        boolean found = false;
        for (String flight : flights) {
            if (flight.toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println(flight);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No flights found.");
        }
    }

    public static void bookFlight(String flightNumber, String passengerName) {
        boolean exists = false;
        for (String flight : flights) {
            if (flight.toLowerCase().startsWith(flightNumber.toLowerCase())) {
                bookings.add(passengerName + " booked " + flight);
                System.out.println("Booking successful for " + passengerName + " on " + flight);
                exists = true;
                break;
            }
        }
        if (!exists) {
            System.out.println("Flight number not found.");
        }
    }

    public static void displayBookings() {
        if (bookings.isEmpty()) {
            System.out.println("No bookings found.");
        } else {
            System.out.println("Booking Details:");
            for (String booking : bookings) {
                System.out.println(booking);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n1. Search Flights\n2. Book Flight\n3. View Bookings\n4. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Enter keyword to search: ");
                    String keyword = sc.nextLine();
                    searchFlights(keyword);
                    break;
                case 2:
                    System.out.print("Enter flight number (e.g., AI101): ");
                    String flightNumber = sc.nextLine();
                    System.out.print("Enter passenger name: ");
                    String name = sc.nextLine();
                    bookFlight(flightNumber, name);
                    break;
                case 3:
                    displayBookings();
                    break;
                case 4:
                    System.out.println("Thank you for using the flight booking system.");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}