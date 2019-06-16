package com.leetcode.linesweep;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class No391PerfectRectangle {
    public static void main(String[] args) {
        No391PerfectRectangle solution = new No391PerfectRectangle();
        boolean result = solution.isRectangleCover(new int[][]{{1, 1, 3, 3}, {3, 1, 4, 2}, {3, 2, 4, 4}, {1, 3, 2, 4}, {2, 3, 3, 4}});
        System.out.println("result = " + result);
    }

    public boolean isRectangleCover(int[][] rectangles) {
        final List<HorizontalLine> list = new ArrayList<>();
        for (int[] rect : rectangles) {
            list.add(new HorizontalLine(rect[0], rect[2], rect[1], false));
            list.add(new HorizontalLine(rect[0], rect[2], rect[3], true));
        }
        list.sort((a, b) -> a.y - b.y);

        final List<HorizontalLine> actives = new ArrayList<>();
        int lastY = list.get(0).y, width = -1;
        for (HorizontalLine l : list) {
            if (l.y != lastY) {
                Iterator<HorizontalLine> iterator = actives.iterator();
                HorizontalLine current = iterator.next();
                int minStart = current.start, maxEnd = current.end;
                while (iterator.hasNext()) {
                    HorizontalLine next = iterator.next();
                    if (current.end != next.start) return false;

                    minStart = Math.min(minStart, next.start);
                    maxEnd = Math.max(maxEnd, next.end);
                    current = next;
                }

                if (width == -1) width = maxEnd - minStart;
                else if (width != maxEnd - minStart) return false;
            }

            if (l.closed) {
                Iterator<HorizontalLine> iterator = actives.iterator();
                while (iterator.hasNext()) {
                    HorizontalLine active = iterator.next();
                    if (l.start == active.start && l.end == active.end) {
                        iterator.remove();
                        break;
                    }
                }
            } else {
                actives.add(l);
                actives.sort((a, b) -> a.start - b.start);
            }

            lastY = l.y;
        }

        return true;
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
