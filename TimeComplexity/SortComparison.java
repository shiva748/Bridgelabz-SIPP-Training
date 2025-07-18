import java.util.*;
public class SortComparison {
    static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (arr[j] > arr[j+1]) {
                    int t = arr[j]; arr[j] = arr[j+1]; arr[j+1] = t;
                }
    }
    static void mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            mergeSort(arr, l, m);
            mergeSort(arr, m+1, r);
            int[] t = new int[r-l+1];
            int i = l, j = m+1, k = 0;
            while (i <= m && j <= r) t[k++] = arr[i] < arr[j] ? arr[i++] : arr[j++];
            while (i <= m) t[k++] = arr[i++];
            while (j <= r) t[k++] = arr[j++];
            for (i = l, k = 0; i <= r; i++, k++) arr[i] = t[k];
        }
    }
    static void quickSort(int[] arr, int l, int r) {
        if (l < r) {
            int p = arr[r], i = l-1;
            for (int j = l; j < r; j++) if (arr[j] < p) { i++; int t = arr[i]; arr[i] = arr[j]; arr[j] = t; }
            int t = arr[i+1]; arr[i+1] = arr[r]; arr[r] = t;
            quickSort(arr, l, i);
            quickSort(arr, i+2, r);
        }
    }
    public static void main(String[] args) {
        int[] sizes = {1000, 10000, 1000000};
        Random rand = new Random();
        for (int n : sizes) {
            int[] arr1 = new int[n], arr2 = new int[n], arr3 = new int[n];
            for (int i = 0; i < n; i++) arr1[i] = arr2[i] = arr3[i] = rand.nextInt();
            long start = System.nanoTime();
            if (n <= 10000) bubbleSort(arr1);
            long bubble = System.nanoTime() - start;
            start = System.nanoTime();
            mergeSort(arr2, 0, n-1);
            long merge = System.nanoTime() - start;
            start = System.nanoTime();
            quickSort(arr3, 0, n-1);
            long quick = System.nanoTime() - start;
            System.out.println(n+" " + bubble/1e6 + "ms " + merge/1e6 + "ms " + quick/1e6 + "ms");
        }
    }
} 