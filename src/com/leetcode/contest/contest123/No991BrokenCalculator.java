package com.leetcode.contest.contest123;

public class No991BrokenCalculator {
    public int brokenCalc(int X, int Y) {
        int count = 0;
        while (Y > X) {
            Y = Y % 2 == 0 ? Y / 2 : (Y + 1);
            count++;
        }

        return count + (X - Y);
    }
}
