package com.leetcode.contest.contest136;

public class No1041RobotBoundedInCircle {

    // https://www.youtube.com/watch?v=wWDOAcWy0QY
    private int[][] dirs = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    public boolean isRobotBounded(String instructions) {
        int dir = 1;
        int[] position = new int[]{0, 0};

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < instructions.length(); j++) {
                char c = instructions.charAt(j);
                if (c == 'L') dir = (dir - 1 + 4) % 4;
                else if (c == 'R') dir = (dir + 1 + 4) % 4;
                else {
                    position[0] += dirs[dir][0];
                    position[1] += dirs[dir][1];
                }
            }
        }

        return dir != 1 || (position[0] == 0 && position[1] == 0);
    }
}
