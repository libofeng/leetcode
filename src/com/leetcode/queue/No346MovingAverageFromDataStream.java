package com.leetcode.queue;

import java.util.LinkedList;
import java.util.Queue;

public class No346MovingAverageFromDataStream {
    /*
    Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.

    For example,
    MovingAverage m = new MovingAverage(3);
    m.next(1) = 1
    m.next(10) = (1 + 10) / 2
    m.next(3) = (1 + 10 + 3) / 3
    m.next(5) = (10 + 3 + 5) / 3

     */


    private Queue<Integer> queue;
    private final int SIZE;
    private long sum;

    /**
     * Initialize your data structure here.
     */
    public No346MovingAverageFromDataStream(int size) {
        queue = new LinkedList<>();
        SIZE = size;
        sum = 0;
    }

    public double next(int val) {
        if (queue.size() == SIZE) sum -= queue.poll();
        queue.offer(val);
        sum += val;

        return 1.0D * sum / queue.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
