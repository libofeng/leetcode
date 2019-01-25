package com.leetcode.interval;

import java.util.ArrayList;
import java.util.List;

public class No57InsertInterval {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        final List<Interval> list = new ArrayList<>();

        Interval current = newInterval;
        for (Interval i : intervals) {
            if (current.end < i.start) {
                list.add(current);
                current = i;
            } else if (i.end < current.start) {
                list.add(i);
            } else {
                current.start = Math.min(current.start, i.start);
                current.end = Math.max(current.end, i.end);
            }
        }

        list.add(current);

        return list;
    }
}
