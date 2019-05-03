package com.leetcode.interval;

public class WeightedInterval extends Interval {
    int weight;

    WeightedInterval(int start, int end, int weight) {
        super(start, end);
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "[" + start + ", " + end + ", " + weight + "]";
    }
}
