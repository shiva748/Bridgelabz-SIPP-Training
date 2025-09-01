public class PaymentGatewayIntegration {
    public static void main(String[] args) {
        PaymentProcessor paypal = new PayPal();
        PaymentProcessor stripe = new Stripe();

        paypal.processPayment(100.00);
        stripe.processPayment(200.00);

        System.out.println("---");

        paypal.refund(50.00);
        stripe.refund(75.00);
    }
}
