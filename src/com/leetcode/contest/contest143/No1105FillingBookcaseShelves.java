package com.leetcode.contest.contest143;

public class No1105FillingBookcaseShelves {
    public int minHeightShelves(int[][] books, int shelf_width) {
        int N = books.length;
        int[] dp = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            int totalWidth = 0, maxHeight = 0;
            dp[i] = Integer.MAX_VALUE;

            for (int j = i; j > 0; j--) {
                totalWidth += books[j - 1][0];
                if (totalWidth > shelf_width) break;

                maxHeight = Integer.max(maxHeight, books[j - 1][1]);
                dp[i] = Integer.min(dp[i], dp[j - 1] + maxHeight);
            }
        }
        return dp[N];
    }
}
