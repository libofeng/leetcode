package com.leetcode.string;

import java.util.*;

public class No756PyramidTransitionMatrix2 {
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        Map<String, List<Character>> map = new HashMap<>();
        for (String a : allowed) {
            String b = a.substring(0, 2);
            if (!map.containsKey(b)) map.put(b, new ArrayList<>());
            map.get(b).add(a.charAt(2));
        }
        return canStack(bottom + ' ', map);
    }

    boolean canStack(String s, Map<String, List<Character>> map) {
        if (s.length() == 1) return true;
        String ab = s.substring(0, 2);
        if (ab.charAt(1) == ' ') return canStack(s.substring(2) + ' ', map);
        if (!map.containsKey(ab)) return false;

        for (Character c : map.get(ab)) if (canStack(s.substring(1) + c, map)) return true;
        return false;
    }

    public static void main(String[] args) {
        No756PyramidTransitionMatrix2 solution = new No756PyramidTransitionMatrix2();
        solution.pyramidTransition("ABC", Arrays.asList("ABD", "BCE", "DEF", "FFF"));
    }
}
