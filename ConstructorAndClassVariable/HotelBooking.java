public class HotelBooking {
    String guestName;
    String roomType;
    int nights;
    HotelBooking() {
        guestName = "Unknown";
        roomType = "Standard";
        nights = 1;
    }
    HotelBooking(String guestName, String roomType, int nights) {
        this.guestName = guestName;
        this.roomType = roomType;
        this.nights = nights;
    }
    HotelBooking(HotelBooking hb) {
        this.guestName = hb.guestName;
        this.roomType = hb.roomType;
        this.nights = hb.nights;
    }
    public static void main(String[] args) {
        HotelBooking b1 = new HotelBooking();
        HotelBooking b2 = new HotelBooking("Alice", "Deluxe", 3);
        HotelBooking b3 = new HotelBooking(b2);
        System.out.println(b1.guestName + " " + b1.roomType + " " + b1.nights);
        System.out.println(b2.guestName + " " + b2.roomType + " " + b2.nights);
        System.out.println(b3.guestName + " " + b3.roomType + " " + b3.nights);
    }
} 