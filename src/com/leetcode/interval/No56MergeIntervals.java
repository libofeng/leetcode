package com.leetcode.interval;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class No56MergeIntervals {
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals.isEmpty()) return intervals;

        final Comparator<Interval> comparator = new Comparator<Interval>() {
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        };
        intervals.sort(comparator);

        List<Interval> list = new ArrayList<>();
        Interval current = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++) {
            Interval interval = intervals.get(i);

            if (interval.start <= current.end) current.end = Math.max(current.end, interval.end);
            else {
                list.add(current);
                current = interval;
            }
        }
        list.add(current);

        return list;
    }
}
