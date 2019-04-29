package com.leetcode.string;

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
}
