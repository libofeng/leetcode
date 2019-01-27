package com.leetcode.dp;

public class No309BestTimeToBuyAndSellStockWithCooldown {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;

        int[] buy = new int[prices.length], sell = new int[prices.length];
        buy[0] = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            buy[i] = Math.max(buy[i - 1], (i > 1 ? sell[i - 2] : 0) - prices[i]);
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
        }

        return sell[sell.length - 1];
    }
}
