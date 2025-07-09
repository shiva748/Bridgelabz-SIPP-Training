package StackQueueHash;
import java.util.*;
class SubarraysZeroSum {
    public List<int[]> findSubarrays(int[] arr) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<int[]> res = new ArrayList<>();
        int sum = 0;
        map.put(0, new ArrayList<>());
        map.get(0).add(-1);
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (map.containsKey(sum)) {
                for (int idx : map.get(sum)) {
                    res.add(new int[]{idx + 1, i});
                }
            }
            map.putIfAbsent(sum, new ArrayList<>());
            map.get(sum).add(i);
        }
        return res;
    }
    public static void main(String[] args) {
        SubarraysZeroSum s = new SubarraysZeroSum();
        int[] arr = {3, 4, -7, 1, 3, 3, 1, -4};
        List<int[]> res = s.findSubarrays(arr);
        for (int[] p : res) System.out.println(p[0] + " " + p[1]);
    }
} 