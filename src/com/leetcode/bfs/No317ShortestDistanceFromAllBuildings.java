package com.leetcode.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class No317ShortestDistanceFromAllBuildings {
    /*
    317.Shortest Distance from All Buildings
    You want to build a house on an empty land which reaches all buildings in the shortest amount of distance.
    You can only move up, down, left and right. You are given a 2D grid of values 0, 1 or 2, where:

    Each 0 marks an empty land which you can pass by freely.
    Each 1 marks a building which you cannot pass through.
    Each 2 marks an obstacle which you cannot pass through.
    Example:

    Input: [[1,0,2,0,1],[0,0,0,0,0],[0,0,1,0,0]]

    1 - 0 - 2 - 0 - 1
    |   |   |   |   |
    0 - 0 - 0 - 0 - 0
    |   |   |   |   |
    0 - 0 - 1 - 0 - 0

    Output: 7

    Explanation: Given three buildings at (0,0), (0,4), (2,2), and an obstacle at (0,2),
                 the point (1,2) is an ideal empty land to build a house, as the total
                 travel distance of 3+3+1=7 is minimal. So return 7.
    Note:
    There will be at least one building. If it is not possible to build such house according to the above rules, return -1.

     */


    private int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int shortestDistance(int[][] grid) {
        final int m = grid.length, n = m == 0 ? 0 : grid[0].length;

        int min = Integer.MAX_VALUE, land = 0;
        final int[][] d = new int[m][n];
        final Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 1) continue;

                min = Integer.MAX_VALUE;
                q.offer(new int[]{i, j, 0});
                while (!q.isEmpty()) {
                    int[] cell = q.poll();
                    for (int[] dir : dirs) {
                        int x = cell[0] + dir[0], y = cell[1] + dir[1], distance = cell[2] + 1;
                        if (x < 0 || y < 0 || x >= m || y >= n || grid[x][y] != land) continue;

                        d[x][y] += distance;
                        grid[x][y]--;
                        q.offer(new int[]{x, y, distance});
                        min = Math.min(min, d[x][y]);
                    }
                }

                land--;
            }
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }

    public static void main(String[] args) {
        No317ShortestDistanceFromAllBuildings solution = new No317ShortestDistanceFromAllBuildings();
        int d = solution.shortestDistance(new int[][]{{1, 0, 2, 0, 1}, {0, 0, 0, 0, 0}, {0, 0, 1, 0, 0}});
        System.out.println("d = " + d);
    }
}
