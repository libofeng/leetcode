package com.leetcode.bfs;

public class No296BestMeetingPoint {
    /*
    A group of two or more people wants to meet and minimize the total travel distance. You are given a 2D grid of values 0 or 1, where each 1 marks the home of someone in the group. The distance is calculated using Manhattan Distance, where distance(p1, p2) = |p2.x - p1.x| + |p2.y - p1.y|.

    Example:

    Input:

    1 - 0 - 0 - 0 - 1
    |   |   |   |   |
    0 - 0 - 0 - 0 - 0
    |   |   |   |   |
    0 - 0 - 1 - 0 - 0

    Output: 6

    Explanation: Given three people living at (0,0), (0,4), and (2,2):
                 The point (0,2) is an ideal meeting point, as the total travel distance
                 of 2+2+2=6 is minimal. So return 6.
     */

    public int minTotalDistance(int[][] grid) {
        final int m = grid.length, n = m == 0 ? 0 : grid[0].length;
        int minDistance = Integer.MAX_VALUE;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) minDistance = Math.min(minDistance, findDistance(grid, i, j));
        }

        return minDistance;
    }

    private int findDistance(int[][] grid, int x, int y) {
        final int m = grid.length, n = grid[0].length;

        int d = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 1) continue;
                d += Math.abs(x - i) + Math.abs(y - j);
            }
        }

        return d;
    }
}
