package com.company.indeed;

import java.util.*;

public class JobIdStorage {
    BitSet data = new BitSet((int) Math.pow(2, 64));

    List<Interval> intervals = new ArrayList<>();

    public void expire(long jobId) {
        if (intervals.size() == 0) {
            intervals.add(new Interval(jobId, jobId));
            return;
        }

        if (jobId < intervals.get(0).start) {
            intervals.add(0, new Interval(jobId, jobId));
        } else if (jobId > intervals.get(intervals.size() - 1).end) {
            intervals.add(new Interval(jobId, jobId));
        } else {
            for (int i = 0; i < intervals.size(); i++) {
                Interval cur = intervals.get(i);
                if (cur.start <= jobId && jobId <= cur.end) {
                    return;
                } else if (jobId > cur.end && jobId < intervals.get(i + 1).start) {
                    if (cur.end + 1 == jobId && jobId + 1 == intervals.get(i + 1).start) {
                        cur.end = intervals.get(i + 1).end;
                        intervals.remove(i + 1);
                    } else if (cur.end + 1 == jobId) {
                        cur.end = jobId;
                    } else if (jobId + 1 == intervals.get(i + 1).start) {
                        intervals.get(i + 1).start = jobId;
                    } else {
                        intervals.add(i + 1, new Interval(jobId, jobId));
                    }
                    return;
                }
            }
        }

    }

    public boolean isExpire(long jobId) {
        for (Interval i : intervals) {
            if (jobId >= i.start && jobId <= i.end)
                return true;
        }
        return false;
    }
}

class Interval {
    long start;
    long end;

    public Interval(long start, long end) {
        this.start = start;
        this.end = end;
    }
}
