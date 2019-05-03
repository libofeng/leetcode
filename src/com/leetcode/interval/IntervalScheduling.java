package com.leetcode.interval;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IntervalScheduling {
    // similar to 435. Non-overlapping Intervals: remove fewest intervals to make it no overlap.

    List<Interval> filter(List<Interval> intervals) {
        if (intervals.size() <= 1) return intervals;
        intervals.sort((a, b) -> a.end - b.end);

        final List<Interval> result = new ArrayList<>();
        final Iterator<Interval> iterator = intervals.iterator();

        Interval current = iterator.next();
        result.add(current);
        while (iterator.hasNext()) {
            Interval next = iterator.next();
            if (next.start >= current.end) {
                current = next;
                result.add(current);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        IntervalScheduling solution = new IntervalScheduling();
        final List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(0, 10)); // 1
        intervals.add(new Interval(0, 20)); // 2
        intervals.add(new Interval(15, 35)); //3
        intervals.add(new Interval(30, 40)); // 4
        intervals.add(new Interval(45, 50)); // 5
        intervals.add(new Interval(0, 60)); // 6
        intervals.add(new Interval(48, 70)); // 7
        intervals.add(new Interval(75, 80)); // 8
        intervals.add(new Interval(72, 90)); // 9

        List<Interval> result = solution.filter(intervals);
        System.out.println("result = " + result);
    }
}
