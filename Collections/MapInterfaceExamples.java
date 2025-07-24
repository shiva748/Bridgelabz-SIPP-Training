package Collections;
import java.util.*;

public class MapInterfaceExamples {
    public static Map<String, Integer> wordFrequency(String text) {
        Map<String, Integer> map = new HashMap<>();
        text = text.replaceAll("[^a-zA-Z0-9 ]", " ").toLowerCase();
        for (String w : text.split("\\s+")) if (!w.isEmpty()) map.put(w, map.getOrDefault(w, 0) + 1);
        return map;
    }

    public static <K, V> Map<V, List<K>> invertMap(Map<K, V> map) {
        Map<V, List<K>> inv = new HashMap<>();
        for (Map.Entry<K, V> e : map.entrySet()) {
            inv.computeIfAbsent(e.getValue(), k -> new ArrayList<>()).add(e.getKey());
        }
        return inv;
    }

    public static String keyWithMaxValue(Map<String, Integer> map) {
        String maxKey = null;
        int max = Integer.MIN_VALUE;
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            if (e.getValue() > max) { max = e.getValue(); maxKey = e.getKey(); }
        }
        return maxKey;
    }

    public static Map<String, Integer> mergeMaps(Map<String, Integer> m1, Map<String, Integer> m2) {
        Map<String, Integer> res = new HashMap<>(m1);
        for (Map.Entry<String, Integer> e : m2.entrySet()) res.merge(e.getKey(), e.getValue(), Integer::sum);
        return res;
    }

    public static class Employee {
        String name, dept;
        public Employee(String name, String dept) { this.name = name; this.dept = dept; }
    }

    public static Map<String, List<String>> groupByDepartment(List<Employee> employees) {
        Map<String, List<String>> map = new HashMap<>();
        for (Employee e : employees) map.computeIfAbsent(e.dept, k -> new ArrayList<>()).add(e.name);
        return map;
    }
}
