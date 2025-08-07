
import java.util.*;
import java.util.regex.Pattern;

class InvalidEmailFormatException extends RuntimeException {

    public InvalidEmailFormatException(String message) {
        super(message);
    }
}
class NoEmployeeFoundException extends Exception {

    public NoEmployeeFoundException(String message) {
        super(message);
    }
}

class Email {

    private String emailAddress;

    public Email(String emailAddress) {
        this.setEmailAddress(emailAddress);
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        if (!isValid(emailAddress)) {
            throw new InvalidEmailFormatException("Invalid email format: " + emailAddress);
        }
        this.emailAddress = emailAddress;
    }

    public boolean isValid() {
        return isValid(this.emailAddress);
    }

    public static boolean isValid(String email) {
        String regex = "^[a-z0-9._]+@company\\.com$";
        return Pattern.matches(regex, email);
    }
}

class Employee {

    private String name;
    private Email email;

    public Employee(String name, String email) {
        this.name = name;
        this.email = new Email(email);
    }

    public String getName() {
        return name;
    }

    public Email getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public String toString() {
        return "Employee{name='" + name + "', email='" + email.getEmailAddress() + "'}";
    }
}

class EmailManager {

    private List<Employee> employees;

    public EmailManager() {
        this.employees = new ArrayList<>();
    }

    public void addEmployee(String name, String email) {
        try {
            Employee emp = new Employee(name, email);
            employees.add(emp);
            System.out.println("Added: " + emp);
        } catch (InvalidEmailFormatException e) {
            System.out.println("Failed to add employee '" + name + "': " + e.getMessage());
        }
    }

    public List<Employee> searchByDomain(String domain) throws NoEmployeeFoundException {
        List<Employee> result = new ArrayList<>();
        for (Employee emp : employees) {
            if (emp.getEmail().getEmailAddress().contains(domain)) {
                result.add(emp);
            }
        }
        if (result.isEmpty()) {
            throw new NoEmployeeFoundException("No employee found for domain: " + domain);
        }
        return result;
    }
}

public class EmailFiltering {

    public static void main(String[] args) {
        EmailManager manager = new EmailManager();

        manager.addEmployee("Alice", "alice_1@company.com");
        manager.addEmployee("Bob", "bob.smith@company.com");
        manager.addEmployee("Charlie", "charlie@company.co");
        manager.addEmployee("Dave", "dave_01@company.com");
        manager.addEmployee("Eve", "eve@other.com");
        manager.addEmployee("Frank", "frank99@company.com");

        try {
            List<Employee> companyEmployees = manager.searchByDomain("company.com");
            System.out.println("Search Results for domain 'company.com':");
            for (Employee emp : companyEmployees) {
                System.out.println(emp);
            }
        } catch (NoEmployeeFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            manager.searchByDomain("other.com");
        } catch (NoEmployeeFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
