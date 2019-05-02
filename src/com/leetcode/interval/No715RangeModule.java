package com.leetcode.interval;

import java.util.*;

public class No715RangeModule {

    private TreeMap<Integer, Interval> tm = new TreeMap<>();

    public No715RangeModule() {

    }

    public void addRange(int left, int right) {
        final Iterator<Map.Entry<Integer, Interval>> iterator = tm.tailMap(left).entrySet().iterator();

        while (iterator.hasNext()) {
            Interval interval = iterator.next().getValue();
            if (interval.start > right) break;

            left = Math.min(left, interval.start);
            right = Math.max(right, interval.end);
            iterator.remove();
        }
        tm.put(right, new Interval(left, right));
    }

    public boolean queryRange(int left, int right) {
        Integer ceilingKey = tm.ceilingKey(right);
        return ceilingKey != null && tm.get(ceilingKey).start <= left;
    }

    public void removeRange(int left, int right) {
        final Iterator<Map.Entry<Integer, Interval>> iterator = tm.tailMap(left, false).entrySet().iterator();
        final List<Interval> todo = new ArrayList<>();

        while (iterator.hasNext()) {
            Interval interval = iterator.next().getValue();
            if (interval.start > right) break;

            if (interval.start < left) todo.add(new Interval(interval.start, left));
            if (interval.end > right) todo.add(new Interval(right, interval.end));

            iterator.remove();
        }

        for (Interval interval : todo) tm.put(interval.end, interval);
    }

    public static void main(String[] args) {
        No715RangeModule solution = new No715RangeModule();
        solution.addRange(10, 20);
        solution.removeRange(14, 16);

        boolean result;
        result = solution.queryRange(10, 14);
        System.out.println("result = " + result);
        result = solution.queryRange(13, 15);
        System.out.println("result = " + result);
        result = solution.queryRange(16, 17);
        System.out.println("result = " + result);
    }
}

/**
 * Your RangeModule object will be instantiated and called as such:
 * RangeModule obj = new RangeModule();
 * obj.addRange(left,right);
 * boolean param_2 = obj.queryRange(left,right);
 * obj.removeRange(left,right);
 */
