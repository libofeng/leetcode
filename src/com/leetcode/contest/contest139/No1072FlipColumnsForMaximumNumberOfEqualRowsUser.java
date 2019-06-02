package com.leetcode.contest.contest139;

import java.util.Arrays;

public class No1072FlipColumnsForMaximumNumberOfEqualRowsUser {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        final int m = matrix.length, n = matrix[0].length;

        int result = 0;
        for (int i = 0; i < m; i++) {
            int count = 0;
            for (int i2 = i; i2 < m; i2++) {
                if (Arrays.equals(matrix[i], matrix[i2]) || isTotalDifferent(matrix[i], matrix[i2])) count++;
            }
            result = Math.max(result, count);
        }
        return result;
    }

    private boolean isTotalDifferent(int[] a, int[] b) {
        for (int i = 0; i < a.length; i++) if (a[i] == b[i]) return false;
        return true;
    }
}
