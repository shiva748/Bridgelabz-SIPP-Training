public class Book {
    String title;
    String author;
    double price;
    Book() {
        title = "Unknown";
        author = "Unknown";
        price = 0;
    }
    Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }
    public static void main(String[] args) {
        Book b1 = new Book();
        Book b2 = new Book("Java", "James Gosling", 499);
        System.out.println(b1.title + " " + b1.author + " " + b1.price);
        System.out.println(b2.title + " " + b2.author + " " + b2.price);
    }
} 