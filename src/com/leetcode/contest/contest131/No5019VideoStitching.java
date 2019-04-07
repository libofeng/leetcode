package com.leetcode.contest.contest131;

import java.util.Arrays;

public class No5019VideoStitching {
    public int videoStitching(int[][] clips, int T) {
        int count = 0, end = 0, nextEnd = 0;
        Arrays.sort(clips, (a, b) -> a[0] == b[0] ? (b[1] - a[1]) : (a[0] - b[0]));

        for (int[] clip : clips) {
            if (clip[0] > nextEnd) continue;

            if (clip[0] <= end) nextEnd = Math.max(nextEnd, clip[1]);
            else if (clip[1] > nextEnd) {
                count++;
                end = nextEnd;
                nextEnd = clip[1];
            }

            if (nextEnd >= T) break;
        }

        return nextEnd >= T ? (count + 1) : -1;
    }
}
