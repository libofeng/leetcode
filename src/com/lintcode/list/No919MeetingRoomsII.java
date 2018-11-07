package com.lintcode.list;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class No919MeetingRoomsII {
    /**
     * @param intervals: an array of meeting time intervals
     * @return: the minimum number of conference rooms required
     */
    public int minMeetingRooms(List<Interval> intervals) {
        intervals.sort(Comparator.comparingInt(o -> o.start));
        PriorityQueue<Interval> rooms = new PriorityQueue<>(Comparator.comparingInt(o -> o.end));
        rooms.add(intervals.get(0));

        for (int i = 1; i < intervals.size(); i++) {
            Interval interval = intervals.get(i);
            if (interval.start >= rooms.peek().end) rooms.poll();
            rooms.offer(interval);
        }

        return rooms.size();
    }
}
