package com.lintcode.array;

public class No117JumpGameII {
    /**
     * @param A: A list of integers
     * @return: An integer
     */
    public int jump(int[] A) {
        final int n = A.length;
        if (n == 1) return 0;

        int start = 0, end = A[0];
        int steps = 1;
        while (end < n - 1) {
            int max = 0;
            for (; start <= end; start++) max = Math.max(max, A[start] + start);

            end = max;
            steps++;
        }

        return steps;
    }
}
