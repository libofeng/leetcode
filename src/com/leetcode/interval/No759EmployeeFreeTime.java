package com.leetcode.interval;

import java.util.*;

public class No759EmployeeFreeTime {
    // http://www.cnblogs.com/grandyang/p/8552586.html
    public List<Interval> employeeFreeTime(List<List<Interval>> schedules) {
        List<Interval> list = new LinkedList<>(), freeList = new LinkedList<>();
        for (List<Interval> intervals : schedules) list.addAll(intervals);
        if (list.size() <= 1) return list;

        list.sort((a, b) -> a.start == b.start ? (a.end - b.end) : (a.start - b.start));

        Interval current = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            Interval interval = list.get(i);
            if (interval.start <= current.end) {
                current.start = Math.min(current.start, interval.start);
                current.end = Math.max(current.end, interval.end);
            } else {
                freeList.add(new Interval(current.end, interval.start));
                current = interval;
            }
        }

        return freeList;
    }

    public List<Interval> employeeFreeTime2(List<List<Interval>> schedules) {
        Map<Integer, Integer> map = new TreeMap<>();

        for (List<Interval> intervals : schedules) {
            for (Interval i : intervals) {
                map.put(i.start, map.getOrDefault(i.start, 0) + 1);
                map.put(i.end, map.getOrDefault(i.end, 0) - 1);
            }
        }

        int h = 0, start = 0;
        List<Interval> list = new LinkedList<>();
        for (int key : map.keySet()) {
            h += map.get(key);

            if (h == 0) start = key;
            else {
                if (start > 0) list.add(new Interval(start, key));
                start = 0;
            }
        }

        return list;
    }

    public static void main(String[] args) {
        No759EmployeeFreeTime solution = new No759EmployeeFreeTime();
        // test 1
        List<List<Interval>> schedules1 = new LinkedList<>();
        schedules1.add(Arrays.asList(new Interval(1, 2), new Interval(5, 6)));
        schedules1.add(Arrays.asList(new Interval(1, 3), new Interval(4, 10)));
        List<Interval> result1 = solution.employeeFreeTime2(schedules1);
        System.out.println("result1 = " + result1); // expected: [3, 4]

        // test2

        List<List<Interval>> schedules2 = new LinkedList<>();
        schedules2.add(Arrays.asList(new Interval(1, 3), new Interval(6, 7)));
        schedules2.add(Collections.singletonList(new Interval(2, 4)));
        schedules2.add(Arrays.asList(new Interval(2, 5), new Interval(9, 12)));
        List<Interval> result2 = solution.employeeFreeTime2(schedules2);
        System.out.println("result2 = " + result2); // expected: [5, 6], [7, 9[

    }
}
