package com.leetcode.contest.contest134;

public class No1033MovingStonesUntilConsecutiveUser {
    public int[] numMovesStones(int a, int b, int c) {
        int max = Math.max(Math.max(a, b), c);
        int min = Math.min(Math.min(a, b), c);
        int mid = a + b + c - max - min;

        int maxMove = max - min - 2;
        int minMove = maxMove < 2 ? maxMove : ((mid - min <= 2 || max - mid <= 2) ? 1 : 2);
        return new int[]{minMove, maxMove};
    }
}
