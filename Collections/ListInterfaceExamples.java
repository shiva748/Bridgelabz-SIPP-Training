
package Collections;
import java.util.*;

public class ListInterfaceExamples {
    public static <T> List<T> reverseList(List<T> list) {
        List<T> result = new ArrayList<>();
        for (int i = list.size() - 1; i >= 0; i--) result.add(list.get(i));
        return result;
    }

    public static <T> LinkedList<T> reverseLinkedList(LinkedList<T> list) {
        LinkedList<T> result = new LinkedList<>();
        ListIterator<T> it = list.listIterator(list.size());
        while (it.hasPrevious()) result.add(it.previous());
        return result;
    }

    public static Map<String, Integer> frequency(List<String> list) {
        Map<String, Integer> map = new HashMap<>();
        for (String s : list) map.put(s, map.getOrDefault(s, 0) + 1);
        return map;
    }

    public static <T> List<T> rotate(List<T> list, int k) {
        int n = list.size();
        List<T> result = new ArrayList<>();
        for (int i = 0; i < n; i++) result.add(list.get((i + k) % n));
        return result;
    }

    public static <T> List<T> removeDuplicates(List<T> list) {
        Set<T> seen = new HashSet<>();
        List<T> result = new ArrayList<>();
        for (T t : list) if (seen.add(t)) result.add(t);
        return result;
    }

    public static <T> T nthFromEnd(LinkedList<T> list, int n) {
        Iterator<T> fast = list.iterator();
        Iterator<T> slow = list.iterator();
        for (int i = 0; i < n; i++) fast.next();
        while (fast.hasNext()) { fast.next(); slow.next(); }
        return slow.next();
    }
}
