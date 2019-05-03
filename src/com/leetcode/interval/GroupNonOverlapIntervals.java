package com.leetcode.interval;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GroupNonOverlapIntervals {
    // https://csacademy.com/contest/interview-archive/task/contained-intervals/

    List<List<Interval>> group(List<Interval> intervals) {
        final List<List<Interval>> result = new ArrayList<>();
        if (intervals.size() <= 1) {
            result.add(intervals);
            return result;
        }

        intervals.sort((a, b) -> a.end - b.end);

        Iterator<Interval> iterator = intervals.iterator();
        while (iterator.hasNext()) {
            Interval current = iterator.next();
            final List<Interval> list = new ArrayList<>();
            list.add(current);
            iterator.remove();

            while (iterator.hasNext()) {
                Interval next = iterator.next();
                if (next.start >= current.end) {
                    list.add(next);
                    current = next;
                    iterator.remove();
                }
            }

            result.add(list);
            iterator = intervals.iterator();
        }

        return result;
    }

    public static void main(String[] args) {
        GroupNonOverlapIntervals solution = new GroupNonOverlapIntervals();
        final List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1, 2)); // c
        intervals.add(new Interval(3, 6)); // d
        intervals.add(new Interval(7, 11)); // f
        intervals.add(new Interval(11, 14)); // j
        intervals.add(new Interval(1, 6)); // b
        intervals.add(new Interval(7, 11)); // g
        intervals.add(new Interval(11, 14)); // i
        intervals.add(new Interval(1, 2)); // a
        intervals.add(new Interval(3, 9)); // e
        intervals.add(new Interval(10, 14)); // h

        List<List<Interval>> result = solution.group(intervals);
        System.out.println("result = " + result);

        final List<Interval> intervals2 = new ArrayList<>();
        intervals2.add(new Interval(1, 20));
        intervals2.add(new Interval(3, 17));
        intervals2.add(new Interval(5, 15));
        intervals2.add(new Interval(7, 13));
        intervals2.add(new Interval(9, 11));

        List<List<Interval>> result2 = solution.group(intervals2);
        System.out.println("result2 = " + result2);
    }
}
