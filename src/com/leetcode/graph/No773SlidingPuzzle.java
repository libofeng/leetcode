package com.leetcode.graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class No773SlidingPuzzle {
    private int[][] dirs = new int[][]{{1, 3}, {0, 2, 4}, {1, 5}, {0, 4}, {1, 3, 5}, {2, 4}};

    public int slidingPuzzle(int[][] board) {
        StringBuilder sb = new StringBuilder();
        for (int[] row : board) for (int n : row) sb.append(n);
        String src = sb.toString(), dst = "123450";

        Set<String> visited = new HashSet<>();

        Queue<String> q = new LinkedList<>();
        q.offer(src);
        visited.add(src);
        int level = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                String state = q.poll();
                if (state.equals(dst)) return level;

                char[] chars = state.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    if (chars[i] != '0') continue;

                    for (int j : dirs[i]) {
                        swap(chars, i, j);
                        String nextState = new String(chars);
                        swap(chars, i, j);

                        if (visited.add(nextState)) q.offer(nextState);
                    }

                    break;
                }
            }
            level++;
        }

        return -1;
    }

    private void swap(char[] chars, int i, int j) {
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }

    public static void main(String[] args) {
        No773SlidingPuzzle solution = new No773SlidingPuzzle();
        int[][] board = {{1, 2, 3}, {4, 0, 5}};
        int steps = solution.slidingPuzzle(board);
        System.out.println("steps = " + steps);
    }
}
