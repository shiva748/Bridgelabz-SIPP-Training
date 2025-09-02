
import java.util.*;
import java.util.function.Predicate;

class Alert {
    String type;
    String message;

    Alert(String type, String message) {
        this.type = type;
        this.message = message;
    }

    @Override
    public String toString() {
        return type + ": " + message;
    }
}

public class NotificationFiltering {
    public static void main(String[] args) {
        List<Alert> alerts = Arrays.asList(
                new Alert("Critical", "Patient needs immediate attention"),
                new Alert("Normal", "Routine check-up scheduled"),
                new Alert("Warning", "Medicine stock low")
        );

        
        Predicate<Alert> isCritical = alert -> alert.type.equals("Critical");

        alerts.stream()
                .filter(isCritical)
                .forEach(System.out::println);
    }
}
