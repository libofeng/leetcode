package com.leetcode.string;

public class No657RobotReturnToOrigin {
    public boolean judgeCircle(String moves) {
        int v = 0, h = 0, len = moves.length();
        for (int i = 0; i < len; i++) {
            char c = moves.charAt(i);
            if (c == 'U') v++;
            else if (c == 'D') v--;
            else if (c == 'L') h--;
            else h++;
        }
        return v == 0 && h == 0;
    }
}
