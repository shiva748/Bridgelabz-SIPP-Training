package Linkedlist;
class TicketNode {
    int ticketId;
    String customerName;
    String movieName;
    String seatNumber;
    String bookingTime;
    TicketNode next;
    public TicketNode(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
        this.ticketId = ticketId;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = bookingTime;
    }
}
class CircularLinkedListTicketReservation {
    private TicketNode tail;
    private int count;
    public void addTicket(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
        TicketNode node = new TicketNode(ticketId, customerName, movieName, seatNumber, bookingTime);
        if (tail == null) {
            tail = node;
            node.next = node;
        } else {
            node.next = tail.next;
            tail.next = node;
            tail = node;
        }
        count++;
    }
    public void removeTicket(int ticketId) {
        if (tail == null) return;
        TicketNode curr = tail.next, prev = tail;
        do {
            if (curr.ticketId == ticketId) {
                if (curr == tail) {
                    if (tail == tail.next) tail = null;
                    else { prev.next = curr.next; tail = prev; }
                } else {
                    prev.next = curr.next;
                }
                count--;
                break;
            }
            prev = curr;
            curr = curr.next;
        } while (curr != tail.next);
    }
    public void displayTickets() {
        if (tail == null) return;
        TicketNode curr = tail.next;
        do {
            System.out.println(curr.ticketId + " " + curr.customerName + " " + curr.movieName + " " + curr.seatNumber + " " + curr.bookingTime);
            curr = curr.next;
        } while (curr != tail.next);
    }
    public void searchByCustomer(String customerName) {
        if (tail == null) return;
        TicketNode curr = tail.next;
        do {
            if (curr.customerName.equals(customerName)) System.out.println(curr.ticketId + " " + curr.customerName + " " + curr.movieName);
            curr = curr.next;
        } while (curr != tail.next);
    }
    public void searchByMovie(String movieName) {
        if (tail == null) return;
        TicketNode curr = tail.next;
        do {
            if (curr.movieName.equals(movieName)) System.out.println(curr.ticketId + " " + curr.customerName + " " + curr.movieName);
            curr = curr.next;
        } while (curr != tail.next);
    }
    public int countTickets() {
        return count;
    }
    public static void main(String[] args) {
        CircularLinkedListTicketReservation res = new CircularLinkedListTicketReservation();
        res.addTicket(1, "Alice", "MovieA", "A1", "10:00");
        res.addTicket(2, "Bob", "MovieB", "B2", "11:00");
        res.addTicket(3, "Charlie", "MovieA", "A2", "12:00");
        res.displayTickets();
        res.removeTicket(2);
        res.displayTickets();
        res.searchByCustomer("Alice");
        res.searchByMovie("MovieA");
        System.out.println(res.countTickets());
    }
} 