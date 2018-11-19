package com.lintcode.list;

import java.util.*;

public class No919MeetingRoomsII {
    /**
     * @param intervals: an array of meeting time intervals
     * @return: the minimum number of conference rooms required
     */
    public int minMeetingRooms(List<Interval> intervals) {
        intervals.sort(Comparator.comparingInt(o -> o.start));
        final PriorityQueue<Interval> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.end));

        for(Interval i : intervals){
            if(!pq.isEmpty() && i.start >= pq.peek().end) pq.poll();
            pq.offer(i);
        }

        return pq.size();
    }

    // Sweep Line
    public int minMeetingRooms2(List<Interval> intervals) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (Interval interval : intervals) {
            map.put(interval.start, map.getOrDefault(interval.start, 0) + 1);
            map.put(interval.end, map.getOrDefault(interval.end, 0) - 1);
        }

        int count = 0, max = 0;
        for (Integer val : map.values()) max = Math.max(max, count = (count + val));

        return max;
    }
}
