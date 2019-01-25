package com.leetcode.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class No733FloodFillBFS {

    private int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int oldColor = image[sr][sc];
        if (oldColor == newColor) return image;
        final int m = image.length, n = image[0].length;

        final Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sr, sc});
        image[sr][sc] = newColor;

        while (!q.isEmpty()) {
            int r = q.peek()[0], c = q.poll()[1];

            for (int[] dir : dirs) {
                int x = r + dir[0], y = c + dir[1];

                if (x >= 0 && y >= 0 && x < m && y < n && image[x][y] == oldColor) {
                    q.offer(new int[]{x, y});
                    image[x][y] = newColor;
                }
            }
        }

        return image;
    }
}
