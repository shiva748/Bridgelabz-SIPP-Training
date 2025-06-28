import java.util.*;

public class BookBuddyMain
{
	public static void main(String[] args) {
		BookBuddy ap = new BookBuddy();
		ap.addBook("j", "shiva");
		ap.addBook("k", "tapesh");
		ap.addBook("b", "shiva");
		ap.addBook("a", "shiva");
		ap.addBook("x", "shiva");
		System.out.println(ap.SearchByAuthor("tapesh"));
		System.out.println(Arrays.toString(ap.display()));
		ap.sort();
		System.out.println(Arrays.toString(ap.display()));
	}
}

class BookBuddy {
    List<String> shelf;

    BookBuddy() {
        shelf = new ArrayList<>();
    }

    boolean addBook(String title, String author) {
        shelf.add(title + "-" + author);
        return true;
    }

    String SearchByAuthor(String author) {
        for (int i = 0; i < shelf.size(); i++) {
            if (shelf.get(i).split("-")[1].equals(author)) {
                return shelf.get(i);
            }
        }
        return "No Book Found";
    }

    void sort() {
        for (int i = 0; i < shelf.size(); i++) {
            for (int j = 0; j < shelf.size() - 1; j++) {
                if (shelf.get(j).split("-")[0].compareTo(shelf.get(j + 1).split("-")[0]) > 0) {
                    String temp = shelf.get(j);
                    shelf.set(j, shelf.get(j + 1));
                    shelf.set(j + 1, temp);
                }
            }
        }
    }

    String[] display() {
        return shelf.toArray(new String[0]);
    }
}
