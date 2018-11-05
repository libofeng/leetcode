package com.lintcode.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No602RussianDollEnvelopes {
    /*
     * @param envelopes: a number of envelopes with widths and heights
     * @return: the maximum number of envelopes
     */
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (A1, A2) -> {
            if (A1[0] == A2[0]) return A1[1] - A2[1];
            else return A1[0] - A2[0];
        });

        final int[] dp = new int[envelopes.length];
        Arrays.fill(dp, 1);

        int max = 1;
        for (int i = 1; i < dp.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (envelopes[i][0] > envelopes[j][0]
                        && (envelopes[i][1] > envelopes[j][1])) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }

        return max;
    }


    // https://www.cnblogs.com/grandyang/p/5568818.html
    public int maxEnvelopes2(int[][] envelopes) {
        Arrays.sort(envelopes, (A1, A2) -> {
            if (A1[0] == A2[0]) return A2[1] - A1[1];
            else return A1[0] - A2[0];
        });

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < envelopes.length; i++) {
            int index = findIndex(list, envelopes[i][1]);
            if (index == list.size()) list.add(envelopes[i][1]);
            else list.set(index, envelopes[i][1]);
        }

        return list.size();
    }

    private int findIndex(List<Integer> list, int h) {
        int l = 0, r = list.size();
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (list.get(mid) < h) l = mid + 1;
            else r = mid;
        }

        return l;
    }
}
