interface Category {}
class BookCategory implements Category {}
class ClothingCategory implements Category {}
class GadgetCategory implements Category {}
class Product<T extends Category> {
    private String name;
    private double price;
    private T category;
    public Product(String name, double price, T category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    public String getName() { return name; }
    public T getCategory() { return category; }
}
class DynamicOnlineMarketplace {
    public static <T extends Product<?>> void applyDiscount(T product, double percentage) {
        double discounted = product.getPrice() * (1 - percentage / 100);
        product.setPrice(discounted);
    }
    public static void main(String[] args) {
        Product<BookCategory> book = new Product<>("Book", 200, new BookCategory());
        Product<ClothingCategory> shirt = new Product<>("Shirt", 500, new ClothingCategory());
        applyDiscount(book, 10);
        applyDiscount(shirt, 20);
        System.out.println(book.getName() + " " + book.getPrice());
        System.out.println(shirt.getName() + " " + shirt.getPrice());
    }
} 