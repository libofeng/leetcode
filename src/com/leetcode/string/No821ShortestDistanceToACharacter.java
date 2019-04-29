package com.leetcode.string;

import java.util.Arrays;
import java.util.TreeSet;

public class No821ShortestDistanceToACharacter {
    public int[] shortestToChar(String S, char C) {
        final TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < S.length(); i++) if (S.charAt(i) == C) set.add(i);

        final int[] result = new int[S.length()];
        for (int i = 0; i < S.length(); i++) {
            Integer floor = set.floor(i), ceiling = set.ceiling(i);

            if (floor != null && ceiling != null) result[i] = Math.min(i - floor, ceiling - i);
            else if (floor != null) result[i] = i - floor;
            else if (ceiling != null) result[i] = ceiling - i;
        }

        return result;
    }

    public int[] shortestToChar2(String S, char C) {
        final int n = S.length();
        final int[] result = new int[n];
        Arrays.fill(result, Integer.MAX_VALUE);

        int lastIndex = -1;
        for (int i = 0; i < n; i++) {
            if (S.charAt(i) == C) lastIndex = i;
            if (lastIndex >= 0) result[i] = i - lastIndex;
        }

        lastIndex = -1;
        for (int i = n - 1; i >= 0; i--) {
            if (S.charAt(i) == C) lastIndex = i;
            if (lastIndex >= 0) result[i] = Math.min(result[i], lastIndex - i);
        }

        return result;
    }
}
