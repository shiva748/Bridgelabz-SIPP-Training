import java.util.*;

public class AbundantNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number ");
        int n = scanner.nextInt(), sum = 1;
        for (int i = 2; i * i < n; i++) {
            if (n % i == 0) {
                sum += (i + n / i);
            }
        }
        System.out.println(sum > n ? "Abundant Number" : "Not an Abundant Number");
        scanner.close();
    }
}
