package com.leetcode.array;

public class No4MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        if (len % 2 == 1) return findKth(nums1, 0, nums2, 0, len / 2 + 1);
        else {
            int n1 = findKth(nums1, 0, nums2, 0, len / 2);
            int n2 = findKth(nums1, 0, nums2, 0, len / 2 + 1);
            return (n1 + n2) / 2.0D;
        }
    }

    private int findKth(int[] A, int i, int[] B, int j, int k) {
        final int m = A.length, n = B.length;
        if (m - i > n - j) return findKth(B, j, A, i, k);
        if (m == i) return B[j + k - 1];
        if (k == 1) return Math.min(A[i], B[j]);

        int k1 = Math.min(k / 2, m - i), k2 = k - k1;
        if (A[i + k1 - 1] < B[j + k2 - 1]) return findKth(A, i + k1, B, j, k - k1);
        else if (A[i + k1 - 1] > B[j + k2 - 1]) return findKth(A, i, B, j + k2, k - k2);
        else return A[i + k1 - 1];
    }
}
