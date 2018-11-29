package com.lintcode.list;

import java.util.LinkedList;
import java.util.List;

public class No30InsertInterval {
    /**
     * @param intervals:   Sorted interval list.
     * @param newInterval: new interval.
     * @return: A new interval list.
     */
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        final List<Interval> R = new LinkedList<>();

        Interval current = newInterval;
        for (Interval interval : intervals) {
            if (current.start > interval.end) R.add(interval);
            else if (current.end < interval.start) {
                R.add(current);
                current = interval;
            } else {
                current.start = Math.min(current.start, interval.start);
                current.end = Math.max(current.end, interval.end);
            }
        }

        R.add(current);
        return R;
    }
}
