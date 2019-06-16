package com.leetcode.linesweep;

import java.util.*;

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

    // https://leetcode.com/problems/perfect-rectangle/discuss/87201/Might-be-the-simplest-O(n)-solution-only-count-cornersno-area-no-maxmin(with-comments)
    public boolean isRectangleCover2(int[][] rectangles) {
        Set<String> set = new HashSet<>();
        for (int[] rec : rectangles) {
            //b = bottom, l = left, r = right, t = top
            //create corners with type
            String bl = rec[0] + "," + rec[1] + "bl";
            String br = rec[2] + "," + rec[1] + "br";
            String tl = rec[0] + "," + rec[3] + "tl";
            String tr = rec[2] + "," + rec[3] + "tr";
            //if these corners already exist, return false
            if (!set.add(bl) || !set.add(br) || !set.add(tl) || !set.add(tr)) return false;
            //if these 4 corners and previously added corners form a line, remove them
            if (set.remove(rec[0] + "," + rec[1] + "tl")) set.remove(bl);
            else if (set.remove(rec[0] + "," + rec[1] + "br")) set.remove(bl);
            if (set.remove(rec[2] + "," + rec[1] + "bl")) set.remove(br);
            else if (set.remove(rec[2] + "," + rec[1] + "tr")) set.remove(br);
            if (set.remove(rec[0] + "," + rec[3] + "tr")) set.remove(tl);
            else if (set.remove(rec[0] + "," + rec[3] + "bl")) set.remove(tl);
            if (set.remove(rec[2] + "," + rec[3] + "tl")) set.remove(tr);
            else if (set.remove(rec[2] + "," + rec[3] + "br")) set.remove(tr);
        }
        //a perfect rectangle contains 4 corners
        return set.size() == 4;
    }

}
