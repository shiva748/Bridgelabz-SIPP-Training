public class LibraryBook {
    String title;
    String author;
    double price;
    boolean available;
    LibraryBook(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.available = true;
    }
    void borrowBook() {
        if (available) {
            available = false;
            System.out.println("Book borrowed");
        } else {
            System.out.println("Not available");
        }
    }
    public static void main(String[] args) {
        LibraryBook book = new LibraryBook("Java", "James Gosling", 499);
        book.borrowBook();
        book.borrowBook();
    }
} 