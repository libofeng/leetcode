package com.leetcode.dfs;

public class No733FloodFillDFS {
    private int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int oldColor = image[sr][sc];
        if (oldColor == newColor) return image;

        fill(image, sr, sc, oldColor, newColor);

        return image;
    }

    private void fill(int[][] image, int x, int y, int oldColor, int newColor) {
        final int m = image.length, n = image[0].length;
        if (x < 0 || y < 0 || x >= m || y >= n || image[x][y] != oldColor) return;

        image[x][y] = newColor;
        for (int[] dir : dirs) fill(image, x + dir[0], y + dir[1], oldColor, newColor);
    }
}
