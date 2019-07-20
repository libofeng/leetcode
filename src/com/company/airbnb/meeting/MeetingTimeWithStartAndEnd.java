package com.company.airbnb.meeting;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MeetingTimeWithStartAndEnd {
    public static void main(String[] args) {
        MeetingTimeWithStartAndEnd sol = new MeetingTimeWithStartAndEnd();
        List<List<Interval>> intervals = new ArrayList<List<Interval>>() {{
            add(new ArrayList<Interval>() {{
                add(new Interval(1, 3));
                add(new Interval(6, 7));
            }});
            add(new ArrayList<Interval>() {{
                add(new Interval(2, 9));
            }});
            add(new ArrayList<Interval>() {{
                add(new Interval(2, 3));
                add(new Interval(9, 12));
            }});
        }};
        List<Interval> res = sol.getAvailableIntervals(intervals, 2);
        assert (2 == res.size());
        assert (4 == res.get(0).start);
        assert (6 == res.get(0).end);
        assert (7 == res.get(1).start);
        assert (9 == res.get(1).end);
    }

    public List<Interval> getAvailableIntervals(List<List<Interval>> intervals, int k) {
        final Map<Integer, Integer> tm = new TreeMap<>();
        for (List<Interval> intervalList : intervals) {
            for (Interval i : intervalList) {
                tm.put(i.start, tm.getOrDefault(i.start, 0) + 1);
                tm.put(i.end, tm.getOrDefault(i.end, 0) - 1);
            }
        }

        final int totalEmployee = intervals.size(), meetingEmployee = totalEmployee - k;
        final List<Interval> result = new ArrayList<>();
        int height = 0, start = Integer.MIN_VALUE;
        for (Map.Entry<Integer, Integer> e : tm.entrySet()) {
            height += e.getValue();

            if (e.getValue() < 0 && height == meetingEmployee) start = e.getKey();
            else if (height > meetingEmployee) {
                result.add(new Interval(start, e.getKey()));
            }
        }
        result.add(new Interval(start, Integer.MAX_VALUE));

        return result;
    }

    // see also:
    // 252 Meeting rooms
    // 253 Meeting rooms II
    // 759 Employee Free Time
    static class Interval {
        public int start;
        public int end;

        public Interval() {
            start = 0;
            end = 0;
        }

        public Interval(int s, int e) {
            start = s;
            end = e;
        }
    }
}
