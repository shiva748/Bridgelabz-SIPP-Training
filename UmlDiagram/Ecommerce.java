import java.util.ArrayList;
public class Ecommerce {
    String name;
    ArrayList<Customer> customers;
    ArrayList<Product> products;
    Ecommerce(String name) {
        this.name = name;
        this.customers = new ArrayList<>();
        this.products = new ArrayList<>();
    }
    void addCustomer(Customer customer) {
        customers.add(customer);
    }
    void addProduct(Product product) {
        products.add(product);
    }
    void displayInfo() {
        System.out.println("E-commerce: " + name);
        System.out.println("Customers:");
        for (Customer customer : customers) {
            System.out.println("  " + customer.name);
            customer.displayOrders();
        }
    }
    public static void main(String[] args) {
        Ecommerce platform = new Ecommerce("MyShop");
        Customer c1 = new Customer("John");
        Customer c2 = new Customer("Alice");
        Product p1 = new Product("Laptop", 50000);
        Product p2 = new Product("Phone", 20000);
        Product p3 = new Product("Book", 500);
        platform.addCustomer(c1);
        platform.addCustomer(c2);
        platform.addProduct(p1);
        platform.addProduct(p2);
        platform.addProduct(p3);
        Order order1 = new Order();
        order1.addProduct(p1);
        order1.addProduct(p2);
        c1.placeOrder(order1);
        Order order2 = new Order();
        order2.addProduct(p3);
        c2.placeOrder(order2);
        platform.displayInfo();
    }
}
class Customer {
    String name;
    ArrayList<Order> orders;
    Customer(String name) {
        this.name = name;
        this.orders = new ArrayList<>();
    }
    void placeOrder(Order order) {
        orders.add(order);
        System.out.println(name + " placed an order");
    }
    void displayOrders() {
        for (Order order : orders) {
            System.out.println("    Order Total: " + order.getTotal());
        }
    }
}
class Order {
    ArrayList<Product> products;
    Order() {
        this.products = new ArrayList<>();
    }
    void addProduct(Product product) {
        products.add(product);
    }
    double getTotal() {
        double total = 0;
        for (Product product : products) {
            total += product.price;
        }
        return total;
    }
}
class Product {
    String name;
    double price;
    Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
} 