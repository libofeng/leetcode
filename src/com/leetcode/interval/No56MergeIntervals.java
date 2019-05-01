package com.leetcode.interval;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class No56MergeIntervals {
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() <= 1) return intervals;
        intervals.sort((a, b) -> a.start - b.start);

        final List<Interval> result = new ArrayList<>();
        final Iterator<Interval> iterator = intervals.iterator();

        Interval current = iterator.next();
        while (iterator.hasNext()) {
            Interval next = iterator.next();

            if (next.start <= current.end) current.end = Math.max(current.end, next.end);
            else {
                result.add(current);
                current = next;
            }
        }
        result.add(current);

        return result;
    }
}
