package com.leetcode.array;

public class No240SearchA2DMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        final int m = matrix.length, n = m == 0 ? 0 : matrix[0].length;
        int i = m - 1, j = 0;
        while (i >= 0 && j < n) {
            if (target == matrix[i][j]) return true;

            if (target < matrix[i][j]) i--;
            else j++;
        }

        return false;
    }
}
