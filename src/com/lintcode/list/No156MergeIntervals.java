package com.lintcode.list;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class No156MergeIntervals {

    /**
     * @param intervals: interval list.
     * @return: A new interval list.
     */
    public List<Interval> merge(List<Interval> intervals) {
        final List<Interval> R = new LinkedList<>();
        if (intervals.size() == 0) return R;
        Collections.sort(intervals, (o1, o2) -> o1.start - o2.start);

        Interval current = null;
        for (Interval interval : intervals) {
            if (current == null) current = interval;
            else {
                if (current.end < interval.start) {
                    R.add(current);
                    current = interval;
                } else if (current.start > interval.end) R.add(interval);
                else {
                    current.start = Math.min(current.start, interval.start);
                    current.end = Math.max(current.end, interval.end);
                }
            }
        }
        R.add(current);


        return R;
    }
}
