import java.util.ArrayList;
public class Library {
    String name;
    ArrayList<Book> books;
    Library(String name) {
        this.name = name;
        this.books = new ArrayList<>();
    }
    void addBook(Book book) {
        books.add(book);
    }
    void displayBooks() {
        System.out.println("Library: " + name);
        for (Book book : books) {
            System.out.println(book.title + " by " + book.author);
        }
    }
    public static void main(String[] args) {
        Book b1 = new Book("Java", "James Gosling");
        Book b2 = new Book("Python", "Guido van Rossum");
        Library lib1 = new Library("Central Library");
        Library lib2 = new Library("City Library");
        lib1.addBook(b1);
        lib1.addBook(b2);
        lib2.addBook(b1);
        lib1.displayBooks();
        lib2.displayBooks();
    }
}
class Book {
    String title;
    String author;
    Book(String title, String author) {
        this.title = title;
        this.author = author;
    }
} 