package com.lintcode.array;

import java.util.Arrays;

public class No1251SplitArrayLargestSum {
    /**
     * @param nums: a list of integers
     * @param m: an integer
     * @return: return a integer
     */
    int gMin = Integer.MAX_VALUE;

    public int splitArray(int[] nums, int m) {
        final int n = nums.length;
        final int[] sums = new int[n + 1];
        for (int i = 1; i < sums.length; i++) sums[i] = sums[i - 1] + nums[i - 1];

        dfs(sums, n, m, 0, 0, 0);

        return gMin;
    }

    private void dfs(int[] sums, int n, int m, int count, int max, int start) {
        if (start >= n) return;
        if (count + 1 == m) {
            max = Math.max(max, sums[n] - sums[start]);
            gMin = Math.min(gMin, max);
            return;
        }

        for (int i = start + 1; i <= n; i++) {
            dfs(sums, n, m, count + 1, Math.max(sums[i] - sums[start], max), i);
        }
    }

    public int splitArray2(int[] nums, int m) {
        long max = 0, maxVal = -1;
        for (int n : nums) {
            max += n;
            maxVal = Math.max(maxVal, n);
        }

        if (m == 1) return (int) max;
        return (int) search(nums, m, maxVal, max);
    }

    private long search(int[] nums, int m, long l, long r) {
        while (l < r) {
            long mid = l + (r - l) / 2;
            if (isValid(nums, mid, m)) r = mid;
            else l = mid + 1;
        }

        return l;
    }

    private boolean isValid(int[] nums, long groupSum, int m) {
        int group = 1;
        long sum = 0;
        for (int n : nums) {
            sum += n;
            if (sum > groupSum) {
                sum = n;
                if (++group > m) return false;
            }
        }

        return true;
    }

    // https://www.cnblogs.com/grandyang/p/5933787.html
    public int splitArray3(int[] nums, int m) {
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

}
