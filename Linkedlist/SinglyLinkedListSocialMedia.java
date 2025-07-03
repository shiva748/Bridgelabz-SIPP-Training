package Linkedlist;
import java.util.ArrayList;
class FriendNode {
    int userId;
    String name;
    int age;
    ArrayList<Integer> friends;
    FriendNode next;
    public FriendNode(int userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.friends = new ArrayList<>();
    }
}
class SinglyLinkedListSocialMedia {
    private FriendNode head;
    public void addUser(int userId, String name, int age) {
        FriendNode node = new FriendNode(userId, name, age);
        if (head == null) head = node;
        else {
            FriendNode curr = head;
            while (curr.next != null) curr = curr.next;
            curr.next = node;
        }
    }
    public FriendNode findUser(int userId) {
        FriendNode curr = head;
        while (curr != null) {
            if (curr.userId == userId) return curr;
            curr = curr.next;
        }
        return null;
    }
    public FriendNode findUserByName(String name) {
        FriendNode curr = head;
        while (curr != null) {
            if (curr.name.equals(name)) return curr;
            curr = curr.next;
        }
        return null;
    }
    public void addFriend(int userId1, int userId2) {
        FriendNode u1 = findUser(userId1);
        FriendNode u2 = findUser(userId2);
        if (u1 != null && u2 != null && !u1.friends.contains(userId2)) {
            u1.friends.add(userId2);
            u2.friends.add(userId1);
        }
    }
    public void removeFriend(int userId1, int userId2) {
        FriendNode u1 = findUser(userId1);
        FriendNode u2 = findUser(userId2);
        if (u1 != null && u2 != null) {
            u1.friends.remove((Integer)userId2);
            u2.friends.remove((Integer)userId1);
        }
    }
    public ArrayList<Integer> mutualFriends(int userId1, int userId2) {
        FriendNode u1 = findUser(userId1);
        FriendNode u2 = findUser(userId2);
        ArrayList<Integer> mutual = new ArrayList<>();
        if (u1 != null && u2 != null) {
            for (int id : u1.friends) {
                if (u2.friends.contains(id)) mutual.add(id);
            }
        }
        return mutual;
    }
    public void displayFriends(int userId) {
        FriendNode user = findUser(userId);
        if (user != null) {
            for (int id : user.friends) System.out.print(id + " ");
            System.out.println();
        }
    }
    public void searchUser(String name) {
        FriendNode user = findUserByName(name);
        if (user != null) System.out.println(user.userId + " " + user.name + " " + user.age);
    }
    public void searchUser(int userId) {
        FriendNode user = findUser(userId);
        if (user != null) System.out.println(user.userId + " " + user.name + " " + user.age);
    }
    public int countFriends(int userId) {
        FriendNode user = findUser(userId);
        if (user != null) return user.friends.size();
        return 0;
    }
    public static void main(String[] args) {
        SinglyLinkedListSocialMedia sm = new SinglyLinkedListSocialMedia();
        sm.addUser(1, "Alice", 20);
        sm.addUser(2, "Bob", 22);
        sm.addUser(3, "Charlie", 21);
        sm.addFriend(1, 2);
        sm.addFriend(1, 3);
        sm.displayFriends(1);
        sm.displayFriends(2);
        sm.removeFriend(1, 2);
        sm.displayFriends(1);
        sm.displayFriends(2);
        System.out.println(sm.mutualFriends(1, 3));
        sm.searchUser("Alice");
        sm.searchUser(3);
        System.out.println(sm.countFriends(1));
    }
} 