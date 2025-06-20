import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class DateComparison {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        
        System.out.print("Enter first date (yyyy-MM-dd): ");
        LocalDate date1 = LocalDate.parse(scanner.nextLine(), formatter);
        
        System.out.print("Enter second date (yyyy-MM-dd): ");
        LocalDate date2 = LocalDate.parse(scanner.nextLine(), formatter);
        
        System.out.println("\nComparison results:");
        if (date1.isEqual(date2)) {
            System.out.println("The dates are equal");
        } else if (date1.isBefore(date2)) {
            System.out.println("First date is before second date");
        } else {
            System.out.println("First date is after second date");
        }
        
        System.out.println("Days between: " + Math.abs(date1.until(date2).getDays()));
        scanner.close();
    }
}
