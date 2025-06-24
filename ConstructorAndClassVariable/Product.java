public class Product {
    String productName;
    double price;
    static int totalProducts = 0;
    Product(String productName, double price) {
        this.productName = productName;
        this.price = price;
        totalProducts++;
    }
    void displayProductDetails() {
        System.out.println(productName + " " + price);
    }
    static void displayTotalProducts() {
        System.out.println(totalProducts);
    }
    public static void main(String[] args) {
        Product p1 = new Product("Pen", 10);
        Product p2 = new Product("Book", 50);
        p1.displayProductDetails();
        p2.displayProductDetails();
        Product.displayTotalProducts();
    }
} 