package StreamApi;

import java.util.*;

public class IoTSensorReadings {
    public static void main(String[] args) {
        List<Double> sensorReadings = Arrays.asList(25.5, 30.2, 28.7, 32.1, 29.8, 35.0, 27.3);
        double threshold = 30.0;

        System.out.println("Sensor readings above threshold (" + threshold + "):");
        sensorReadings.stream()
                .filter(reading -> reading > threshold)
                .forEach(reading -> System.out.println("ALERT: Reading " + reading + " exceeds threshold"));
    }
}
