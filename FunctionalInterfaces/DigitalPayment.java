
interface DigitalPayment {
    void pay();
}

class UPI implements DigitalPayment {
    @Override
    public void pay() {
        System.out.println("Payment made using UPI");
    }
}

class CreditCard implements DigitalPayment {
    @Override
    public void pay() {
        System.out.println("Payment made using Credit Card");
    }
}

class Wallet implements DigitalPayment {
    @Override
    public void pay() {
        System.out.println("Payment made using Wallet");
    }
}
