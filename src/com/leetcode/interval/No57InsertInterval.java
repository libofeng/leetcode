package com.leetcode.interval;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class No57InsertInterval {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        Interval current = newInterval;

        final List<Interval> result = new ArrayList<>();
        for (Interval next : intervals) {
            if (current.end < next.start) {
                result.add(current);
                current = next;
            } else if (current.start > next.end) {
                result.add(next);
            } else {
                current.start = Math.min(current.start, next.start);
                current.end = Math.max(current.end, next.end);
            }
        }
        result.add(current);

        return result;
    }
}
