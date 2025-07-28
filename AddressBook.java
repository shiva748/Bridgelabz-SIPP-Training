import java.io.*;
import java.util.*;

public class AddressBook<T extends AddressBook.Contact> {
    public static class Contact {
        String name;
        String phone;
        String email;
        String address;
        public Contact(String name, String phone, String email, String address) {
            this.name = name;
            this.phone = phone;
            this.email = email;
            this.address = address;
        }
    }
    public Map<String, T> contacts = new HashMap<>();
    public void addContact(T c) { contacts.put(c.name, c); }
    public void removeContact(String name) { contacts.remove(name); }
    public T searchByName(String name) { return contacts.get(name); }
    public T searchByPhone(String phone) {
        for (T c : contacts.values()) if (c.phone.equals(phone)) return c;
        return null;
    }
    public List<T> listContacts() { return new ArrayList<>(contacts.values()); }
    public void saveToFile(String file) throws IOException {
        try (ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream(file))) {
            o.writeObject(new ArrayList<>(contacts.values()));
        }
    }
    public void loadFromFile(String file) throws IOException, ClassNotFoundException {
        try (ObjectInputStream o = new ObjectInputStream(new FileInputStream(file))) {
            List<T> list = (List<T>) o.readObject();
            contacts.clear();
            for (T c : list) contacts.put(c.name, c);
        }
    }
    public boolean hasSameAddress(T c1, T c2) { return c1.address.equals(c2.address); }
    public List<T> sortByName() {
        List<T> list = listContacts();
        list.sort(Comparator.comparing(a -> a.name));
        return list;
    }
    public List<T> sortByPhone() {
        List<T> list = listContacts();
        list.sort(Comparator.comparing(a -> a.phone));
        return list;
    }
}
