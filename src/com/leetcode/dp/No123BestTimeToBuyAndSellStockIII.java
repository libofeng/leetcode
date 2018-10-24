package com.leetcode.dp;

public class No123BestTimeToBuyAndSellStockIII {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) return 0;
        final int n = prices.length;

        int maxProfit = 0;
        for (int k = 0; k < n; k++) {
            maxProfit = Math.max(maxProfit, maxProfit(prices, 0, k) + maxProfit(prices, k, n - 1));
        }

        return maxProfit;
    }

    private int maxProfit(int[] prices, int start, int end) {
        if (end == start) return 0;

        int min = prices[start], profit = 0;
        for (int i = start + 1; i <= end; i++) {
            profit = Math.max(profit, prices[i] - min);
            min = Math.min(min, prices[i]);
        }

        return profit;
    }

    public int maxProfit2(int[] prices) {
        if (prices.length <= 1) return 0;
        final int n = prices.length;
        final int[] f = new int[n], g = new int[n];

        int min = prices[0];
        for (int i = 1; i < n; i++) {
            f[i] = Math.max(f[i - 1], prices[i] - min);
            min = Math.min(min, prices[i]);
        }

        int max = prices[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            g[i] = Math.max(g[i + 1], max - prices[i]);
            max = Math.max(max, prices[i]);
        }

        int maxProfit = 0;
        for (int i = 0; i < n; i++) maxProfit = Math.max(maxProfit, f[i] + g[i]);

        return maxProfit;
    }


    // simplify version of 2
    public int maxProfit3(int[] prices) {
        if (prices.length <= 1) return 0;
        final int n = prices.length;
        final int[] f = new int[n];

        int min = prices[0];
        for (int i = 1; i < n; i++) {
            f[i] = Math.max(f[i - 1], prices[i] - min);
            min = Math.min(min, prices[i]);
        }

        int max = prices[n - 1], profit = 0, maxProfit = 0;
        for (int i = n - 2; i >= 0; i--) {
            profit = Math.max(profit, max - prices[i]);
            max = Math.max(max, prices[i]);

            maxProfit = Math.max(maxProfit, f[i] + profit);
        }

        return maxProfit;
    }
}
