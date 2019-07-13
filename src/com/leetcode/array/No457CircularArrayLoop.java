package com.leetcode.array;

public class No457CircularArrayLoop {
    // https://leetcode.com/problems/circular-array-loop/discuss/94148/Java-SlowFast-Pointer-Solution
    public boolean circularArrayLoop(int[] nums) {
        final int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) continue;

            int slow = i, fast = next(nums, i), sign = nums[i] > 0 ? 1 : -1;
            while (sign * nums[fast] > 0 && sign * nums[next(nums, fast)] > 0) {
                if (slow == fast) {
                    if (slow == next(nums, slow)) break;
                    return true;
                }

                slow = next(nums, slow);
                fast = next(nums, next(nums, fast));
            }

            slow = i;
            while (sign * nums[slow] > 0) {
                int next = next(nums, slow);
                nums[slow] = 0;
                slow = next;
            }
        }

        return false;
    }

    private int next(int[] nums, int i) {
        final int n = nums.length, next = (i + nums[i]) % n;
        return next < 0 ? (n + next) : next;
    }
}
