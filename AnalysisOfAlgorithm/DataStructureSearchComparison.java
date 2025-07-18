import java.util.*;
public class DataStructureSearchComparison {
    public static void main(String[] args) {
        int[] sizes = {1000, 100000, 1000000};
        Random rand = new Random();
        for (int n : sizes) {
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = rand.nextInt();
            int target = arr[rand.nextInt(n)];
            long start = System.nanoTime();
            for (int i = 0; i < n; i++) if (arr[i] == target) break;
            long arrTime = System.nanoTime() - start;
            HashSet<Integer> hs = new HashSet<>();
            for (int v : arr) hs.add(v);
            start = System.nanoTime();
            hs.contains(target);
            long hsTime = System.nanoTime() - start;
            TreeSet<Integer> ts = new TreeSet<>();
            for (int v : arr) ts.add(v);
            start = System.nanoTime();
            ts.contains(target);
            long tsTime = System.nanoTime() - start;
            System.out.println(n + " " + arrTime / 1e6 + "ms " + hsTime / 1e6 + "ms " + tsTime / 1e6 + "ms");
        }
    }
} 