package com.lintcode.list;

import java.util.Comparator;
import java.util.List;

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
}
