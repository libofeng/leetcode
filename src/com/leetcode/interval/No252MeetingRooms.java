package com.leetcode.interval;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;

public class No252MeetingRooms {
    public boolean canAttendMeetings(List<Interval> intervals) {
        if (intervals.size() <= 1) return true;
        intervals.sort((a, b) -> a.start - b.start);

        Iterator<Interval> iterator = intervals.iterator();
        Interval current = iterator.next();
        while (iterator.hasNext()) {
            Interval i = iterator.next();
            if (i.start < current.end) return false;
            current = i;
        }

        return true;
    }


    public boolean canAttendMeetings2(List<Interval> intervals) {
        if (intervals.size() <= 1) return true;
        final List<int[]> points = new ArrayList<>();
        for (Interval i : intervals) {
            points.add(new int[]{i.start, 1});
            points.add(new int[]{i.end, -1});
        }
        points.sort((a, b) -> a[0] == b[0] ? (a[1] - b[1]) : (a[0] - b[0]));

        int count = 0;
        for (int[] p : points) {
            count += p[1];
            if (count > 1) return false;
        }

        return true;
    }

    public boolean canAttendMeetings3(List<Interval> intervals) {
        if (intervals.size() <= 1) return true;
        final TreeMap<Integer, Integer> map = new TreeMap<>();
        for (Interval i : intervals) {
            map.put(i.start, map.getOrDefault(i.start, 0) + 1);
            map.put(i.end, map.getOrDefault(i.end, 0) - 1);
        }

        int count = 0;
        for (int v : map.values()) {
            count += v;
            if (count > 1) return false;
        }

        return true;
    }
}
