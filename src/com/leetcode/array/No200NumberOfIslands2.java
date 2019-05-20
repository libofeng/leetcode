package com.leetcode.array;

public class No200NumberOfIslands2 {

    // by using UnionFind
    public int numIslands(char[][] grid) {
        final int m = grid.length, n = m == 0 ? 0 : grid[0].length;
        final int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        final UnionFind uf = new UnionFind(grid);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '0') continue;

                for (int[] dir : dirs) {
                    int x = i + dir[0], y = j + dir[1];
                    if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] == '0') continue;

                    int a = i * n + j, b = x * n + y;
                    uf.union(a, b);
                }
            }
        }

        return uf.count;
    }


    class UnionFind {
        int[] parents;
        int count;

        UnionFind(char[][] grid) {
            int m = grid.length, n = m == 0 ? 0 : grid[0].length;
            parents = new int[m * n];

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {

                    if (grid[i][j] == '0') continue;

                    int index = n * i + j;
                    parents[index] = index;
                    count++;
                }
            }
        }

        void union(int a, int b) {
            int p = find(a), q = find(b);
            if (p != q) {
                parents[p] = q;
                count--;
            }
        }

        int find(int p) {
            while (p != parents[p]) {
                parents[p] = parents[parents[p]];
                p = parents[p];
            }

            return p;
        }
    }
}
