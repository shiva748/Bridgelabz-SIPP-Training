public class CartItem {
    String itemName;
    double price;
    int quantity;
    CartItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
    void addItem(int qty) {
        quantity += qty;
    }
    void removeItem(int qty) {
        if (qty <= quantity) {
            quantity -= qty;
        } else {
            quantity = 0;
        }
    }
    double totalCost() {
        return price * quantity;
    }
    void displayTotalCost() {
        System.out.println("Item: " + itemName);
        System.out.println("Price: " + price);
        System.out.println("Quantity: " + quantity);
        System.out.println("Total Cost: " + totalCost());
    }
    public static void main(String[] args) {
        CartItem cart = new CartItem("Book", 200, 2);
        cart.addItem(3);
        cart.removeItem(1);
        cart.displayTotalCost();
    }
} 