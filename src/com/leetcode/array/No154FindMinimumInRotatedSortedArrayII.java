package com.leetcode.array;

public class No154FindMinimumInRotatedSortedArrayII {
    // Binary search
    // worse case: O(N)
    public int findMin(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[lo] == nums[hi]) lo++;
            else if (nums[lo] < nums[hi]) return nums[lo];
            else {
                if (nums[mid] >= nums[lo]) lo = mid + 1;
                else hi = mid;
            }
        }

        return nums[lo];
    }
}
