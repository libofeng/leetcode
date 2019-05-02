package com.leetcode.interval;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ContainedIntervals {
    // https://csacademy.com/contest/interview-archive/task/contained-intervals/

    /*
    You should implement a function that takes as argument an array of NN intervals.
    For each interval ii you are given its end points (l, r)(l,r).
    We say that an interval ii is contained by another interval jj if l_j \leq l_il
    ​j
    ​​ ≤l
    ​i
    ​​  and r_i \leq r_jr
    ​i
    ​​ ≤r
    ​j
    ​​ . Return the number of intervals that are contained by at least one other interval.

    Desired solution
    This problem admits a variety of O(N\log N)O(NlogN) solutions. Can you find the simplest one?
     */

    int countContainedInterval(List<Interval> intervals) {
        int count = 0;
        if (intervals.size() <= 1) return count;

        intervals.sort((a, b) -> a.start == b.start ? (b.end - a.end) : (a.start - b.start));

        Iterator<Interval> iterator = intervals.iterator();
        Interval current = iterator.next();
        int maxEnd = -1;
        while (iterator.hasNext()) {
            Interval next = iterator.next();

            if ((current.start == next.start && current.end == next.end) || maxEnd >= current.end) count++;
            current = next;
            maxEnd = Math.max(maxEnd, current.end);
        }
        if (maxEnd >= current.end) count++;

        return count;
    }

    public static void main(String[] args) {
        ContainedIntervals solution = new ContainedIntervals();
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1, 6));
        intervals.add(new Interval(4, 6));
        intervals.add(new Interval(4, 10));
        intervals.add(new Interval(5, 6));
        intervals.add(new Interval(1, 3));
        int count = solution.countContainedInterval(intervals);
        System.out.println("count = " + count + ", expected: 3");

        intervals = new ArrayList<>();
        intervals.add(new Interval(1, 2));
        intervals.add(new Interval(1, 2));
        count = solution.countContainedInterval(intervals);
        System.out.println("count = " + count + ", expected: 2");
    }
}
