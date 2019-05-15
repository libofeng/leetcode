package com.leetcode.array;

public class No750NumberOfCornerRectangles {

    public int countCornerRectangles(int[][] grid) {
        final int m = grid.length, n = m == 0 ? 0 : grid[0].length;

        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) continue;

                for (int p = i + 1; p < m; p++) {
                    for (int q = j + 1; q < n; q++) {
                        if (grid[p][q] == 0 || grid[p][j] == 0 || grid[i][q] == 0) continue;
                        count++;
                    }
                }
            }
        }

        return count;
    }


    // https://leetcode.com/problems/number-of-corner-rectangles/discuss/110196/short-JAVA-AC-solution-(O(m2-*-n))-with-explanation.
    public int countCornerRectangles2(int[][] grid) {
        final int m = grid.length, n = m == 0 ? 0 : grid[0].length;

        int count = 0;
        for (int i = 0; i < m - 1; i++) {
            for (int j = i + 1; j < m; j++) {
                int cols = 0;
                for (int k = 0; k < n; k++) {
                    if (grid[i][k] == 1 && grid[j][k] == 1) cols++;
                }

                if (cols > 1) count += cols * (cols - 1) / 2;
            }
        }

        return count;
    }
}
