import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

// Date Format Utility with static interface methods
interface DateUtils {
    static String formatISO(LocalDate date) {
        return date.format(DateTimeFormatter.ISO_DATE);
    }

    static String formatShort(LocalDate date) {
        return date.format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
    }

    static String formatLong(LocalDate date) {
        return date.format(DateTimeFormatter.ofPattern("MMMM dd, yyyy"));
    }

    static String formatWithDay(LocalDate date) {
        return date.format(DateTimeFormatter.ofPattern("EEEE, MMMM dd, yyyy"));
    }

    static String formatForFilename(LocalDate date) {
        return date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }
}

public class DateFormatUtility {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();

        System.out.println("Date Format Utility:");
        System.out.println("ISO Format: " + DateUtils.formatISO(today));
        System.out.println("Short Format: " + DateUtils.formatShort(today));
        System.out.println("Long Format: " + DateUtils.formatLong(today));
        System.out.println("With Day: " + DateUtils.formatWithDay(today));
        System.out.println("Filename Format: " + DateUtils.formatForFilename(today));

        // Test with a specific date
        LocalDate invoiceDate = LocalDate.of(2024, 12, 25);
        System.out.println("\nInvoice Date Formats:");
        System.out.println("ISO: " + DateUtils.formatISO(invoiceDate));
        System.out.println("Short: " + DateUtils.formatShort(invoiceDate));
        System.out.println("Long: " + DateUtils.formatLong(invoiceDate));
    }
}
