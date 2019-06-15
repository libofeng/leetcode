package com.leetcode.random;

import java.util.Arrays;
import java.util.Random;
import java.util.TreeMap;

public class No497RandomPointInNonOverlappingRectangles {

    private TreeMap<Integer, Integer> tm = new TreeMap<>();
    private int total = 0;
    private Random rnd = new Random();
    private int[][] rects;

    public No497RandomPointInNonOverlappingRectangles(int[][] rects) {
        this.rects = rects;

        for (int i = 0; i < rects.length; i++) {
            int[] p = rects[i];
            int dx = p[2] - p[0] + 1, dy = p[3] - p[1] + 1;
            total += dx * dy;
            tm.put(total, i);
        }
    }

    public static void main(String[] args) {
        int[][] input = new int[][]{{-2, -2, -1, -1}, {1, 0, 3, 0}};
        No497RandomPointInNonOverlappingRectangles solution = new No497RandomPointInNonOverlappingRectangles(input);
        int[] point = solution.pick();
        System.out.println("Arrays.toString(point) = " + Arrays.toString(point));
    }

    public int[] pick() {
        int random = rnd.nextInt(total) + 1;
        Integer ceilingKey = tm.ceilingKey(random), lowerKey = tm.lowerKey(ceilingKey);
        int prevSum = lowerKey == null ? 0 : lowerKey;

        int[] p = rects[tm.get(ceilingKey)];
        int cols = p[2] - p[0] + 1, idx = random - prevSum - 1;

        return new int[]{p[0] + idx % cols, p[1] + idx / cols};
    }
}
