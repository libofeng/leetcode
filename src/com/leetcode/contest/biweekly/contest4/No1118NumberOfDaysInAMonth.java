package com.leetcode.contest.biweekly.contest4;

public class No1118NumberOfDaysInAMonth {
    public int numberOfDays(int Y, int M) {
        final int[] days = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        return M == 2 && ((Y % 100 == 0 && Y % 400 == 0) || (Y % 100 != 0 && Y % 4 == 0)) ? 29 : days[M - 1];
    }
}
