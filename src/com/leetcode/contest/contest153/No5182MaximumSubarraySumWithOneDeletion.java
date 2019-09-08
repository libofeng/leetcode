package com.leetcode.contest.contest153;

public class No5182MaximumSubarraySumWithOneDeletion {
    //Time: O(N^2), Space: O(N)
    public int maximumSum(int[] arr) {
        final int n = arr.length;
        final int[] sums = new int[n + 1];
        for (int i = 1; i <= n; i++) sums[i] = sums[i - 1] + arr[i - 1];

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = i + 1; j <= n; j++) {
                min = Math.min(min, arr[j - 1]);
                int sum = sums[j] - sums[i];
                max = Math.max(max, sum);

                if (j - i > 1) max = Math.max(max, sum - min);
                if (sum - min < 0) break;
            }
        }

        return max;
    }

    // Time: strictly O(N), Space: O(N)
    public int maximumSum2(int[] arr) {
        int[] leftSum = new int[arr.length];
        int cur = 0;
        for (int i = 0; i < arr.length; i++) {
            cur += arr[i];
            leftSum[i] = cur;
            cur = Math.max(0, cur);
        }

        int[] rightSum = new int[arr.length];
        cur = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            cur += arr[i];
            rightSum[i] = cur;
            cur = Math.max(0, cur);
        }

        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) ans = Math.max(ans, leftSum[i]);
        for (int i = 1; i < arr.length - 1; i++) ans = Math.max(ans, leftSum[i - 1] + rightSum[i + 1]);
        return ans;

    }

    // similar to solution 2
    public int maximumSum3(int[] arr) {
        final int n = arr.length;
        final int[] left = new int[n], right = new int[n];

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (i == 0 || left[i - 1] <= 0) left[i] = arr[i];
            else left[i] = left[i - 1] + arr[i];

            max = Math.max(max, left[i]);
        }

        for (int i = n - 1; i >= 0; i--) {
            if (i == n - 1 || right[i + 1] <= 0) right[i] = arr[i];
            else right[i] = right[i + 1] + arr[i];

            max = Math.max(max, right[i]);
        }

        for (int i = 1; i < n - 1; i++) max = Math.max(max, left[i - 1] + right[i + 1]);

        return max;
    }
}
