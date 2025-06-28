import java.util.ArrayList;
public class Bank {
    String name;
    ArrayList<Customer> customers;
    Bank(String name) {
        this.name = name;
        this.customers = new ArrayList<>();
    }
    void openAccount(Customer customer, double initialBalance) {
        customers.add(customer);
        customer.addAccount(this, initialBalance);
        System.out.println("Account opened for " + customer.name);
    }
    public static void main(String[] args) {
        Bank bank = new Bank("ABC Bank");
        Customer c1 = new Customer("John");
        Customer c2 = new Customer("Alice");
        bank.openAccount(c1, 1000);
        bank.openAccount(c2, 2000);
        c1.viewBalance();
        c2.viewBalance();
    }
}
class Customer {
    String name;
    ArrayList<Account> accounts;
    Customer(String name) {
        this.name = name;
        this.accounts = new ArrayList<>();
    }
    void addAccount(Bank bank, double balance) {
        accounts.add(new Account(bank, balance));
    }
    void viewBalance() {
        System.out.println("Customer: " + name);
        for (Account account : accounts) {
            System.out.println("Bank: " + account.bank.name + ", Balance: " + account.balance);
        }
    }
}
class Account {
    Bank bank;
    double balance;
    Account(Bank bank, double balance) {
        this.bank = bank;
        this.balance = balance;
    }
} 