package com.leetcode.interval;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class No554BrickWall {

    public int leastBricks(List<List<Integer>> wall) {
        final TreeMap<Integer, Integer> tm = new TreeMap<>();
        for (List<Integer> row : wall) {
            int start = 0, end = 0;
            for (int w : row) {
                end = start + w;

                tm.put(start + 1, tm.getOrDefault(start + 1, 0) + 1);
                tm.put(end, tm.getOrDefault(end, 0) - 1);
                start = end;
            }
        }

        tm.remove(tm.lastKey());

        int min = Integer.MAX_VALUE, h = 0;
        for (int v : tm.values()) min = Math.min(min, (h += v));

        return min == Integer.MAX_VALUE ? wall.size() : min;

    }


    public int leastBricks2(List<List<Integer>> wall) {
        final Map<Integer, Integer> map = new HashMap<>();

        int max = 0;
        for (List<Integer> row : wall) {
            int len = 0;
            for (int i = 0; i < row.size() - 1; i++) {
                len += row.get(i);
                map.put(len, map.getOrDefault(len, 0) + 1);
                max = Math.max(max, map.get(len));
            }
        }

        return wall.size() - max;
    }
}