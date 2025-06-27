public class Product {
    static double discount = 10;
    final int productID;
    String productName;
    double price;
    int quantity;
    Product(int productID, String productName, double price, int quantity) {
        this.productID = productID;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }
    static void updateDiscount(double newDiscount) {
        discount = newDiscount;
    }
    void displayDetails() {
        if (this instanceof Product) {
            System.out.println("Product ID: " + productID);
            System.out.println("Name: " + productName);
            System.out.println("Price: " + price);
            System.out.println("Quantity: " + quantity);
            System.out.println("Discount: " + discount + "%");
        }
    }
    public static void main(String[] args) {
        Product p1 = new Product(1, "Book", 500, 2);
        Product p2 = new Product(2, "Pen", 20, 10);
        p1.displayDetails();
        p2.displayDetails();
        Product.updateDiscount(15);
        p1.displayDetails();
    }
} 