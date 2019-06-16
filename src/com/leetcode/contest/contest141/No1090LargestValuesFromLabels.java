package com.leetcode.contest.contest141;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class No1090LargestValuesFromLabels {
    public int largestValsFromLabels(int[] values, int[] labels, int num_wanted, int use_limit) {
        final Map<Integer, Integer> counter = new HashMap<>();
        final Queue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (int i = 0; i < values.length; i++) pq.offer(new int[]{values[i], i});

        int sum = 0, total = 0;
        while (total < num_wanted && !pq.isEmpty()) {
            int n = pq.peek()[0], label = labels[pq.poll()[1]], count = counter.getOrDefault(label, 0);
            if (count < use_limit) {
                sum += n;
                total++;
                counter.put(label, count + 1);
            }
        }

        return sum;
    }
}
