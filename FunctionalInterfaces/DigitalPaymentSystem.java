public class DigitalPaymentSystem {
    public static void main(String[] args) {
        UPI upi = new UPI();
        CreditCard creditCard = new CreditCard();
        Wallet wallet = new Wallet();

        upi.pay();
        creditCard.pay();
        wallet.pay();
    }
}
