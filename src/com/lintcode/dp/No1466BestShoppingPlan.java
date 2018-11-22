package com.lintcode.dp;

import java.util.ArrayList;
import java.util.List;

public class No1466BestShoppingPlan {
    /**
     * @param n:      The number of gift box
     * @param m:      The number of goods
     * @param k:      The money you have
     * @param val:    The value of each item
     * @param cost:   The cost of each item
     * @param belong: The item you need to buy before
     * @return: Return the max value.
     */
    public int getAns(int n, int m, int k, int[] val, int[] cost, int[] belong) {
        final List<List<Integer>> idxs = new ArrayList<>();
        final int[] total = new int[k + 1];
        final int[] current = new int[k + 1];
        int max = 0;

        // n gift boxes
        for (int i = 0; i < n; i++) idxs.add(new ArrayList<>());
        for (int i = n; i < belong.length; i++) idxs.get(belong[i]).add(i);

        for (int i = 0; i < n; i++) {
            System.arraycopy(total, 0, current, 0, k + 1);

            for (int j = 0; j < idxs.get(i).size(); j++) {
                int idx = idxs.get(i).get(j);
                for (int c = k; c >= cost[idx]; c--)
                    current[c] = Math.max(current[c], current[c - cost[idx]] + val[idx]);
            }

            for (int j = cost[i]; j <= k; j++) total[j] = Math.max(total[j], current[j - cost[i]] + val[i]);
        }

        for (int i = 0; i <= k; i++) max = Math.max(max, total[i]);

        return max;
    }
}
