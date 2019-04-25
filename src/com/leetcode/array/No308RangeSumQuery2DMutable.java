package com.leetcode.array;

public class No308RangeSumQuery2DMutable {
    // https://www.jianshu.com/p/f3dbe84bcb69

    private int[][] BIT, matrix;
    private int m, n;

    public No308RangeSumQuery2DMutable(int[][] matrix) {
        m = matrix.length;
        n = m == 0 ? 0 : matrix[0].length;
        this.matrix = matrix;
        BIT = new int[m][n + 1];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) set(i, j, matrix[i][j]);
        }
    }

    public void update(int row, int col, int val) {
        int delta = val - matrix[row][col];
        set(row, col, delta);
        matrix[row][col] = val;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for (int i = row1; i <= row2; i++) {
            sum += get(i, col2) - get(i, col1 - 1);
        }

        return sum;
    }

    private void set(int row, int col, int val) {
        for (int i = col + 1; i <= n; i += (i & -i)) BIT[row][i] += val;
    }

    private int get(int row, int col) {
        int sum = 0;
        for (int i = col + 1; i > 0; i -= (i & -i)) sum += BIT[row][i];
        return sum;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * obj.update(row,col,val);
 * int param_2 = obj.sumRegion(row1,col1,row2,col2);
 */