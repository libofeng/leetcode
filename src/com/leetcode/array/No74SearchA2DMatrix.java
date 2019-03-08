package com.leetcode.array;

public class No74SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        final int m = matrix.length, n = m == 0 ? 0 : matrix[0].length;
        int lo = 0, hi = m * n - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2, i = mid / n, j = mid % n;
            if (target == matrix[i][j]) return true;
            if (target < matrix[i][j]) hi = mid - 1;
            else lo = mid + 1;
        }
        return false;
    }
}
