package com.leetcode.lis;

import java.util.Arrays;

public class No376WiggleSubsequence {
    // LIS
    // Time: O(N^2), Space: O(N)
    public int wiggleMaxLength(int[] nums) {
        final int n = nums.length;
        if (n < 2) return n;

        final int[] asc = new int[n], desc = new int[n];
        Arrays.fill(asc, 1);
        Arrays.fill(desc, 1);

        int maxLen = 1;
        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) asc[i] = Math.max(asc[i], desc[j] + 1);
                else if (nums[i] < nums[j]) desc[i] = Math.max(desc[i], asc[j] + 1);

            }
            maxLen = Math.max(maxLen, Math.max(asc[i], desc[i]));
        }

        return maxLen;
    }

    // Time: O(N), Space: O(N)
    public int wiggleMaxLength2(int[] nums) {
        final int n = nums.length;
        if (n < 2) return n;

        final int[] asc = new int[n], desc = new int[n];
        asc[0] = desc[0] = 1;

        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                asc[i] = Math.max(asc[i], desc[i - 1] + 1);
                desc[i] = desc[i - 1];
            } else if (nums[i] < nums[i - 1]) {
                desc[i] = Math.max(desc[i], asc[i - 1] + 1);
                asc[i] = asc[i - 1];
            } else {
                asc[i] = asc[i - 1];
                desc[i] = desc[i - 1];
            }
        }

        return Math.max(asc[n - 1], desc[n - 1]);
    }
}
