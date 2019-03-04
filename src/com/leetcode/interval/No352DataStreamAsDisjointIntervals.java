package com.leetcode.interval;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class No352DataStreamAsDisjointIntervals {
    private final TreeMap<Integer, Interval> map;

    /**
     * Initialize your data structure here.
     */
    public No352DataStreamAsDisjointIntervals() {
        map = new TreeMap<>();
    }

    public void addNum(int val) {
        if (map.containsKey(val)) return;

        Integer lo = map.lowerKey(val), hi = map.higherKey(val);

        if (lo != null && hi != null && map.get(lo).end + 1 == val && hi == val + 1) {
            map.get(lo).end = map.get(hi).end;
            map.remove(hi);
        } else if (lo != null && map.get(lo).end >= val - 1) {
            map.get(lo).end = Math.max(map.get(lo).end, val);
        } else if (hi != null && hi == val + 1) {
            map.put(val, new Interval(val, map.get(hi).end));
            map.remove(hi);
        } else map.put(val, new Interval(val, val));
    }

    public List<Interval> getIntervals() {
        return new ArrayList<>(map.values());
    }
}
