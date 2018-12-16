package com.lintcode.array;

public class No116JumpGame {

    /**
     * @param A: A list of integers
     * @return: A boolean
     */
    public boolean canJump(int[] A) {
        final int n = A.length;
        int start = 0, end = A[0];
        while (end < n - 1) {
            int max = 0;
            for (; start <= end; start++) max = Math.max(max, start + A[start]);
            if (max <= end) return false;

            end = max;
        }

        return true;
    }

    public boolean canJump2(int[] A) {
        int maxReach = A[0];
        for (int i = 1; i < A.length; i++) {
            if (maxReach < i) return false;
            maxReach = Math.max(maxReach, i + A[i]);
        }
        return true;
    }

}
