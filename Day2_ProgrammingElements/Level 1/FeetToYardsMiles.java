import java.util.Scanner;

public class FeetToYardsMiles {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter distance in feet: ");
        double distanceInFeet = input.nextDouble();
        
        double distanceInYards = distanceInFeet / 3;
        double distanceInMiles = distanceInYards / 1760;
        
        System.out.printf("The distance in yards is %.2f and in miles is %.2f%n", distanceInYards, distanceInMiles);
        
        input.close();
    }
}