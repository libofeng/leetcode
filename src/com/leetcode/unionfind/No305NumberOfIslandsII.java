package com.leetcode.unionfind;

import java.util.ArrayList;
import java.util.List;

public class No305NumberOfIslandsII {
    private int total = 0;

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        final int[] UF = new int[positions.length];
        for (int i = 0; i < UF.length; i++) UF[i] = i;

        final int[][] grid = new int[m][n];
        final int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        final List<Integer> result = new ArrayList<>();

        for (int i = 0; i < positions.length; i++) {
            int px = positions[i][0], py = positions[i][1];
            if (grid[px][py] > 0) {
                result.add(total);
                continue;
            }

            total++;
            for (int[] dir : dirs) {
                int x = px + dir[0], y = py + dir[1];
                if (x < 0 || x >= m || y < 0 || y >= n) continue;

                if (grid[x][y] > 0) union(UF, i, grid[x][y] - 1);
            }
            grid[px][py] = i + 1;
            result.add(total);
        }

        return result;
    }

    void union(int[] UF, int a, int b) {
        int p = find(UF, a), q = find(UF, b);
        if (p == q) return;

        UF[p] = q;
        total--;
    }

    private int find(int[] UF, int p) {
        while (UF[p] != p) {
            UF[p] = UF[UF[p]];
            p = UF[p];
        }

        return p;
    }
}
