abstract class WarehouseItem {}
class Electronics extends WarehouseItem {}
class Groceries extends WarehouseItem {}
class Furniture extends WarehouseItem {}
class Storage<T extends WarehouseItem> {
    private java.util.List<T> items = new java.util.ArrayList<>();
    public void addItem(T item) { items.add(item); }
    public T getItem(int index) { return items.get(index); }
    public static void displayAll(java.util.List<? extends WarehouseItem> items) {
        for (WarehouseItem item : items) {
            System.out.println(item.getClass().getSimpleName());
        }
    }
}
class SmartWarehouseManagementSystem {
    public static void main(String[] args) {
        Storage<Electronics> electronicsStorage = new Storage<>();
        electronicsStorage.addItem(new Electronics());
        Storage<Groceries> groceriesStorage = new Storage<>();
        groceriesStorage.addItem(new Groceries());
        java.util.List<WarehouseItem> allItems = new java.util.ArrayList<>();
        allItems.add(new Electronics());
        allItems.add(new Groceries());
        allItems.add(new Furniture());
        Storage.displayAll(allItems);
    }
} 