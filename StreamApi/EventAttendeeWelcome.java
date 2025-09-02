package StreamApi;

import java.util.*;

public class EventAttendeeWelcome {
    public static void main(String[] args) {
        List<String> attendees = Arrays.asList(
                "John Smith",
                "Alice Johnson",
                "Bob Brown",
                "Carol Davis",
                "Dave Wilson");

        System.out.println("Welcome messages for attendees:");
        attendees.forEach(attendee -> System.out.println("Welcome, " + attendee + "! We're glad you're here."));
    }
}
