package com.leetcode.array;

import java.util.*;

public class No228SummaryRangesUnsort {
    public List<String> summaryRanges(int[] nums) {
        final Set<Integer> set = new HashSet<>();
        for (int n : nums) set.add(n);

        final Map<Integer, String> treemap = new TreeMap<>();
        for (int n : nums) {
            if (!set.remove(n)) continue;

            int lo = n, hi = n;
            while (lo != Integer.MIN_VALUE && set.remove(lo - 1)) lo--;
            while (hi != Integer.MAX_VALUE && set.remove(hi + 1)) hi++;
            treemap.put(lo, buildRange(lo, hi));
        }

        return new ArrayList<>(treemap.values());
    }

    private String buildRange(int start, int end) {
        return start == end ? (start + "") : (start + "->" + end);
    }
}
