package com.leetcode.array;

import java.util.HashSet;
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
}
