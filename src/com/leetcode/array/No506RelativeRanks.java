package com.leetcode.array;

import java.util.Map;
import java.util.TreeMap;

public class No506RelativeRanks {
    public String[] findRelativeRanks(int[] nums) {
        final String[] top3 = new String[]{"Gold Medal", "Silver Medal", "Bronze Medal"};
        final int n = nums.length;

        final TreeMap<Integer, Integer> tm = new TreeMap<>();
        for (int i = 0; i < n; i++) tm.put(nums[i], i);

        int index = n;
        final String[] ranks = new String[n];
        for (Map.Entry<Integer, Integer> e : tm.entrySet()) {
            ranks[e.getValue()] = index <= 3 ? top3[--index] : ("" + index--);
        }

        return ranks;
    }
}
