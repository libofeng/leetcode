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

    public int videoStitching2(int[][] clips, int T) {
        final int n = clips.length, INF = 1 << 30;
        final int[] dp = new int[n];
        Arrays.sort(clips, (a, b) -> a[1] - b[1]);

        for (int i = 0; i < n; i++) {
            dp[i] = clips[i][0] == 0 ? 1 : INF;
            for (int j = i - 1; j >= 0; j--) if (clips[i][0] <= clips[j][1]) dp[i] = Math.min(dp[i], dp[j] + 1);
        }

        int min = INF;
        for (int i = 0; i < n; i++) if (clips[i][1] >= T) min = Math.min(min, dp[i]);
        return min == INF ? -1 : min;
    }
}
