package com.leetcode.linesweep;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class No850RectangleAreaII {
    private static final int MOD = 1_000_000_007;

    // Time: O(N * NLogN), Space: O(N)
    public int rectangleArea(int[][] rectangles) {
        final List<HorizontalLine> list = new ArrayList<>();
        for (int[] rect : rectangles) {
            list.add(new HorizontalLine(rect[0], rect[2], rect[1], false));
            list.add(new HorizontalLine(rect[0], rect[2], rect[3], true));
        }
        list.sort((a, b) -> a.y - b.y);

        long area = 0;
        int y = 0;
        final List<HorizontalLine> actives = new ArrayList<>();
        for (HorizontalLine l : list) {
            long totalX = 0;
            int maxX = -1;
            for (HorizontalLine active : actives) {
                maxX = Math.max(maxX, active.start);
                totalX += Math.max(0, active.end - maxX);
                maxX = Math.max(maxX, active.end);
            }

            area = (area + totalX * (l.y - y)) % MOD;
            y = l.y;

            if (l.closed) {
                // O(N)
                Iterator<HorizontalLine> iterator = actives.iterator();
                while (iterator.hasNext()) {
                    HorizontalLine a = iterator.next();
                    if (l.start == a.start && l.end == a.end) {
                        iterator.remove();
                        break;
                    }
                }
            } else {
                // O(NLogN)
                actives.add(l);
                actives.sort((a, b) -> a.start - b.start);
            }
        }

        return (int) area;
    }

    class HorizontalLine {
        int start, end, y;
        boolean closed;

        HorizontalLine(int start, int end, int y, boolean closed) {
            this.start = start;
            this.end = end;
            this.y = y;
            this.closed = closed;
        }
    }
}
