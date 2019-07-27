package com.leetcode.contest.biweekly.contest5;

import java.util.TreeMap;

public class No5034LargestUniqueNumber {
    public int largestUniqueNumber(int[] A) {
        final TreeMap<Integer, Integer> tm = new TreeMap<>();
        for (int n : A) tm.put(n, tm.getOrDefault(n, 0) + 1);

        Integer key = tm.lastKey();
        for (int i = 0; i < tm.size() - 1; i++) {
            if (tm.get(key) == 1) return key;
            key = tm.lowerKey(key);
        }

        return tm.get(key) == 1 ? key : -1;
    }
}
