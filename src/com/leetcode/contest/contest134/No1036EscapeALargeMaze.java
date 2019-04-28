package com.leetcode.contest.contest134;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class No1036EscapeALargeMaze {
    /*
    1036. Escape a Large Maze

    In a 1 million by 1 million grid, the coordinates of each grid square are (x, y) with 0 <= x, y < 10^6.

    We start at the source square and want to reach the target square.  Each move, we can walk to a 4-directionally adjacent square in the grid that isn't in the given list of blocked squares.

    Return true if and only if it is possible to reach the target square through a sequence of moves.



    Example 1:

    Input: blocked = [[0,1],[1,0]], source = [0,0], target = [0,2]
    Output: false
    Explanation:
    The target square is inaccessible starting from the source square, because we can't walk outside the grid.
    Example 2:

    Input: blocked = [], source = [0,0], target = [999999,999999]
    Output: true
    Explanation:
    Because there are no blocked cells, it's possible to reach the target square.


    Note:

    0 <= blocked.length <= 200
    blocked[i].length == 2
    0 <= blocked[i][j] < 10^6
    source.length == target.length == 2
    0 <= source[i][j], target[i][j] < 10^6
    source != target
     */

    // https://www.youtube.com/watch?v=Gwp8hL2F6c0

    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        final Set<String> blockedSet = new HashSet<>();
        for (int[] p : blocked) blockedSet.add(p[0] + "," + p[1]);
        return bfs(blockedSet, source, target) && bfs(blockedSet, target, source);
    }

    private int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private boolean bfs(Set<String> block, int[] s, int[] t) {
        final int maxP = 1000000, maxTotal = 20000;
        final Set<String> visited = new HashSet<>();
        final Queue<int[]> q = new LinkedList<>();

        q.offer(s);
        if (block.contains(s[0] + "," + s[1])) return false;

        visited.add(s[0] + "," + s[1]);
        while (!q.isEmpty()) {
            int[] p = q.poll();

            for (int[] dir : dirs) {
                int x = p[0] + dir[0], y = p[1] + dir[1];
                if (x < 0 || y < 0 || x >= maxP || y >= maxP) continue;
                if (block.contains(x + "," + y) || !visited.add(x + "," + y)) continue;
                if (x == t[0] && y == t[1]) return true;

                q.offer(new int[]{x, y});
                if (visited.size() == maxTotal) return true;
            }
        }

        return false;
    }
}
