package StackQueueHash;
import java.util.Deque;
import java.util.LinkedList;
class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        Deque<Integer> dq = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            while (!dq.isEmpty() && dq.peekFirst() <= i - k) dq.pollFirst();
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) dq.pollLast();
            dq.offerLast(i);
            if (i >= k - 1) res[i - k + 1] = nums[dq.peekFirst()];
        }
        return res;
    }
    public static void main(String[] args) {
        SlidingWindowMaximum s = new SlidingWindowMaximum();
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int[] res = s.maxSlidingWindow(nums, 3);
        for (int x : res) System.out.print(x + " ");
    }
} 