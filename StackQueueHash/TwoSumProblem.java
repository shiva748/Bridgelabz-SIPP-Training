package StackQueueHash;
import java.util.*;
class TwoSumProblem {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (map.containsKey(diff)) return new int[]{map.get(diff), i};
            map.put(nums[i], i);
        }
        return new int[0];
    }
    public static void main(String[] args) {
        TwoSumProblem t = new TwoSumProblem();
        int[] nums = {2, 7, 11, 15};
        int[] res = t.twoSum(nums, 9);
        if (res.length == 2) System.out.println(res[0] + " " + res[1]);
    }
} 