package com.leetcode.contest.contest138;

public class No1053PreviousPermutationWithOneSwap {
    // Time: O(N), Space: O(1)
    // It's actually the problem of next permutation
    public int[] prevPermOpt1(int[] A) {
        final int n = A.length;
        int biggerIndex = n - 2;
        for (; biggerIndex >= 0; biggerIndex--) if (A[biggerIndex] > A[biggerIndex + 1]) break;
        if (biggerIndex < 0) return A;

        int smallerIndex = n - 1;
        for (; smallerIndex > biggerIndex; smallerIndex--) if (A[smallerIndex] < A[biggerIndex]) break;

        swap(A, biggerIndex, smallerIndex);
        return A;
    }

    private void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
}
