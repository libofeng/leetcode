package com.leetcode.bfs;

import java.util.*;

public class No499TheMazeIII {
    /**
     * @param maze: the maze
     * @param ball: the ball position
     * @param hole: the hole position
     * @return: the lexicographically smallest way
     */
    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
        return bfs(maze, ball, hole);
    }

    private int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private String[] directions = new String[]{"u", "d", "l", "r"};

    private String bfs(int[][] maze, int[] start, int[] dst) {
        final Queue<Stop> q = new LinkedList<>();
        q.offer(new Stop(start[0], start[1], 0, ""));

        int minSteps = Integer.MAX_VALUE;
        final Map<Integer, List<String>> paths = new HashMap<>();

        while (!q.isEmpty()) {
            Stop src = q.poll();
            int x = src.x, y = src.y, steps = src.steps;

            if (x == dst[0] && y == dst[1]) {
                minSteps = Math.min(minSteps, steps);
                paths.putIfAbsent(steps, new ArrayList<>());
                paths.get(steps).add(src.path);
                continue;
            } else maze[x][y] = 2;

            for (int i = 0; i < dirs.length; i++) {
                int[] dir = dirs[i];
                String d = directions[i];

                Stop next = keepGoing(maze, new Stop(x, y, steps, src.path + d), dir, dst);
                if (next.steps == steps) continue;
                if (maze[next.x][next.y] == 2) continue;

                q.offer(next);
            }
        }

        if (minSteps == Integer.MAX_VALUE) return "impossible";
        List<String> result = paths.get(minSteps);
        result.sort(String::compareTo);

        return result.get(0);
    }

    private Stop keepGoing(int[][] maze, Stop start, int[] dir, int[] dst) {
        final int m = maze.length, n = maze[0].length;
        final int x = start.x + dir[0], y = start.y + dir[1], steps = start.steps + 1;

        if (x < 0 || y < 0 || x >= m || y >= n || maze[x][y] == 1) return start;
        if (x == dst[0] && y == dst[1]) return new Stop(x, y, steps, start.path);

        return keepGoing(maze, new Stop(x, y, steps, start.path), dir, dst);
    }

    class Stop {
        int x, y, steps;
        String path;

        Stop(int x, int y, int steps, String path) {
            this.x = x;
            this.y = y;
            this.steps = steps;
            this.path = path;
        }
    }

    public static void main(String[] args) {
        int[][] maze = new int[][]{{0, 0, 0, 0, 0}, {1, 1, 0, 0, 1}, {0, 0, 0, 0, 0}, {0, 1, 0, 0, 1}, {0, 1, 0, 0, 0}};
        No499TheMazeIII solution = new No499TheMazeIII();
        String path = solution.findShortestWay(maze, new int[]{4, 3}, new int[]{0, 1});
        System.out.println("path = " + path);
    }
}
