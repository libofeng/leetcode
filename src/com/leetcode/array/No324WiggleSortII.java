package com.leetcode.array;

import java.util.Arrays;

public class No324WiggleSortII {

    // https://www.cnblogs.com/grandyang/p/5139057.html
    public void wiggleSort(int[] nums) {
        final int n = nums.length;
        if (n <= 1) return;

        Arrays.sort(nums);
        int[] copy = new int[n];
        System.arraycopy(nums, 0, copy, 0, n);

        int p = (n + 1) / 2 - 1, q = n - 1;
        for (int i = 0; i < n; i++) nums[i] = (i % 2 == 0) ? copy[p--] : copy[q--];
    }
}
