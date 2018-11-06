package com.lintcode.math;

public class No654SparseMatrixMultiplication {
    // reference: https://www.lintcode.com/problem/sparse-matrix-multiplication/note/152711

    /**
     * @param A: a sparse matrix
     * @param B: a sparse matrix
     * @return: the result of A * B
     */
    public int[][] multiply(int[][] A, int[][] B) {
        final int m = A.length, t = A[0].length, n = B[0].length;
        final int[][] R = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < t; k++) R[i][j] += A[i][k] * B[k][j];
            }
        }

        return R;
    }
}
