package com.leetcode.contest.contest149;

import java.util.HashMap;
import java.util.Map;

public class No1157OnlineMajorityElementInSubarray2 {
    // Memory Limit Exceeded
    private Map<Integer, int[]> bits = new HashMap<>();

    public No1157OnlineMajorityElementInSubarray2(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            bits.putIfAbsent(arr[i], new int[arr.length + 1]);
            set(bits.get(arr[i]), i);
        }
    }

    public int query(int left, int right, int threshold) {
        for (Map.Entry<Integer, int[]> e : bits.entrySet()) {
            int count = query(e.getValue(), right) - query(e.getValue(), left - 1);
            if (count >= threshold) return e.getKey();
        }

        return -1;
    }

    private void set(int[] bit, int i) {
        for (i++; i < bit.length; i += (i & -i)) bit[i]++;
    }

    private int query(int[] bit, int i) {
        int count = 0;
        for (i++; i > 0; i -= (i & -i)) count += bit[i];
        return count;
    }
}
