package com.leetcode.linesweep;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class No850RectangleAreaII {
    private static final int MOD = 1_000_000_007;

    // Time: O(N * NLogN), Space: O(N)
    public int rectangleArea(int[][] rectangles) {
        final int n = rectangles.length;
        List<Interval> intervals = new ArrayList<>();

        for (int[] line : rectangles) {
            intervals.add(new Interval(line[0], line[2], line[1], false));
            intervals.add(new Interval(line[0], line[2], line[3], true));
        }
        intervals.sort((a, b) -> a.y - b.y);

        long area = 0;
        int y = intervals.get(0).y;
        final List<Interval> actives = new ArrayList<>();
        for (Interval i : intervals) {
            int maxX = -1;
            long totalX = 0;
            for (Interval active : actives) {
                maxX = Math.max(maxX, active.start);
                totalX += Math.max(active.end - maxX, 0);
                maxX = Math.max(maxX, active.end);
            }

            area = (area + totalX * (i.y - y)) % MOD;
            y = i.y;

            if (i.closed) {
                Iterator<Interval> iterator = actives.iterator();
                // O(N)
                while (iterator.hasNext()) {
                    Interval current = iterator.next();
                    if (current.start == i.start && current.end == i.end) {
                        iterator.remove();
                        break;
                    }
                }
            } else {
                // O(NLogN)
                actives.add(i);
                actives.sort((a, b) -> a.start - b.start);
            }
        }

        return (int) area;
    }

    class Interval {
        int start, end, y;
        boolean closed;

        Interval(int s, int e, int y, boolean closed) {
            this.start = s;
            this.end = e;
            this.y = y;
            this.closed = closed;
        }
    }
}
