package com.leetcode.math;

public class No492ConstructTheRectangle {
    public int[] constructRectangle(int area) {
        int w = (int) Math.sqrt(area);
        while ((area / w) * w != area) w--;
        return new int[]{area / w, w};
    }
}
