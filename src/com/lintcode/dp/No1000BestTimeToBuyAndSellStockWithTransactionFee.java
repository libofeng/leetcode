package com.lintcode.dp;

public class No1000BestTimeToBuyAndSellStockWithTransactionFee {
    /**
     * @param prices: a list of integers
     * @param fee:    a integer
     * @return: return a integer
     */
    public int maxProfit(int[] prices, int fee) {
        if (prices == null || prices.length < 2) return 0;

        final int n = prices.length;
        final int[] sell = new int[n], buy = new int[n];
        sell[0] = 0;
        buy[0] = -prices[0];

        for (int i = 1; i < n; i++) {
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i] - fee);
            buy[i] = Math.max(buy[i - 1], sell[i - 1] - prices[i]);
        }

        return sell[n - 1];
    }


    /**
     * @param prices: a list of integers
     * @param fee:    a integer
     * @return: return a integer
     */
    public int maxProfit2(int[] prices, int fee) {
        int sell = 0;
        int own = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            sell = Math.max(sell, own + prices[i] - fee);
            own = Math.max(own, sell - prices[i]);
        }
        return sell;
    }
}
