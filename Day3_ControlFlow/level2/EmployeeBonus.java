import java.util.Scanner;

public class EmployeeBonus {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the salary of the employee: ");
        double salary = scanner.nextDouble();

        System.out.print("Enter the years of service: ");
        int yearsOfService = scanner.nextInt();

        double bonus = 0;
        if (yearsOfService > 5) {
            bonus = salary * 0.05;
        }

        System.out.println("The bonus amount is: " + bonus);
        
        scanner.close();
    }
}