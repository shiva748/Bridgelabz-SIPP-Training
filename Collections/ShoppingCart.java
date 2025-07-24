package Collections;
import java.util.*;

public class ShoppingCart {
    public Map<String, Integer> prices = new HashMap<>();
    public Map<String, Integer> order = new LinkedHashMap<>();
    public TreeMap<Integer, List<String>> sortedByPrice = new TreeMap<>();

    public void addItem(String item, int price) {
        prices.put(item, price);
        order.put(item, price);
        sortedByPrice.computeIfAbsent(price, k -> new ArrayList<>()).add(item);
    }

    public Map<String, Integer> getPrices() { return prices; }
    public Map<String, Integer> getOrder() { return order; }
    public Map<Integer, List<String>> getSortedByPrice() { return sortedByPrice; }
}
