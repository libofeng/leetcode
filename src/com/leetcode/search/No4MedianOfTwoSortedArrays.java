package com.leetcode.search;

import java.util.Arrays;

public class No4MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        final int l1 = nums1.length, l2 = nums2.length, k1 = (l1 + l2 + 1) / 2, k2 = (l1 + l2 + 2) / 2;
        return (findKth(nums1, 0, nums2, 0, k1) + findKth(nums1, 0, nums2, 0, k2)) / 2.0D;
    }

    private int findKth(int[] A1, int p1, int[] A2, int p2, int k) {
        final int l1 = A1.length, l2 = A2.length;
        if (p1 >= l1) return A2[p2 + k - 1];
        if (p2 >= l2) return A1[p1 + k - 1];
        if (k == 1) return Math.min(A1[p1], A2[p2]);

        int m = k / 2;
        int n1 = p1 + m - 1 < l1 ? A1[p1 + m - 1] : Integer.MAX_VALUE;
        int n2 = p2 + m - 1 < l2 ? A2[p2 + m - 1] : Integer.MAX_VALUE;

        return n1 < n2 ? findKth(A1, p1 + m, A2, p2, k - m) : findKth(A1, p1, A2, p2 + m, k - m);
    }


    private int findKth2(int[] A1, int[] A2, int k) {
        final int l1 = A1.length, l2 = A2.length;
        if (l1 == 0) return A2[k - 1];
        if (l2 == 0) return A1[k - 1];
        if (k == 1) return Math.min(A1[0], A2[0]);

        int i = Math.min(l1, k / 2), j = Math.min(l2, k / 2);
        if (A1[i - 1] < A2[j - 1]) return findKth2(Arrays.copyOfRange(A1, i, l1), A2, k - i);
        else return findKth2(A1, Arrays.copyOfRange(A2, j, l2), k - j);
    }

    private int findKth3(int[] A1, int[] A2, int k) {
        // https://leetcode.com/problems/median-of-two-sorted-arrays/discuss/2471/very-concise-ologminmn-iterative-solution-with-detailed-explanation
        // TODO: TBD
        return 0;
    }
}
