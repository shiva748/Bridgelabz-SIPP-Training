abstract class Product {
    private int productId;
    private String name;
    private double price;
    public Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }
    public int getProductId() { return productId; }
    public void setProductId(int productId) { this.productId = productId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    public abstract double calculateDiscount();
}
interface Taxable {
    double calculateTax();
    String getTaxDetails();
}
class Electronics extends Product implements Taxable {
    public Electronics(int productId, String name, double price) {
        super(productId, name, price);
    }
    public double calculateDiscount() {
        return getPrice() * 0.1;
    }
    public double calculateTax() {
        return getPrice() * 0.18;
    }
    public String getTaxDetails() {
        return "18% GST";
    }
}
class Clothing extends Product implements Taxable {
    public Clothing(int productId, String name, double price) {
        super(productId, name, price);
    }
    public double calculateDiscount() {
        return getPrice() * 0.2;
    }
    public double calculateTax() {
        return getPrice() * 0.05;
    }
    public String getTaxDetails() {
        return "5% GST";
    }
}
class Groceries extends Product {
    public Groceries(int productId, String name, double price) {
        super(productId, name, price);
    }
    public double calculateDiscount() {
        return getPrice() * 0.05;
    }
}
class ECommerceDemo {
    public static void printFinalPrice(Product[] products) {
        for (Product p : products) {
            double tax = 0;
            if (p instanceof Taxable) {
                tax = ((Taxable)p).calculateTax();
            }
            double discount = p.calculateDiscount();
            double finalPrice = p.getPrice() + tax - discount;
            System.out.println(p.getName() + ": Final Price = " + finalPrice);
        }
    }
    public static void main(String[] args) {
        Product[] products = new Product[3];
        products[0] = new Electronics(1, "Laptop", 50000);
        products[1] = new Clothing(2, "Shirt", 2000);
        products[2] = new Groceries(3, "Rice", 1000);
        printFinalPrice(products);
    }
} 