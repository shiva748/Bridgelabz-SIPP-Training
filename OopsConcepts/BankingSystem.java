abstract class BankAccount {
    private String accountNumber;
    private String holderName;
    private double balance;
    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }
    public String getAccountNumber() { return accountNumber; }
    public void setAccountNumber(String accountNumber) { this.accountNumber = accountNumber; }
    public String getHolderName() { return holderName; }
    public void setHolderName(String holderName) { this.holderName = holderName; }
    public double getBalance() { return balance; }
    public void setBalance(double balance) { this.balance = balance; }
    public void deposit(double amount) { balance += amount; }
    public void withdraw(double amount) { if (balance >= amount) balance -= amount; }
    public abstract double calculateInterest();
}
interface Loanable {
    void applyForLoan(double amount);
    boolean calculateLoanEligibility();
}
class SavingsAccount extends BankAccount implements Loanable {
    public SavingsAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }
    public double calculateInterest() {
        return getBalance() * 0.04;
    }
    public void applyForLoan(double amount) {}
    public boolean calculateLoanEligibility() { return getBalance() > 10000; }
}
class CurrentAccount extends BankAccount implements Loanable {
    public CurrentAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }
    public double calculateInterest() {
        return getBalance() * 0.02;
    }
    public void applyForLoan(double amount) {}
    public boolean calculateLoanEligibility() { return getBalance() > 20000; }
}
class BankingDemo {
    public static void main(String[] args) {
        BankAccount[] accounts = new BankAccount[2];
        accounts[0] = new SavingsAccount("A101", "John", 15000);
        accounts[1] = new CurrentAccount("A102", "Jane", 30000);
        for (BankAccount acc : accounts) {
            System.out.println("Account: " + acc.getAccountNumber() + ", Holder: " + acc.getHolderName());
            System.out.println("Interest: " + acc.calculateInterest());
            System.out.println("Eligible for Loan: " + ((Loanable)acc).calculateLoanEligibility());
        }
    }
} 