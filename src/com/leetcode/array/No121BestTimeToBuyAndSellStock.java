package com.leetcode.array;

public class No121BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        if (prices.length == 0 || prices.length == 1) return 0;

        int min = prices[0], maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            maxProfit = Math.max(maxProfit, prices[i] - min);
            min = Math.min(min, prices[i]);
        }

        return maxProfit;
    }
}
