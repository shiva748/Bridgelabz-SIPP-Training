package StackQueueHash;
import java.util.*;
class PairGivenSum {
    public boolean hasPair(int[] arr, int target) {
        Set<Integer> set = new HashSet<>();
        for (int x : arr) {
            if (set.contains(target - x)) return true;
            set.add(x);
        }
        return false;
    }
    public static void main(String[] args) {
        PairGivenSum p = new PairGivenSum();
        int[] arr = {8, 7, 2, 5, 3, 1};
        System.out.println(p.hasPair(arr, 10));
        System.out.println(p.hasPair(arr, 19));
    }
} 