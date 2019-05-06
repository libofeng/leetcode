package com.leetcode.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No354RussianDollEnvelopes {
    // Time: O(N^2), Space: O(N)
    public int maxEnvelopes(int[][] envelopes) {
        final int n = envelopes.length;
        if (n <= 1) return n;
        Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? (a[1] - b[1]) : (a[0] - b[0]));

        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int max = 1;
        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }

        return max;
    }

    // Time: O(NLogN), Space: O(N)
    public int maxEnvelopes2(int[][] envelopes) {
        final int n = envelopes.length;
        if (n <= 1) return n;
        Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? (b[1] - a[1]) : (a[0] - b[0]));

        final List<Integer> list = new ArrayList<>();
        for (int[] e : envelopes) {
            int h = e[1];
            int index = findIndex(list, h);
            if (index == list.size()) list.add(h);
            else list.set(index, h);
        }

        return list.size();
    }

    private int findIndex(List<Integer> list, int val) {
        int lo = 0, hi = list.size();
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (list.get(mid) < val) lo = mid + 1;
            else hi = mid;
        }

        return lo;
    }
}
