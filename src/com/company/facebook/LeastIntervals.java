package com.company.facebook;


import java.util.ArrayList;
import java.util.List;

public class LeastIntervals {

    public List<Interval> findLeast(List<Interval> intervals, Interval target) {
        final List<Interval> result = new ArrayList<>();
        intervals.sort((a, b) -> a.start - b.start);

        int currentReach = target.start, i = 0;
        while (i < intervals.size() && currentReach < target.end) {
            int maxReach = 0;
            Interval selected = null;
            // interval.start <= currenReach: they will have overlap
            while (i < intervals.size() && intervals.get(i).start <= currentReach) {
                Interval current = intervals.get(i);
                if (current.end > maxReach) {
                    // choose the one have possible to cover more overlap, and choose one
                    maxReach = current.end;
                    selected = current;
                }
                i++;
            }

            currentReach = maxReach;
            result.add(selected);
        }

        return currentReach >= target.end ? result : new ArrayList<>();
    }

    public static void main(String[] args) {
        LeastIntervals solution = new LeastIntervals();
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1, 2));
        intervals.add(new Interval(4, 7));
        intervals.add(new Interval(5, 10));
        intervals.add(new Interval(9, 13));
        intervals.add(new Interval(15, 17));

        Interval target = new Interval(6, 12);
        List<Interval> result = solution.findLeast(intervals, target);
        System.out.println("result = " + result);
    }
}
