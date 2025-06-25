public class BankAccount {
    String accountHolder;
    String accountNumber;
    double balance;
    BankAccount(String accountHolder, String accountNumber, double balance) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
    void deposit(double amount) {
        balance += amount;
    }
    void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Insufficient balance");
        }
    }
    void displayBalance() {
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: " + balance);
    }
    public static void main(String[] args) {
        BankAccount acc = new BankAccount("Bob", "123456", 1000);
        acc.deposit(500);
        acc.withdraw(200);
        acc.displayBalance();
    }.
} 