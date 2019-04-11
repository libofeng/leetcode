package com.leetcode.array;

import java.util.TreeSet;

public class No363MaxSumOfRectangleNoLargerThanK {
    // Brute force solution
    // Time complexity: O(M^2 * N^2)
    // Space complexity: O(M*N)
    public int maxSumSubmatrix(int[][] matrix, int k) {
        final int m = matrix.length, n = m == 0 ? 0 : matrix[0].length;
        final int[][] sums = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++)
                sums[i][j] = sums[i - 1][j] + sums[i][j - 1] - sums[i - 1][j - 1] + matrix[i - 1][j - 1];
        }

        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int p = i; p < m; p++) {
                    for (int q = j; q < n; q++) {
                        int sum = sums[p + 1][q + 1] - sums[i][q + 1] - sums[p + 1][j] + sums[i][j];
                        if (sum <= k) maxSum = Math.max(maxSum, sum);
                    }
                }
            }
        }

        return maxSum;
    }


    // Time complexity: O(N^2 * M * LogM), due to TreeSet
    // Space complexity: O(M)
    public int maxSumSubmatrix2(int[][] matrix, int k) {
        final int m = matrix.length, n = m == 0 ? 0 : matrix[0].length;

        int maxSum = Integer.MIN_VALUE;
        for (int c = 0; c < n; c++) {
            final int[] sums = new int[m];
            for (int j = c; j < n; j++) {
                for (int i = 0; i < m; i++) sums[i] += matrix[i][j];

                int sum = find(sums, k);
                maxSum = Math.max(maxSum, sum);
            }
        }

        return maxSum;
    }

    private int find(int[] sums, int k) {
        final TreeSet<Integer> set = new TreeSet<>();
        set.add(0);

        int maxSum = Integer.MIN_VALUE, sum = 0;
        for (int n : sums) {
            sum += n;

            int target = sum - k;
            Integer ceiling = set.ceiling(target);

            if (ceiling != null) maxSum = Math.max(maxSum, sum - ceiling);
            set.add(sum);
        }

        return maxSum;
    }

}
