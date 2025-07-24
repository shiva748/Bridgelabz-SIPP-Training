
package Collections;
import java.util.*;

public class SetInterfaceExamples {
    public static <T> boolean areSetsEqual(Set<T> s1, Set<T> s2) {
        return s1.equals(s2);
    }

    public static <T> Set<T> union(Set<T> s1, Set<T> s2) {
        Set<T> result = new HashSet<>(s1);
        result.addAll(s2);
        return result;
    }

    public static <T> Set<T> intersection(Set<T> s1, Set<T> s2) {
        Set<T> result = new HashSet<>(s1);
        result.retainAll(s2);
        return result;
    }

    public static <T> Set<T> symmetricDifference(Set<T> s1, Set<T> s2) {
        Set<T> result = new HashSet<>(s1);
        result.addAll(s2);
        Set<T> tmp = new HashSet<>(s1);
        tmp.retainAll(s2);
        result.removeAll(tmp);
        return result;
    }

    public static List<Integer> setToSortedList(Set<Integer> set) {
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        return list;
    }

    public static <T> boolean isSubset(Set<T> s1, Set<T> s2) {
        return s2.containsAll(s1);
    }
}
