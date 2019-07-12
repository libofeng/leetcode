package com.leetcode.array;

public class No495TeemoAttacking {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int total = 0;
        for (int i = 0; i < timeSeries.length; i++) {
            if (i == 0) total += duration;
            else total += Math.min(timeSeries[i] - timeSeries[i - 1], duration);
        }

        return total;
    }
}
