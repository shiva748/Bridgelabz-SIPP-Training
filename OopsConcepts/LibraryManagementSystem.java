abstract class LibraryItem {
    private int itemId;
    private String title;
    private String author;
    public LibraryItem(int itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
    }
    public int getItemId() { return itemId; }
    public void setItemId(int itemId) { this.itemId = itemId; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }
    public abstract int getLoanDuration();
    public void getItemDetails() {
        System.out.println("ID: " + itemId + ", Title: " + title + ", Author: " + author);
    }
}
interface Reservable {
    void reserveItem(String borrower);
    boolean checkAvailability();
}
class Book extends LibraryItem implements Reservable {
    private boolean available = true;
    private String borrower;
    public Book(int itemId, String title, String author) {
        super(itemId, title, author);
    }
    public int getLoanDuration() { return 14; }
    public void reserveItem(String borrower) { this.borrower = borrower; available = false; }
    public boolean checkAvailability() { return available; }
}
class Magazine extends LibraryItem implements Reservable {
    private boolean available = true;
    private String borrower;
    public Magazine(int itemId, String title, String author) {
        super(itemId, title, author);
    }
    public int getLoanDuration() { return 7; }
    public void reserveItem(String borrower) { this.borrower = borrower; available = false; }
    public boolean checkAvailability() { return available; }
}
class DVD extends LibraryItem implements Reservable {
    private boolean available = true;
    private String borrower;
    public DVD(int itemId, String title, String author) {
        super(itemId, title, author);
    }
    public int getLoanDuration() { return 3; }
    public void reserveItem(String borrower) { this.borrower = borrower; available = false; }
    public boolean checkAvailability() { return available; }
}
class LibraryDemo {
    public static void main(String[] args) {
        LibraryItem[] items = new LibraryItem[3];
        items[0] = new Book(1, "Java", "James");
        items[1] = new Magazine(2, "Tech", "Alice");
        items[2] = new DVD(3, "Movie", "Bob");
        for (LibraryItem item : items) {
            item.getItemDetails();
            System.out.println("Loan Duration: " + item.getLoanDuration());
            ((Reservable)item).reserveItem("User1");
            System.out.println("Available: " + ((Reservable)item).checkAvailability());
        }
    }
} 