package Linkedlist;

class BookNode {
    int bookId;
    String title;
    String author;
    BookNode next;
    BookNode prev;
    public BookNode(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }
}
class DoublyLinkedListLibrary {
    private BookNode head;
    private BookNode tail;
    private int count;
    public void addBook(int bookId, String title, String author) {
        BookNode node = new BookNode(bookId, title, author);
        if (head == null) {
            head = tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
        count++;
    }
    public void removeBook(int bookId) {
        BookNode curr = head;
        while (curr != null) {
            if (curr.bookId == bookId) {
                if (curr.prev != null) curr.prev.next = curr.next;
                else head = curr.next;
                if (curr.next != null) curr.next.prev = curr.prev;
                else tail = curr.prev;
                count--;
                break;
            }
            curr = curr.next;
        }
    }
    public void displayForward() {
        BookNode curr = head;
        while (curr != null) {
            System.out.println(curr.bookId + " " + curr.title + " " + curr.author);
            curr = curr.next;
        }
    }
    public void displayReverse() {
        BookNode curr = tail;
        while (curr != null) {
            System.out.println(curr.bookId + " " + curr.title + " " + curr.author);
            curr = curr.prev;
        }
    }
    public int countBooks() {
        return count;
    }
    public static void main(String[] args) {
        DoublyLinkedListLibrary lib = new DoublyLinkedListLibrary();
        lib.addBook(1, "Java", "James");
        lib.addBook(2, "Python", "Guido");
        lib.addBook(3, "C++", "Bjarne");
        lib.displayForward();
        lib.displayReverse();
        lib.removeBook(2);
        lib.displayForward();
        System.out.println(lib.countBooks());
    }
} 