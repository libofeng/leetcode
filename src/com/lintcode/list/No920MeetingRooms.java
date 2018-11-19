package com.lintcode.list;

import java.util.*;

public class No920MeetingRooms {
    public boolean canAttendMeetings(List<Interval> intervals) {
        intervals.sort(Comparator.comparingInt(o -> o.start));

        Interval prev = null;
        for (Interval curr : intervals) {
            if (prev != null && curr.start < prev.end) return false;
            prev = curr;
        }

        return true;
    }

    // sweep line (TreeMap)
    public boolean canAttendMeetings2(List<Interval> intervals) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (Interval interval : intervals) {
            map.put(interval.start, map.getOrDefault(interval.start, 0) + 1);
            map.put(interval.end, map.getOrDefault(interval.end, 0) - 1);
        }

        int count = 0;
        for (Integer val : map.values()) if ((count = (count + val)) > 1) return false;

        return true;
    }

    class Point {
        int x, val;

        Point(int x, int val) {
            this.x = x;
            this.val = val;
        }
    }

    // sweep line (Point List)
    public boolean canAttendMeetings3(List<Interval> intervals) {
        List<Point> list = new LinkedList<>();
        for (Interval interval : intervals) {
            list.add(new Point(interval.start, 1));
            list.add(new Point(interval.end, -1));
        }
        list.sort(new Comparator<Point>() {
            public int compare(Point o1, Point o2) {
                if (o1.x == o2.x) {
                    return o1.val - o2.val;
                } else return o1.x - o2.x;
            }
        });

        int count = 0;
        for (Point p : list) if ((count = (count + p.val)) > 1) return false;

        return true;
    }
}
