package com.leetcode.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class No327CountOfRangeSum {
    // https://leetcode.com/problems/count-of-range-sum/discuss/77990/Share-my-solution
    public int countRangeSum(int[] nums, int lower, int upper) {
        final long[] sums = new long[nums.length + 1];
        for (int i = 1; i < sums.length; i++) sums[i] = sums[i - 1] + nums[i - 1];

        return mergeSort(sums, 0, nums.length, lower, upper);
    }

    private int mergeSort(long[] sums, int start, int end, int lower, int upper) {
        if (end <= start) return 0;

        int mid = start + (end - start) / 2;
        int count = mergeSort(sums, start, mid, lower, upper) + mergeSort(sums, mid + 1, end, lower, upper);

        long[] temp = new long[end - start + 1];
        int l = mid + 1, h = mid + 1, s = mid + 1, index = 0;
        for (int i = start; i <= mid; i++) {
            while (l <= end && sums[l] - sums[i] < lower) l++;
            while (h <= end && sums[h] - sums[i] <= upper) h++;
            while (s <= end && sums[s] < sums[i]) temp[index++] = sums[s++];
            temp[index++] = sums[i];
            count += h - l;
        }

        System.arraycopy(temp, 0, sums, start, index);
        return count;
    }

    // https://leetcode.com/problems/count-of-range-sum/discuss/78026/An-O(n-log-n)-solution-via-Fenwick-Tree
    // BIT
    public int countRangeSum2(int[] nums, int lower, int upper) {
        List<Long> cand = new ArrayList<>();
        cand.add(Long.MIN_VALUE); // make sure no number gets a 0-index.
        cand.add(0L);
        long[] sum = new long[nums.length + 1];
        for (int i = 1; i < sum.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
            cand.add(sum[i]);
            cand.add(lower + sum[i - 1] - 1);
            cand.add(upper + sum[i - 1]);
        }
        Collections.sort(cand); // finish discretization

        int[] bit = new int[cand.size()];
        for (int i = 0; i < sum.length; i++) plus(bit, Collections.binarySearch(cand, sum[i]), 1);
        int ans = 0;
        for (int i = 1; i < sum.length; i++) {
            plus(bit, Collections.binarySearch(cand, sum[i - 1]), -1);
            ans += query(bit, Collections.binarySearch(cand, upper + sum[i - 1]));
            ans -= query(bit, Collections.binarySearch(cand, lower + sum[i - 1] - 1));
        }
        return ans;
    }

    private void plus(int[] bit, int i, int delta) {
        for (; i < bit.length; i += i & -i) bit[i] += delta;
    }

    private int query(int[] bit, int i) {
        int sum = 0;
        for (; i > 0; i -= i & -i) sum += bit[i];
        return sum;
    }
}
