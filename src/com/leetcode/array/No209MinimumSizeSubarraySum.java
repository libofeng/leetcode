package com.leetcode.array;

public class No209MinimumSizeSubarraySum {
    // O(N)
    public int minSubArrayLen(int s, int[] nums) {
        if (nums.length == 0) return 0;

        int start = 0, sum = 0, minLen = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            while (sum >= s) {
                minLen = Math.min(minLen, i - start + 1);
                sum -= nums[start++];
            }
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    public int minSubArrayLen2(int s, int[] nums) {
        final int n = nums.length;
        final int[] sums = new int[n + 1];
        for (int i = 1; i <= n; i++) sums[i] = sums[i - 1] + nums[i - 1];

        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i <= n; i++) {
            int index = findIndex(sums, i, sums[i] + s);
            if (index == n + 1) break;// it means no sum>=target
            if (index - i < minLen) minLen = index - i;
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    private int findIndex(int[] sums, int start, int target) {
        int lo = start, hi = sums.length; // inorder to reach the end when there is no sum>=target
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (sums[mid] >= target) hi = mid;
            else lo = mid + 1;
        }

        return lo;
    }
}
