// Unit Conversion Tool with static interface methods
interface ConversionUtils {
    static double kmToMiles(double kilometers) {
        return kilometers * 0.621371;
    }

    static double milesToKm(double miles) {
        return miles * 1.60934;
    }

    static double kgToLbs(double kilograms) {
        return kilograms * 2.20462;
    }

    static double lbsToKg(double pounds) {
        return pounds * 0.453592;
    }

    static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }
} 

public class UnitConversionTool {
    public static void main(String[] args) {
        System.out.println("Unit Conversion Tool:");

        double km = 100;
        double kg = 50;
        double celsius = 25;

        System.out.println(km + " km = " + ConversionUtils.kmToMiles(km) + " miles");
        System.out.println(kg + " kg = " + ConversionUtils.kgToLbs(kg) + " lbs");
        System.out.println(celsius + " °C = " + ConversionUtils.celsiusToFahrenheit(celsius) + " °F");

        // Test reverse conversions
        double miles = 62.1371;
        double lbs = 110.231;
        double fahrenheit = 77;

        System.out.println(miles + " miles = " + ConversionUtils.milesToKm(miles) + " km");
        System.out.println(lbs + " lbs = " + ConversionUtils.lbsToKg(lbs) + " kg");
        System.out.println(fahrenheit + " °F = " + ConversionUtils.fahrenheitToCelsius(fahrenheit) + " °C");
    }
}
