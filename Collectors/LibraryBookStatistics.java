import java.util.*;
import java.util.stream.Collectors;

public class LibraryBookStatistics {
    public static void main(String[] args) {
        List<Book> books = Arrays.asList(
                new Book("Book1", "Fiction", 300),
                new Book("Book2", "Fiction", 250),
                new Book("Book3", "Non-Fiction", 400),
                new Book("Book4", "Non-Fiction", 350));

        Map<String, IntSummaryStatistics> bookStats = books.stream()
                .collect(Collectors.groupingBy(Book::getGenre,
                        Collectors.summarizingInt(Book::getPages)));

        bookStats.forEach((genre, stats) -> {
            System.out.println("Genre: " + genre);
            System.out.println("  Total pages: " + stats.getSum());
            System.out.println("  Average pages: " + stats.getAverage());
            System.out.println("  Max pages: " + stats.getMax());
            System.out.println();
        });
    }
}

class Book {
    private String title;
    private String genre;
    private int pages;

    public Book(String title, String genre, int pages) {
        this.title = title;
        this.genre = genre;
        this.pages = pages;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public int getPages() {
        return pages;
    }
}
