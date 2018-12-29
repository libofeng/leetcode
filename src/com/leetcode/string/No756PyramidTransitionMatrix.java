package com.leetcode.string;

import java.util.*;

public class No756PyramidTransitionMatrix {
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        if (bottom.length() == 1) return true;

        Map<String, List<String>> map = new HashMap<>();
        for (String t : allowed) {
            String key = t.substring(0, 2);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(t.substring(2));
        }

        return helper(map, bottom);
    }

    private boolean helper(Map<String, List<String>> map, String bottom) {
        if (bottom.length() == 1) return true;

        List<String> upperLevel = new ArrayList<>();
        dfs(map, bottom, upperLevel, "", 0);
        for (String upper : upperLevel) if (helper(map, upper)) return true;

        return false;
    }

    private void dfs(Map<String, List<String>> map, String bottom, List<String> R, String path, int i) {
        if (i == bottom.length() - 1) {
            if (path.length() == bottom.length() - 1) R.add(path);
            return;
        }

        String ab = bottom.substring(i, i + 2);
        if (!map.containsKey(ab)) return;

        List<String> cList = map.get(ab);
        for (String c : cList) dfs(map, bottom, R, path + c, i + 1);
    }

    public static void main(String[] args) {
        No756PyramidTransitionMatrix solution = new No756PyramidTransitionMatrix();
        solution.pyramidTransition("ABC", Arrays.asList("ABD", "BCE", "DEF", "FFF"));
    }
}
