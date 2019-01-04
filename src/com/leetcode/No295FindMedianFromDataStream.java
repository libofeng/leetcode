package com.leetcode;

import java.util.PriorityQueue;
import java.util.Queue;

public class No295FindMedianFromDataStream {
    /**
     * initialize your data structure here.
     */

    private PriorityQueue<Integer> left = new PriorityQueue<>();
    private PriorityQueue<Integer> right = new PriorityQueue<>();

    public No295FindMedianFromDataStream() {

    }

    public void addNum(int num) {
        right.offer(num);
        left.add(-right.poll());
        if (left.size() > right.size()) right.offer(-left.poll());
    }

    public double findMedian() {
        if (right.size() == left.size()) return (right.peek() - left.peek()) / 2.0D;
        else return right.peek();
    }

    public static void main(String[] args) {
        No295FindMedianFromDataStream solution = new No295FindMedianFromDataStream();
        solution.addNum(1);
        System.out.println("solution.findMedian() = " + solution.findMedian());
        solution.addNum(2);
        System.out.println("solution.findMedian() = " + solution.findMedian());
        solution.addNum(3);
        System.out.println("solution.findMedian() = " + solution.findMedian());
        solution.addNum(4);
        System.out.println("solution.findMedian() = " + solution.findMedian());
        solution.addNum(5);
        System.out.println("solution.findMedian() = " + solution.findMedian());
    }
}
