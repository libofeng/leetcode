package com.leetcode;

import java.util.PriorityQueue;
import java.util.Queue;

public class No295FindMedianFromDataStream {
    // https://github.com/interviewdiscussion/files/blob/master/Facebook_java%2Bpdf/295.%20Find%20Median%20from%20Data%20Stream.java
    private Queue<Long> small = new PriorityQueue<>(), large = new PriorityQueue<>();

    public void addNum(int num) {
        large.add((long) num);
        small.add(-large.poll());//add O(n)
        if (large.size() < small.size())
            large.add(-small.poll());
    }

    public double findMedian() {
        return large.size() > small.size()
                ? large.peek()//O(1)
                : (large.peek() - small.peek()) / 2.0;
    }
}
