package com.leetcode.dfs;

import java.util.LinkedList;
import java.util.Queue;

public class No490TheMaze {
    /*
There is a ball in a maze with empty spaces and walls. The ball can go through empty spaces by rolling up, down, left or right, but it won't stop rolling until hitting a wall. When the ball stops, it could choose the next direction.

Given the ball's start position, the destination and the maze, determine whether the ball could stop at the destination.

The maze is represented by a binary 2D array. 1 means the wall and 0 means the empty space. You may assume that the borders of the maze are all walls. The start and destination coordinates are represented by row and column indexes.

Example 1

Input 1: a maze represented by a 2D array

0 0 1 0 0
0 0 0 0 0
0 0 0 1 0
1 1 0 1 1
0 0 0 0 0

Input 2: start coordinate (rowStart, colStart) = (0, 4)
Input 3: destination coordinate (rowDest, colDest) = (4, 4)

Output: true
Explanation: One possible way is : left -> down -> left -> down -> right -> down -> right.

Example 2

Input 1: a maze represented by a 2D array

0 0 1 0 0
0 0 0 0 0
0 0 0 1 0
1 1 0 1 1
0 0 0 0 0

Input 2: start coordinate (rowStart, colStart) = (0, 4)
Input 3: destination coordinate (rowDest, colDest) = (3, 2)

Output: false
Explanation: There is no way for the ball to stop at the destination.

Note:
There is only one ball and one destination in the maze.
Both the ball and the destination exist on an empty space, and they will not be at the same position initially.
The given maze does not contain border (like the red rectangle in the example pictures), but you could assume the border of the maze are all walls.
The maze contains at least 2 empty spaces, and both the width and height of the maze won't exceed 100.
     */

    private int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        return dfs(maze, start, destination);
    }

    private boolean dfs(int[][] maze, int[] start, int[] dst) {
        if (start[0] == dst[0] && start[1] == dst[1]) return true;
        if (maze[start[0]][start[1]] == 2) return false;

        maze[start[0]][start[1]] = 2;
        for (int[] dir : dirs) {
            int[] stop = keepGoing(maze, start, dir);
            if (stop[0] == start[0] && stop[1] == start[1]) continue;
            if (dfs(maze, stop, dst)) return true;
        }

        return false;
    }

    private boolean bfs(int[][] maze, int[] start, int[] dst) {
        final Queue<int[]> q = new LinkedList<>();
        q.offer(start);

        while (!q.isEmpty()) {
            int[] stop = q.poll();
            int x = stop[0], y = stop[1];

            maze[x][y] = 2;
            if (x == dst[0] && y == dst[1]) return true;

            for (int[] dir : dirs) {
                int[] next = keepGoing(maze, stop, dir);
                if (x == next[0] && y == next[1]) continue;
                if (maze[next[0]][next[1]] == 2) continue;

                q.offer(next);
            }
        }

        return false;
    }

    private int[] keepGoing(int[][] maze, int[] start, int[] dir) {
        final int m = maze.length, n = maze[0].length;
        int x = start[0] + dir[0], y = start[1] + dir[1];

        if (x < 0 || x >= m || y < 0 || y >= n || maze[x][y] == 1) return start;
        return keepGoing(maze, new int[]{x, y}, dir);
    }
}
