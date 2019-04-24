package com.leetcode.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class No532KDiffPairsinAnArray {

    public int findPairs(int[] nums, int k) {
        if (k < 0) return 0;

        final Set<Integer> set = new HashSet<>();
        final Set<String> pairs = new HashSet<>();

        for (int n : nums) {
            if (set.contains(n + k)) pairs.add(n + "," + (n + k));
            if (set.contains(n - k)) pairs.add((n - k) + "," + n);
            set.add(n);
        }

        return pairs.size();
    }


    public int findPairs2(int[] nums, int k) {
        if (k < 0) return 0;

        final Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) map.put(n, map.getOrDefault(n, 0) + 1);

        int count = 0;
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            if (k == 0) {
                if (e.getValue() > 1) count++;
            } else {
                if (map.containsKey(e.getKey() + k)) count++;
            }
        }

        return count;
    }
}
