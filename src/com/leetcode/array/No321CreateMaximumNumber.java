package com.leetcode.array;

public class No321CreateMaximumNumber {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        final int m = nums1.length, n = nums2.length;

        int[] result = new int[k];
        for (int i = Math.max(0, k - n); i <= k && i <= m; i++) {
            int[] num = merge(maxArray(nums1, i), maxArray(nums2, k - i), k);
            if (greater(num, 0, result, 0)) result = num;
        }

        return result;
    }

    private int[] merge(int[] a, int[] b, int k) {
        final int[] result = new int[k];
        for (int i = 0, j = 0, index = 0; index < k; index++) {
            result[index] = greater(a, i, b, j) ? a[i++] : b[j++];
        }

        return result;
    }

    private boolean greater(int[] a, int i, int[] b, int j) {
        while (i < a.length && j < b.length && a[i] == b[j]) {
            i++;
            j++;
        }

        return j == b.length || (i < a.length && a[i] > b[j]);
    }

    private int[] maxArray(int[] nums, int k) {
        final int n = nums.length;
        final int[] result = new int[k];
        for (int i = 0, j = 0; i < n; i++) {
            while (j > 0 && n - i + j > k && nums[i] > result[j - 1]) j--;

            if (j < k) result[j++] = nums[i];
        }

        return result;
    }
}
