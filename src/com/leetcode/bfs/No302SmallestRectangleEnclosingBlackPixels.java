package com.leetcode.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class No302SmallestRectangleEnclosingBlackPixels {
    public int minArea(char[][] image, int x, int y) {
        final int m = image.length, n = m == 0 ? 0 : image[0].length;
        final int[][] dirs = new int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

        final Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        image[x][y] = '2';

        int minX = x, maxX = x, minY = y, maxY = y;
        while (!q.isEmpty()) {
            int[] p = q.poll();
            System.out.println(p[0]);
            for (int[] dir : dirs) {
                int px = p[0] + dir[0], py = p[1] + dir[1];
                if (px < 0 || py < 0 || px >= m || py >= n || image[px][py] != '1') continue;

                minX = Math.min(minX, px);
                maxX = Math.max(maxX, px);
                minY = Math.min(minY, py);
                maxY = Math.max(maxY, py);

                image[px][py] = '2';
                q.offer(new int[]{px, py});
            }
        }

        return (maxX - minX + 1) * (maxY - minY + 1);
    }

}
