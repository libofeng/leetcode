package com.leetcode.interval;

import java.util.*;

public class No252MeetingRooms {
    public boolean canAttendMeetings(List<Interval> intervals) {
        if (intervals.size() <= 1) return true;
        intervals.sort((a, b) -> a.start - b.start);

        final Iterator<Interval> iterator = intervals.iterator();
        Interval current = iterator.next();

        while (iterator.hasNext()) {
            Interval next = iterator.next();
            if (next.start < current.end) return false;

            current = next;
        }

        return true;
    }


    public boolean canAttendMeetings2(List<Interval> intervals) {
        if (intervals.size() <= 1) return true;

        final List<int[]> list = new ArrayList<>();
        for (Interval i : intervals) {
            list.add(new int[]{i.start, 1});
            list.add(new int[]{i.end, -1});
        }
        list.sort((a, b) -> a[0] == b[0] ? (a[1] - b[1]) : (a[0] - b[0]));

        int h = 0;
        for (int[] p : list) if ((h += p[1]) > 1) return false;

        return true;
    }

    public boolean canAttendMeetings3(List<Interval> intervals) {
        if (intervals.size() <= 1) return true;

        final Map<Integer, Integer> tm = new TreeMap<>();
        for (Interval i : intervals) {
            tm.put(i.start, tm.getOrDefault(i.start, 0) + 1);
            tm.put(i.end, tm.getOrDefault(i.end, 0) - 1);
        }

        int h = 0;
        for (int v : tm.values()) if ((h += v) > 1) return false;

        return true;
    }
}
