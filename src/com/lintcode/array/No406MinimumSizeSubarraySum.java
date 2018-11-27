package com.lintcode.array;

public class No406MinimumSizeSubarraySum {
    /**
     * @param nums: an array of integers
     * @param s:    An integer
     * @return: an integer representing the minimum size of subarray
     */
    public int minimumSize(int[] nums, int s) {
        int l = 1, r = nums.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (exist(nums, mid, s)) r = mid;
            else l = mid + 1;
        }

        return exist(nums, l, s) ? l : -1;
    }

    private boolean exist(int[] nums, int k, int s) {
        if (k > nums.length) return false;

        int sum = 0;
        for (int i = 0; i < k; i++) sum += nums[i];

        for (int i = k; i < nums.length; i++) {
            if (sum >= s) return true;
            sum += nums[i] - nums[i - k];
        }

        return sum >= s;
    }

    public int minimumSize2(int[] nums, int s) {
        int sum = 0, start = 0, minLen = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            while (sum >= s) {
                minLen = Math.min(minLen, i - start + 1);
                sum -= nums[start++];
            }
        }

        return minLen == Integer.MAX_VALUE ? -1 : minLen;
    }
}
