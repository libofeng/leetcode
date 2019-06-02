package com.leetcode.contest.contest139;

import java.util.HashMap;
import java.util.Map;

public class No1074NumberOfSubmatricesThatSumToTarget {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        final int m = matrix.length, n = m == 0 ? 0 : matrix[0].length;
        final int[][] sums = new int[m + 1][n + 1];
        buildSums(matrix, sums);

        return search(sums, target);
    }

    private void buildSums(int[][] matrix, int[][] sums) {
        final int m = matrix.length, n = m == 0 ? 0 : matrix[0].length;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                sums[i][j] = sums[i - 1][j] + sums[i][j - 1] - sums[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }
    }

    private int search(int[][] sums, int target) {
        int count = 0;
        final int m = sums.length, n = m == 0 ? 0 : sums[0].length;
        for (int x2 = 1; x2 < m; x2++) {
            for (int y2 = 1; y2 < n; y2++) {
                for (int x1 = 1; x1 <= x2; x1++) {
                    for (int y1 = 1; y1 <= y2; y1++) {
                        if (getMatrixSum(sums, x1, y1, x2, y2) == target) count++;
                    }
                }
            }
        }

        return count;
    }

    private int search2(int[][] sums, int target) {
        final int m = sums.length, n = m == 0 ? 0 : sums[0].length;

        int count = 0;
        for (int i = 1; i < m; i++) {
            for (int i2 = i; i2 < m; i2++) {
                final Map<Integer, Integer> map = new HashMap<>();
                for (int j = 0; j < n; j++) {
                    int v = sums[i2][j] - sums[i - 1][j], key = v - target;
                    count += map.getOrDefault(key, 0);
                    map.put(v, map.getOrDefault(v, 0) + 1);
                }
            }
        }

        return count;
    }

    private int getMatrixSum(int[][] sums, int x1, int y1, int x2, int y2) {
        return sums[x2][y2] - sums[x1 - 1][y2] - sums[x2][y1 - 1] + sums[x1 - 1][y1 - 1];
    }
}
