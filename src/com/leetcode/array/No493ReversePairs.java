package com.leetcode.array;

import java.util.Arrays;

public class No493ReversePairs {
    // https://leetcode.com/problems/reverse-pairs/discuss/97268/General-principles-behind-problems-similar-to-%22Reverse-Pairs%22
    // https://leetcode.com/problems/reverse-pairs/discuss/97280/Very-Short-and-Clear-MergeSort-and-BST-Java-Solutions
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    private int mergeSort(int[] nums, int start, int end) {
        if (start >= end) return 0;

        int mid = start + (end - start) / 2;
        int count = mergeSort(nums, start, mid) + mergeSort(nums, mid + 1, end);
        for (int i = start, j = mid + 1; i <= mid; i++) {
            while (j <= end && nums[i] / 2.0D > nums[j]) j++;
            count += j - (mid + 1);
        }
        Arrays.sort(nums, start, end + 1);
        return count;
    }

    public int reversePairs2(int[] nums) {
        final int n = nums.length;
        final int[] BIT = new int[n + 1];
        final long[] copy = Arrays.stream(nums).asLongStream().map((i -> 2 * i)).toArray();

        Arrays.sort(copy);

        int count = 0;
        for (int i = n - 1; i >= 0; i--) {
            int index = findIndex(copy, nums[i]);
            count += query(BIT, index - 1);

            index = findIndex(copy, 2L * nums[i]);
            update(BIT, index);
        }

        return count;
    }

    private int findIndex(long[] nums, long target) {
        int lo = 0, hi = nums.length;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] < target) lo = mid + 1;
            else hi = mid;
        }

        return lo;
    }

    private int query(int[] BIT, int i) {
        int count = 0;
        for (i++; i > 0; i -= (i & -i)) count += BIT[i];
        return count;
    }

    private void update(int[] BIT, int i) {
        for (i++; i < BIT.length; i += (i & -i)) BIT[i]++;
    }
}
