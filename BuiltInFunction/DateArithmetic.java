import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class DateArithmetic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        
        System.out.print("Enter date (yyyy-MM-dd): ");
        String dateStr = scanner.nextLine();
        LocalDate date = LocalDate.parse(dateStr, formatter);
        
        LocalDate modifiedDate = date
            .plusDays(7)
            .plusMonths(1)
            .plusYears(2)
            .minusWeeks(3);
            
        System.out.println("Original date: " + date.format(formatter));
        System.out.println("Modified date: " + modifiedDate.format(formatter));
        System.out.println("Days between: " + date.until(modifiedDate).getDays());
        
        scanner.close();
    }
}
