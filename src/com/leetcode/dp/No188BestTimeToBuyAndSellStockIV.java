package com.leetcode.dp;

public class No188BestTimeToBuyAndSellStockIV {
    public int maxProfit(int k, int[] prices) {
        if (prices.length < 2 || k < 1) return 0;
        if (k >= prices.length) return maxProfit(prices);
        final int n = prices.length;

        final int[][] local = new int[n][k + 1], global = new int[n][k + 1];
        for (int i = 1; i < n; i++) {
            final int diff = prices[i] - prices[i - 1];
            for (int j = 1; j <= k; j++) {
                local[i][j] = Math.max(global[i - 1][j - 1] + Math.max(diff, 0), local[i - 1][j] + diff);
                global[i][j] = Math.max(global[i - 1][j], local[i][j]);
            }
        }

        return global[n - 1][k];
    }

    private int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) maxProfit += Math.max(0, prices[i] - prices[i - 1]);
        return maxProfit;
    }
}
