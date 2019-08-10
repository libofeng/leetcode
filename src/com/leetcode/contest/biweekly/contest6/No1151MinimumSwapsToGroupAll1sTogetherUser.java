package com.leetcode.contest.biweekly.contest6;

public class No1151MinimumSwapsToGroupAll1sTogetherUser {
    public int minSwaps(int[] data) {
        int windowSize = 0;
        for (int d : data) windowSize += d;

        int maxOnes = 0, ones = 0, start = -1;
        for (int i = 0; i < data.length; i++) {
            ones += data[i];
            maxOnes = Math.max(maxOnes, ones);

            if (i - start == windowSize) ones -= data[++start];
        }

        return windowSize - maxOnes;
    }
}
