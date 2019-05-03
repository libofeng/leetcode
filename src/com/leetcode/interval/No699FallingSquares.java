package com.leetcode.interval;

import java.util.*;

public class No699FallingSquares {
    // https://blog.csdn.net/u013007900/article/details/81065441

    class Interval {
        int start, end, height;

        Interval(int s, int e, int h) {
            start = s;
            end = e;
            height = h;
        }
    }

    // Time: O(N^2), Space: O(N)
    public List<Integer> fallingSquares(int[][] positions) {
        final List<Interval> intervals = new ArrayList<>();
        final List<Integer> result = new ArrayList<>();

        int maxHeight = 0;
        for (int[] p : positions) {
            Interval interval = new Interval(p[0], p[0] + p[1] - 1, p[1]);
            interval.height += findBaseHeight(intervals, interval);
            intervals.add(interval);

            maxHeight = Math.max(maxHeight, interval.height);
            result.add(maxHeight);
        }

        return result;
    }

    private int findBaseHeight(List<Interval> intervals, Interval interval) {
        int baseHeight = 0;
        for (Interval i : intervals) {
            if (i.end < interval.start || i.start > interval.end) continue;
            baseHeight = Math.max(baseHeight, i.height);
        }

        return baseHeight;
    }

    // Time: O(N^2), Space: O(N)
    public List<Integer> fallingSquares2(int[][] positions) {
        final TreeMap<Integer, Interval> intervals = new TreeMap<>();
        final List<Integer> result = new ArrayList<>();

        int maxHeight = 0;
        for (int[] p : positions) {
            Interval interval = new Interval(p[0], p[0] + p[1] - 1, p[1]);
            interval.height += findBaseHeight(intervals, interval);
            intervals.put(interval.end, interval);

            maxHeight = Math.max(maxHeight, interval.height);
            result.add(maxHeight);
        }

        return result;
    }

    private int findBaseHeight(TreeMap<Integer, Interval> intervals, Interval interval) {
        Iterator<Map.Entry<Integer, Interval>> iterator = intervals.tailMap(interval.start).entrySet().iterator();

        int baseHeight = 0;
        while (iterator.hasNext()) {
            Interval i = iterator.next().getValue();
            if (i.start > interval.end) break;

            baseHeight = Math.max(baseHeight, i.height);
        }

        return baseHeight;
    }


    // https://leetcode.com/problems/falling-squares/discuss/108775/Easy-Understood-TreeMap-Solution
    // The squares divide the number line into many segments with different heights.
    // Therefore we can use a TreeMap to store the number line.
    // The key is the starting point of each segment and the value is the height of the segment.
    // For every new falling square (s, l), we update those segments between s and s + l.

    public List<Integer> fallingSquares3(int[][] positions) {
        final TreeMap<Integer, Integer> tm = new TreeMap<>();
        final List<Integer> result = new ArrayList<>();
        tm.put(0, 0);

        int maxHeight = 0;
        for (int[] p : positions) {
            int start = p[0], h = p[1], end = start + h;
            int height = findBaseHeight(tm, start, end) + h;

            Integer floorKey = tm.floorKey(end);
            tm.put(start, height);
            tm.put(end, tm.get(floorKey));

            removeInnerKeys(tm, start, end);

            maxHeight = Math.max(maxHeight, height);
            result.add(maxHeight);
        }

        return result;
    }

    private int findBaseHeight(TreeMap<Integer, Integer> tm, int start, int end) {
        Integer nextKey = tm.floorKey(start);
        int height = 0;
        while (nextKey != null && nextKey < end) {
            height = Math.max(height, tm.get(nextKey));
            nextKey = tm.higherKey(nextKey);
        }

        return height;
    }

    private void removeInnerKeys(TreeMap<Integer, Integer> tm, int start, int end) {
        Integer nextKey = tm.higherKey(start);
        while (nextKey != null && nextKey < end) {
            tm.remove(nextKey);
            nextKey = tm.higherKey(nextKey);
        }
    }


    public static void main(String[] args) {
        No699FallingSquares solution = new No699FallingSquares();
        List<Integer> result = solution.fallingSquares2(new int[][]{{2, 82}, {57, 22}, {16, 66}, {46, 15}, {5, 11}, {9, 83}, {1, 32}, {87, 91}, {64, 61}, {87, 53}});
        System.out.println("result = " + result);

    }
}
