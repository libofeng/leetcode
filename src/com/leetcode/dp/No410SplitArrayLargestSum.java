package com.leetcode.dp;

import java.util.Arrays;

public class No410SplitArrayLargestSum {
    public int splitArray(int[] nums, int m) {
        final int n = nums.length;
        final int[] sums = new int[n + 1];
        for (int i = 1; i <= n; i++) sums[i] = sums[i - 1] + nums[i - 1];

        final int[][] dp = new int[m + 1][n + 1];
        for (int[] row : dp) Arrays.fill(row, Integer.MAX_VALUE);
        dp[0][0] = 0;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = i - 1; k < j; k++) {
                    int max = Math.max(dp[i - 1][k], sums[j] - sums[k]);
                    dp[i][j] = Math.min(dp[i][j], max);
                }
            }
        }

        return dp[m][n];
    }

    public int splitArray2(int[] nums, int m) {
        long totalSum = 0, maxNum = 0;
        for (int num : nums) {
            totalSum += num;
            maxNum = Math.max(maxNum, num);
        }

        if (m == 1) return (int) totalSum;
        return (int) findMinGroup(nums, m, maxNum, totalSum);
    }

    private long findMinGroup(int[] nums, int m, long lo, long hi) {
        while (lo < hi) {
            long mid = lo + (hi - lo) / 2;
            if (isValid(nums, m, mid)) hi = mid;
            else lo = mid + 1;
        }

        return lo;
    }

    private boolean isValid(int[] nums, int m, long maxSum) {
        int groups = 1;
        long sum = 0;
        for (int n : nums) {
            if (sum + n > maxSum) {
                sum = n;
                if (++groups > m) return false;
            } else sum += n;
        }

        return true;
    }
}
