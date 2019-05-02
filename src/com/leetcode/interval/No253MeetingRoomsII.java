package com.leetcode.interval;

import java.util.*;

public class No253MeetingRoomsII {
    // Priority Queue
    public int minMeetingRooms(List<Interval> intervals) {
        intervals.sort((a, b) -> a.start - b.start);

        final Queue<Integer> pq = new PriorityQueue<>();
        for (Interval next : intervals) {
            if (!pq.isEmpty() && next.start > pq.peek()) pq.poll();
            pq.offer(next.end);
        }

        return pq.size();
    }

    // SweepLine(sorted list)
    public int minMeetingRooms2(List<Interval> intervals) {
        final List<int[]> list = new ArrayList<>();
        for (Interval i : intervals) {
            list.add(new int[]{i.start, 1});
            list.add(new int[]{i.end, -1});
        }
        list.sort((a, b) -> a[0] == b[0] ? (a[1] - b[1]) : (a[0] - b[0]));

        int max = 0, h = 0;
        for (int[] p : list) max = Math.max(max, h += p[1]);

        return max;
    }

    // SweepLine(sorted map)
    public int minMeetingRooms3(List<Interval> intervals) {
        final Map<Integer, Integer> tm = new TreeMap<>();
        for (Interval i : intervals) {
            tm.put(i.start, tm.getOrDefault(i.start, 0) + 1);
            tm.put(i.end, tm.getOrDefault(i.end, 0) - 1);
        }

        int max = 0, h = 0;
        for (int v : tm.values()) max = Math.max(max, h += v);

        return max;
    }
}