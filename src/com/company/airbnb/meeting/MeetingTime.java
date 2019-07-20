package com.company.airbnb.meeting;

import java.util.ArrayList;
import java.util.List;

public class MeetingTime {
    public static void main(String[] args) {
        MeetingTime sol = new MeetingTime();
        List<List<Interval>> intervals = new ArrayList<List<Interval>>() {{
            add(new ArrayList<Interval>() {{
                add(new Interval(1, 3));
                add(new Interval(6, 7));
            }});
            add(new ArrayList<Interval>() {{
                add(new Interval(2, 4));
            }});
            add(new ArrayList<Interval>() {{
                add(new Interval(2, 3));
                add(new Interval(9, 12));
            }});
        }};
        List<Interval> res = sol.getAvailableIntervals(intervals, 3);
        assert (2 == res.size());
        assert (4 == res.get(0).start);
        assert (6 == res.get(0).end);
        assert (7 == res.get(1).start);
        assert (9 == res.get(1).end);
    }

    public List<Interval> getAvailableIntervals(List<List<Interval>> intervals, int k) {
        final List<int[]> list = new ArrayList<>();
        for (List<Interval> intervalList : intervals) {
            for (Interval i : intervalList) {
                list.add(new int[]{i.start, 1});
                list.add(new int[]{i.end, -1});
            }
        }

        final int totalEmployee = intervals.size(), meetingEmployee = totalEmployee - k;
        list.sort((a, b) -> a[0] == b[0] ? (b[1] - a[1]) : (a[0] - b[0]));

        final List<Interval> result = new ArrayList<>();
        int height = 0, start = -1;
        for (int[] p : list) {
            height += p[1];
            if (p[1] < 0) {
                if (height == meetingEmployee) start = p[0];
            } else {
                if (height == meetingEmployee + 1 && start > 0) {
                    result.add(new Interval(start, p[0]));
                }
            }
        }

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
