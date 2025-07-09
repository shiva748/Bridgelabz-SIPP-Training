package StackQueueHash;
import java.util.*;
class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int x : nums) set.add(x);
        int maxLen = 0;
        for (int x : set) {
            if (!set.contains(x - 1)) {
                int y = x;
                int len = 1;
                while (set.contains(y + 1)) {
                    y++;
                    len++;
                }
                if (len > maxLen) maxLen = len;
            }
        }
        return maxLen;
    }
    public static void main(String[] args) {
        LongestConsecutiveSequence l = new LongestConsecutiveSequence();
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println(l.longestConsecutive(nums));
    }
} 