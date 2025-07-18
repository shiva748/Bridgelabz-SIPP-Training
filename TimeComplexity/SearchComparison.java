import java.util.*;
public class SearchComparison {
    public static void main(String[] args) {
        int[] sizes = {1000, 10000, 1000000};
        int target = -1;
        Random rand = new Random();
        for (int n : sizes) {
            int[] data = new int[n];
            for (int i = 0; i < n; i++) data[i] = rand.nextInt();
            data[rand.nextInt(n)] = target;
            long start = System.nanoTime();
            for (int i = 0; i < n; i++) if (data[i] == target) break;
            long linearTime = System.nanoTime() - start;
            Arrays.sort(data);
            start = System.nanoTime();
            int l = 0, r = n - 1;
            while (l <= r) {
                int m = l + (r - l) / 2;
                if (data[m] == target) break;
                if (data[m] < target) l = m + 1;
                else r = m - 1;
            }
            long binaryTime = System.nanoTime() - start;
            System.out.println(n+" " + linearTime/1e6 + "ms " + binaryTime/1e6 + "ms");
        }
    }
} 