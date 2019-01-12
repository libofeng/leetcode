package com.leetcode.interval;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class No699FallingSquares {
    // The squares divide the number line into many segments with different heights.
    // Therefore we can use a TreeMap to store the number line.
    // The key is the starting point of each segment and the value is the height of the segment.
    // and another key is the end a segment, the value is the height of after the segment ends.
    // For every new falling square (s, l), we update those segments between s and s + l.

    // this problem is similar to the sky line problem.

    public List<Integer> fallingSquares(int[][] positions) {
        final List<Integer> list = new ArrayList<>();
        final TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(0, 0);

        int maxH = 0;
        for (int[] p : positions) {
            int height = p[1], start = p[0], end = start + height;

            Integer key = map.floorKey(start), h = map.get(key);
            key = map.higherKey(key);
            while (key != null && key < end) {
                h = Math.max(h, map.get(key));
                key = map.higherKey(key);
            }
            h += height;
            maxH = Math.max(maxH, h);
            list.add(maxH);

            int tail = map.floorEntry(end).getValue();
            map.put(start, h);
            map.put(end, tail);

            key = map.higherKey(start);
            while (key != null && key < end) {
                map.remove(key);
                key = map.higherKey(key);
            }
        }

        return list;
    }
}
