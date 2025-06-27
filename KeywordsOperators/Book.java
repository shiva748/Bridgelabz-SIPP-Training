public class Book {
    static String libraryName = "Central Library";
    final String isbn;
    String title;
    String author;
    Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }
    static void displayLibraryName() {
        System.out.println("Library: " + libraryName);
    }
    void displayDetails() {
        if (this instanceof Book) {
            System.out.println("Title: " + title);
            System.out.println("Author: " + author);
            System.out.println("ISBN: " + isbn);
        }
    }
    public static void main(String[] args) {
        Book b1 = new Book("Java", "James Gosling", "1111");
        Book b2 = new Book("Python", "Guido van Rossum", "2222");
        displayLibraryName();
        b1.displayDetails();
        b2.displayDetails();
    }
} 