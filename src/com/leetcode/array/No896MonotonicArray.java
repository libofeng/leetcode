package com.leetcode.array;

public class No896MonotonicArray {
    public boolean isMonotonic(int[] A) {
        return A == null || A.length <= 2 || decreasing(A) || increasing(A);
    }

    private boolean decreasing(int[] A) {
        for (int i = 1; i < A.length; ++i) if (A[i] > A[i - 1]) return false;
        return true;
    }

    private boolean increasing(int[] A) {
        for (int i = 1; i < A.length; ++i) if (A[i] < A[i - 1])return false;
        return true;
    }




    public boolean isMonotonic2(int[] A) {
        if (A == null || A.length <= 1) return true;

        int incr = A.length, decr = A.length;
        for (int i = 1; i < A.length; i++) {
            if (A[i] > A[i - 1]) decr--;
            else if (A[i] < A[i - 1]) incr--;
        }

        return incr == A.length || decr == A.length;
    }
}
