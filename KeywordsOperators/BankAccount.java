public class BankAccount {
    static String bankName = "ABC Bank";
    static int totalAccounts = 0;
    final String accountNumber;
    String accountHolderName;
    double balance;
    BankAccount(String accountHolderName, String accountNumber, double balance) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.balance = balance;
        totalAccounts++;
    }
    static void getTotalAccounts() {
        System.out.println("Total Accounts: " + totalAccounts);
    }
    void displayDetails() {
        if (this instanceof BankAccount) {
            System.out.println("Bank: " + bankName);
            System.out.println("Account Holder: " + accountHolderName);
            System.out.println("Account Number: " + accountNumber);
            System.out.println("Balance: " + balance);
        }
    }
    public static void main(String[] args) {
        BankAccount acc1 = new BankAccount("John", "12345", 1000);
        BankAccount acc2 = new BankAccount("Alice", "67890", 2000);
        acc1.displayDetails();
        acc2.displayDetails();
        BankAccount.getTotalAccounts();
    }
} 