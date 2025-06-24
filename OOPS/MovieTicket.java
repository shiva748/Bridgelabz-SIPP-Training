public class MovieTicket {
    String movieName;
    int seatNumber;
    double price;
    MovieTicket(String movieName) {
        this.movieName = movieName;
    }
    void bookTicket(int seatNumber, double price) {
        this.seatNumber = seatNumber;
        this.price = price;
    }
    void displayDetails() {
        System.out.println("Movie Name: " + movieName);
        System.out.println("Seat Number: " + seatNumber);
        System.out.println("Price: " + price);
    }
    public static void main(String[] args) {
        MovieTicket ticket = new MovieTicket("Inception");
        ticket.bookTicket(12, 250);
        ticket.displayDetails();
    }
} 