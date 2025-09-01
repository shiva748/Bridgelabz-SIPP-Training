import java.util.*;
import java.util.stream.Collectors;

public class OrderRevenueSummary {
    public static void main(String[] args) {
        List<Order> orders = Arrays.asList(
                new Order("Customer1", 100.0),
                new Order("Customer2", 150.0),
                new Order("Customer1", 200.0));

        Map<String, Double> revenueSummary = orders.stream()
                .collect(Collectors.groupingBy(Order::getCustomer,
                        Collectors.summingDouble(Order::getTotal)));

        System.out.println(revenueSummary);
    }
}

class Order {
    private String customer;
    private double total;

    public Order(String customer, double total) {
        this.customer = customer;
        this.total = total;
    }

    public String getCustomer() {
        return customer;
    }

    public double getTotal() {
        return total;
    }
}
