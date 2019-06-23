package com.leetcode.array;

public class No251Flatten2DVector3 {
    private int m, row, col;
    private int[][] v;

    public No251Flatten2DVector3(int[][] v) {
        this.v = v;
        m = v.length;
    }

    public int next() {
        if (!hasNext()) return -1;

        return v[row][col++];
    }

    public boolean hasNext() {
        flatten();
        return row < m && col < v[row].length;
    }

    private void flatten() {
        while (row < m && (v[row] == null || col == v[row].length)) {
            row++;
            col = 0;
        }
    }
}