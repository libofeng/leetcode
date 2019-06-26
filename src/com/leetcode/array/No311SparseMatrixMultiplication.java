package com.leetcode.array;

public class No311SparseMatrixMultiplication {
    /*
    Given two sparse matrices A and B, return the result of AB.

    You may assume that A's column number is equal to B's row number.

    Example:

    Input:

    A = [
      [ 1, 0, 0],
      [-1, 0, 3]
    ]

    B = [
      [ 7, 0, 0 ],
      [ 0, 0, 0 ],
      [ 0, 0, 1 ]
    ]

    Output:

         |  1 0 0 |   | 7 0 0 |   |  7 0 0 |
    AB = | -1 0 3 | x | 0 0 0 | = | -7 0 3 |
                      | 0 0 1 |
     */

    /**
     * @param A: a sparse matrix
     * @param B: a sparse matrix
     * @return: the result of A * B
     */
    public int[][] multiply(int[][] A, int[][] B) {
        final int m = A.length, t = A[0].length, n = B[0].length;
        final int[][] result = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < t; k++) result[i][j] += A[i][k] * B[k][j];
            }
        }

        return result;
    }

    // optimized solution
    public int[][] multiply2(int[][] A, int[][] B) {
        final int m = A.length, t = A[0].length, n = B[0].length;
        final int[][] result = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int k = 0; k < t; k++) {
                if (A[i][k] == 0) continue;
                for (int j = 0; j < n; j++) result[i][j] += A[i][k] * B[k][j];
            }
        }

        return result;
    }
}
