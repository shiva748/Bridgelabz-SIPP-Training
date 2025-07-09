package StackQueueHash;
class CustomHashMap<K, V> {
    static class Node<K, V> {
        K key;
        V value;
        Node<K, V> next;
        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
    private int size = 16;
    private Node<K, V>[] table;
    public CustomHashMap() {
        table = new Node[size];
    }
    private int hash(K key) {
        return (key.hashCode() & 0x7fffffff) % size;
    }
    public void put(K key, V value) {
        int idx = hash(key);
        Node<K, V> node = table[idx];
        while (node != null) {
            if (node.key.equals(key)) {
                node.value = value;
                return;
            }
            node = node.next;
        }
        Node<K, V> newNode = new Node<>(key, value);
        newNode.next = table[idx];
        table[idx] = newNode;
    }
    public V get(K key) {
        int idx = hash(key);
        Node<K, V> node = table[idx];
        while (node != null) {
            if (node.key.equals(key)) return node.value;
            node = node.next;
        }
        return null;
    }
    public void remove(K key) {
        int idx = hash(key);
        Node<K, V> node = table[idx], prev = null;
        while (node != null) {
            if (node.key.equals(key)) {
                if (prev == null) table[idx] = node.next;
                else prev.next = node.next;
                return;
            }
            prev = node;
            node = node.next;
        }
    }
    public static void main(String[] args) {
        CustomHashMap<String, Integer> map = new CustomHashMap<>();
        map.put("a", 1);
        map.put("b", 2);
        map.put("c", 3);
        System.out.println(map.get("b"));
        map.remove("b");
        System.out.println(map.get("b"));
    }
} 