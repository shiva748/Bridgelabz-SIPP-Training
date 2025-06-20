import java.util.Scanner;

public class TemperatureConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Temperature Converter");
        System.out.println("1. Fahrenheit to Celsius");
        System.out.println("2. Celsius to Fahrenheit");
        System.out.print("Enter choice (1/2): ");
        
        int choice = scanner.nextInt();
        System.out.print("Enter temperature: ");
        double temp = scanner.nextDouble();
        
        if (choice == 1) {
            double celsius = fahrenheitToCelsius(temp);
            System.out.printf("%.2f°F = %.2f°C%n", temp, celsius);
        } else if (choice == 2) {
            double fahrenheit = celsiusToFahrenheit(temp);
            System.out.printf("%.2f°C = %.2f°F%n", temp, fahrenheit);
        } else {
            System.out.println("Invalid choice");
        }
        
        scanner.close();
    }
    
    static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }
    
    static double celsiusToFahrenheit(double celsius) {
        return celsius * 9 / 5 + 32;
    }
}
