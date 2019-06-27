package com.leetcode.dfs;

public class No302SmallestRectangleEnclosingBlackPixels {
    final int[][] dirs = new int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    int minX = Integer.MAX_VALUE, maxX = 0;
    int minY = Integer.MAX_VALUE, maxY = 0;

    public int minArea(char[][] image, int x, int y) {
        dfs(image, x, y);

        return (maxX - minX + 1) * (maxY - minY + 1);
    }

    private void dfs(char[][] image, int i, int j) {
        final int m = image.length, n = m == 0 ? 0 : image[0].length;
        if (i < 0 || j < 0 || i >= m || j >= n || image[i][j] != '1') return;

        image[i][j] = '2';
        minX = Math.min(minX, i);
        maxX = Math.max(maxX, i);
        minY = Math.min(minY, j);
        maxY = Math.max(maxY, j);
        for (int[] dir : dirs) dfs(image, i + dir[0], j + dir[1]);
    }
}
