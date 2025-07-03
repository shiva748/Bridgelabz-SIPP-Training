abstract class FoodItem {
    private String itemName;
    private double price;
    private int quantity;
    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
    public String getItemName() { return itemName; }
    public void setItemName(String itemName) { this.itemName = itemName; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public abstract double calculateTotalPrice();
    public void getItemDetails() {
        System.out.println("Item: " + itemName + ", Price: " + price + ", Quantity: " + quantity);
    }
}
interface Discountable {
    double applyDiscount();
    String getDiscountDetails();
}
class VegItem extends FoodItem implements Discountable {
    public VegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }
    public double calculateTotalPrice() {
        return getPrice() * getQuantity();
    }
    public double applyDiscount() {
        return calculateTotalPrice() * 0.1;
    }
    public String getDiscountDetails() {
        return "10% off";
    }
}
class NonVegItem extends FoodItem implements Discountable {
    public NonVegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }
    public double calculateTotalPrice() {
        return getPrice() * getQuantity() + 20;
    }
    public double applyDiscount() {
        return calculateTotalPrice() * 0.05;
    }
    public String getDiscountDetails() {
        return "5% off";
    }
}
class FoodOrderDemo {
    public static void processOrder(FoodItem[] items) {
        for (FoodItem item : items) {
            item.getItemDetails();
            double total = item.calculateTotalPrice();
            double discount = 0;
            if (item instanceof Discountable) {
                discount = ((Discountable)item).applyDiscount();
            }
            System.out.println("Total: " + (total - discount));
        }
    }
    public static void main(String[] args) {
        FoodItem[] items = new FoodItem[2];
        items[0] = new VegItem("Paneer", 150, 2);
        items[1] = new NonVegItem("Chicken", 200, 1);
        processOrder(items);
    }
} 