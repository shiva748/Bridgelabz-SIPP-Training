class Order {
    String orderId;
    String orderDate;

    Order(String orderId, String orderDate) {
        this.orderId = orderId;
        this.orderDate = orderDate;
    }

    String getOrderStatus() {
        return "Order placed";
    }
}

class ShippedOrder extends Order {
    String trackingNumber;

    ShippedOrder(String orderId, String orderDate, String trackingNumber) {
        super(orderId, orderDate);
        this.trackingNumber = trackingNumber;
    }

    String getOrderStatus() {
        return "Order shipped with tracking number: " + trackingNumber;
    }
}

class DeliveredOrder extends ShippedOrder {
    String deliveryDate;

    DeliveredOrder(String orderId, String orderDate, String trackingNumber, String deliveryDate) {
        super(orderId, orderDate, trackingNumber);
        this.deliveryDate = deliveryDate;
    }

    String getOrderStatus() {
        return "Order delivered on: " + deliveryDate;
    }
}

public class RetailManager {
    public static void main(String[] args) {
        DeliveredOrder deliveredOrder = new DeliveredOrder("ORD123", "2025-06-28", "TRK789", "2025-07-01");
        System.out.println("Order ID: " + deliveredOrder.orderId);
        System.out.println("Order Date: " + deliveredOrder.orderDate);
        System.out.println("Tracking Number: " + deliveredOrder.trackingNumber);
        System.out.println("Delivery Date: " + deliveredOrder.deliveryDate);
        System.out.println("Status: " + deliveredOrder.getOrderStatus());
    }
}
