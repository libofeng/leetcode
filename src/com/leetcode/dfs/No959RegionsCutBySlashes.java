package com.leetcode.dfs;

public class No959RegionsCutBySlashes {
    private int n, startRow, startCol, count;
    private int[][] matrix;
    private int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    // https://leetcode.com/problems/regions-cut-by-slashes/discuss/239610/A-tricky-dfs-solution-beats-92.47Java
    public int regionsBySlashes(String[] grid) {
        n = grid.length * 3;
        matrix = new int[n][n];
        fill(grid);

        while (hasMoreRegion()) {
            count++;
            visit(startRow, startCol);
        }

        return count;
    }

    private void visit(int i, int j) {
        if (i < 0 || i >= n || j < 0 || j >= n || matrix[i][j] != 0) return;

        matrix[i][j] = 2;
        for (int[] dir : dirs) visit(i + dir[0], j + dir[1]);
    }

    private boolean hasMoreRegion() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    startRow = i;
                    startCol = j;
                    return true;
                }
            }
        }

        return false;
    }

    private void fill(String[] grid) {
        final int size = grid.length;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                char c = grid[i].charAt(j);
                if (c == '/') {
                    matrix[i * 3][j * 3 + 2] = 1;
                    matrix[i * 3 + 1][j * 3 + 1] = 1;
                    matrix[i * 3 + 2][j * 3] = 1;
                } else if (c == '\\') {
                    matrix[i * 3][j * 3] = 1;
                    matrix[i * 3 + 1][j * 3 + 1] = 1;
                    matrix[i * 3 + 2][j * 3 + 2] = 1;
                }
            }
        }
    }
}
