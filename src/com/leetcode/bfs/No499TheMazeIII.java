package com.leetcode.bfs;

import java.util.*;

public class No499TheMazeIII {
    private int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private char[] directions = new char[]{'u', 'd', 'l', 'r'};

    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
        return bfs(maze, new Cell(ball[0], ball[1], 0, ""), hole);
    }

    private String bfs(int[][] maze, Cell src, int[] dst) {
        final int m = maze.length, n = m == 0 ? 0 : maze[0].length;
        final Cell[][] cells = new Cell[m][n];

        final Queue<Cell> q = new LinkedList<>();
        q.offer(src);

        while (!q.isEmpty()) {
            Cell cell = q.poll();

            if (cells[cell.x][cell.y] != null && cell.compareTo(cells[cell.x][cell.y]) >= 0) continue;
            cells[cell.x][cell.y] = cell;
            if (cell.x == dst[0] && cell.y == dst[1]) continue;
            for (int i = 0; i < 4; i++) {
                char d = directions[i];
                int[] dir = dirs[i];

                q.offer(keepGoing(maze, cell, dst, dir, d));
            }
        }

        return cells[dst[0]][dst[1]] == null ? "impossible" : cells[dst[0]][dst[1]].path;
    }

    private Cell keepGoing(int[][] maze, Cell cell, int[] dst, int[] dir, char d) {
        final int m = maze.length, n = m == 0 ? 0 : maze[0].length;
        int x = cell.x + dir[0], y = cell.y + dir[1], steps = cell.steps + 1;

        while (x >= 0 && y >= 0 && x < m && y < n && maze[x][y] != 1) {
            if (x == dst[0] && y == dst[1]) return new Cell(x, y, steps, cell.path + d);

            x += dir[0];
            y += dir[1];
            steps++;
        }

        return new Cell(x - dir[0], y - dir[1], steps - 1, cell.path + d);
    }

    class Cell implements Comparable<Cell> {
        int x, y, steps;
        String path;

        Cell(int x, int y, int steps, String path) {
            this.x = x;
            this.y = y;
            this.steps = steps;
            this.path = path;
        }

        public int compareTo(Cell that) {
            if (this.steps == that.steps) return this.path.compareTo(that.path);
            return this.steps - that.steps;
        }
    }
}
