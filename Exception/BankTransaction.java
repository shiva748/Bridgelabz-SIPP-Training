
class InsufficientBalanceException extends Exception {
 public InsufficientBalanceException(String message) {
     super(message);
 }
}

public class BankTransaction {
 private double balance;

 public BankTransaction(double balance) {
     this.balance = balance;
 }

 public void withdraw(double amount) throws InsufficientBalanceException {
     if (amount < 0) {
         throw new IllegalArgumentException("Invalid amount!");
     }
     if (amount > balance) {
         throw new InsufficientBalanceException("Insufficient balance!");
     }
     balance -= amount;
     System.out.println("Withdrawal successful, new balance: " + balance);
 }

 public static void main(String[] args) {
     BankTransaction account = new BankTransaction(5000);

     try {
         account.withdraw(2000);
         account.withdraw(4000); // triggers exception
     } catch (IllegalArgumentException e) {
         System.out.println(e.getMessage());
     } catch (InsufficientBalanceException e) {
         System.out.println(e.getMessage());
     }
 }
}
