import java.util.function.Predicate;

public class TemperatureAlert {
    public static void main(String[] args) {
        // Using Predicate functional interface to check temperature threshold
        Predicate<Double> temperatureAlert = temp -> temp > 30.0;

        double[] temperatures = { 25.5, 31.2, 28.7, 32.1, 29.8 };

        System.out.println("Temperature Alert System:");
        for (double temp : temperatures) {
            if (temperatureAlert.test(temp)) {
                System.out.println("ALERT: Temperature " + temp + "°C exceeds threshold!");
            } else {
                System.out.println("Normal: Temperature " + temp + "°C is within limits");
            }
        }
    }
}
