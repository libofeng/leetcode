package com.company.indeed;

import com.algorithm.QuickSelect;
import com.leetcode.No295FindMedianFromDataStream;

public class FindStreamMedian {
    // There are 2 possible scenarios

    // 1. call not often: quickSelect
    public double findMedia(int[] nums) {
        int n = nums.length;

        QuickSelect quickSelect = new QuickSelect();
        if (n % 2 == 1) return quickSelect.findKthSmallest(nums, n / 2);
        return 1.0 * (quickSelect.findKthSmallest(nums, n / 2) + quickSelect.findKthSmallest(nums, n / 2 + 1)) / 2;
    }

    // 2. call often: 2 heaps
    public double findMedia() {
        No295FindMedianFromDataStream solution = new No295FindMedianFromDataStream();
        return solution.findMedian();
    }
}
