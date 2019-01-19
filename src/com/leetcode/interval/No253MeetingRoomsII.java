package com.leetcode.interval;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class No253MeetingRoomsII {
    // Priority Queue
    public int minMeetingRooms(List<Interval> intervals) {
        intervals.sort((a, b) -> a.start - b.start);

        final PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (Interval i : intervals) {
            if (!pq.isEmpty() && i.start > pq.peek()) pq.poll();
            pq.offer(i.end);
        }

        return pq.size();
    }

    // SweepLine(sorted list)
    public int minMeetingRooms2(List<Interval> intervals) {
        List<int[]> points = new ArrayList<>();
        for (Interval i : intervals) {
            points.add(new int[]{i.start, 1});
            points.add(new int[]{i.end, -1});
        }

        points.sort((a, b) -> a[0] == b[0] ? (b[1] - a[1]) : (a[0] - b[0]));
        int maxCount = 0, count = 0;
        for (int[] p : points) {
            count += p[1];
            maxCount = Math.max(maxCount, count);
        }

        return maxCount;
    }

    // SweepLine(sorted map)
    public int minMeetingRooms3(List<Interval> intervals) {
        final TreeMap<Integer, Integer> map = new TreeMap<>();
        for (Interval i : intervals) {
            map.put(i.start, map.getOrDefault(i.start, 0) + 1);
            map.put(i.end + 1, map.getOrDefault(i.end + 1, 0) - 1);
        }

        int maxCount = 0, count = 0;
        for (int c : map.values()) {
            count += c;
            maxCount = Math.max(maxCount, count);
        }

        return maxCount;
    }
}