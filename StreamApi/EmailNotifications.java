package StreamApi;

import java.util.*;

public class EmailNotifications {
    public static void main(String[] args) {
        List<String> userEmails = Arrays.asList(
                "john@example.com",
                "alice@example.com",
                "bob@example.com",
                "carol@example.com");

        System.out.println("Sending email notifications:");
        userEmails.forEach(email -> sendEmailNotification(email));
    }

    private static void sendEmailNotification(String email) {
        System.out.println("Sending notification to: " + email);
    }
}
