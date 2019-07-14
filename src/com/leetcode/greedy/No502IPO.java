package com.leetcode.greedy;

import java.util.PriorityQueue;
import java.util.Queue;

public class No502IPO {
    // Time: O(NLogN), Space: O(N)
    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        final Queue<int[]> capQ = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        final Queue<int[]> proQ = new PriorityQueue<>((a, b) -> b[1] - a[1]);

        for (int i = 0; i < Capital.length; i++) capQ.offer(new int[]{Capital[i], Profits[i]});
        for (int i = 0; i < k; i++) {
            while (!capQ.isEmpty() && capQ.peek()[0] <= W) proQ.offer(capQ.poll());
            if (!proQ.isEmpty()) W += proQ.poll()[1];
        }

        return W;
    }


    public int findMaximizedCapital3(int k, int W, int[] Profits, int[] Capital) {
        if (Profits.length <= k) {     // no need to pick k projects
            for (int p : Profits) W += p;
            return W;
        }

        for (int i = 0; i < k; i++) {
            int maxIndex = -1, maxProfit = 0;
            for (int j = 0; j < Capital.length; j++) {
                if (W >= Capital[j] && Profits[j] > maxProfit) {
                    maxIndex = j;
                    maxProfit = Profits[j];
                }
            }
            if (maxIndex == -1) break;
            Profits[maxIndex] = -Profits[maxIndex];
            W += maxProfit;
        }

        return W;
    }
}
