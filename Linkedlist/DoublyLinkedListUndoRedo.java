package Linkedlist;
class StateNode {
    String text;
    StateNode next;
    StateNode prev;
    public StateNode(String text) {
        this.text = text;
    }
}
class DoublyLinkedListUndoRedo {
    private StateNode head;
    private StateNode tail;
    private StateNode current;
    private int size;
    private int maxSize = 10;
    public void addState(String text) {
        StateNode node = new StateNode(text);
        if (head == null) {
            head = tail = current = node;
            size = 1;
        } else {
            if (current != tail) {
                StateNode temp = current.next;
                while (temp != null) {
                    StateNode next = temp.next;
                    temp.prev = temp.next = null;
                    temp = next;
                    size--;
                }
                current.next = null;
                tail = current;
            }
            tail.next = node;
            node.prev = tail;
            tail = node;
            current = node;
            size++;
            if (size > maxSize) {
                head = head.next;
                head.prev = null;
                size--;
            }
        }
    }
    public void undo() {
        if (current != null && current.prev != null) current = current.prev;
    }
    public void redo() {
        if (current != null && current.next != null) current = current.next;
    }
    public void displayCurrent() {
        if (current != null) System.out.println(current.text);
    }
    public static void main(String[] args) {
        DoublyLinkedListUndoRedo editor = new DoublyLinkedListUndoRedo();
        editor.addState("Hello");
        editor.addState("Hello World");
        editor.addState("Hello World!");
        editor.displayCurrent();
        editor.undo();
        editor.displayCurrent();
        editor.redo();
        editor.displayCurrent();
        for (int i = 0; i < 12; i++) editor.addState("State " + i);
        editor.displayCurrent();
    }
} 