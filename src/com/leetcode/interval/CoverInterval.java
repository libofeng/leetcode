package com.leetcode.interval;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CoverInterval {
    /*
    给定一堆interval（如果我们管这个list叫IntervalList）， 和一个target interval
    我们的目标是去merge这些interval，让merge的结果能够『cover』这个target interval， 求这种merge所需的原interval的最少个数是多少

    有点抽象，举个栗子
    IntervalList: [-1, 9]  [ 1, 10] [ 0, 3] [ 9, 10] [ 3, 14] [ 2, 9] [10, 16]
    target interval: [ 2, 15]
    在这个栗子中，我们发现要想cover[2,15]有好几种方法，比如：
    [-1, 9]   + [ 9, 10] + [10, 16] 或者  [ 1, 10] + [10, 16]
    我们要的是merge个数最少的方法，所以这里应该返回2
     */

    int coverInterval(List<Interval> intervals, Interval target) {
        intervals.sort((a, b) -> a.start == b.start ? (b.end - a.end) : (a.start - b.start));

        int maxEnd = target.start, count = 0, i = 0;
        while (i < intervals.size() && maxEnd < target.end) {
            int nextMaxEnd = 0;
            while (i < intervals.size() && intervals.get(i).start <= maxEnd) {
                nextMaxEnd = Math.max(nextMaxEnd, intervals.get(i++).end);
            }
            maxEnd = nextMaxEnd;
            count++;
        }

        return maxEnd < target.end ? -1 : count;
    }

    public static void main(String[] args) {
        CoverInterval solution = new CoverInterval();
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(-1, 9));
        intervals.add(new Interval(1, 10));
        intervals.add(new Interval(0, 3));
        intervals.add(new Interval(9, 10));
        intervals.add(new Interval(3, 14));
        intervals.add(new Interval(2, 9));
        intervals.add(new Interval(10, 16));
        Interval target = new Interval(2, 15);

        int count = solution.coverInterval(intervals, target);
        System.out.println("count = " + count + ", expected: 2");
    }
}
