import java.util.*;
public class SearchComparison {
    public static void main(String[] args) {
        int[] sizes = {1000, 10000, 1000000};
        Random rand = new Random();
        for (int n : sizes) {
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = rand.nextInt();
            int target = arr[rand.nextInt(n)];
            long start = System.nanoTime();
            for (int i = 0; i < n; i++) if (arr[i] == target) break;
            long linearTime = System.nanoTime() - start;
            Arrays.sort(arr);
            start = System.nanoTime();
            int l = 0, r = n - 1;
            while (l <= r) {
                int m = l + (r - l) / 2;
                if (arr[m] == target) break;
                if (arr[m] < target) l = m + 1;
                else r = m - 1;
            }
            long binaryTime = System.nanoTime() - start;
            System.out.println(n + " " + linearTime / 1e6 + "ms " + binaryTime / 1e6 + "ms");
        }
    }
} 