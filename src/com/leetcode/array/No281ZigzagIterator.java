package com.leetcode.array;

import java.util.*;

public class No281ZigzagIterator {
    /*
    Given two 1d vectors, implement an iterator to return their elements alternately.

    Example:

    Input:
    v1 = [1,2]
    v2 = [3,4,5,6]

    Output: [1,3,2,4,5,6]

    Explanation: By calling next repeatedly until hasNext returns false,
                 the order of elements returned by next should be: [1,3,2,4,5,6].
    Follow up: What if you are given k 1d vectors? How well can your code be extended to such cases?

    Clarification for the follow up question:
    The "Zigzag" order is not clearly defined and is ambiguous for k > 2 cases. If "Zigzag" does not look right to you, replace "Zigzag" with "Cyclic". For example:

    Input:
    [1,2,3]
    [4,5,6,7]
    [8,9]

    Output: [1,4,8,2,5,9,3,6,7].
     */

    class NumberList implements Comparable<NumberList> {
        int[] nums;
        int no;
        int index;

        NumberList(int no, int[] nums) {
            this.no = no;
            this.nums = nums;
        }

        @Override
        public int compareTo(NumberList that) {
            return this.index == that.index ? (this.no - that.no) : (this.index - that.index);
        }
    }

    List<Integer> getZigzagList(List<int[]> list) {
        final Queue<NumberList> pq = new PriorityQueue<>();
        final List<Integer> result = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) pq.offer(new NumberList(i, list.get(i)));

        while (!pq.isEmpty()) {
            NumberList nl = pq.poll();
            result.add(nl.nums[nl.index++]);
            if (nl.index < nl.nums.length) pq.offer(nl);
        }

        return result;
    }

    public static void main(String[] args) {
        No281ZigzagIterator solution = new No281ZigzagIterator();
        List<int[]> list = new ArrayList<>();
        list.add(new int[]{1, 2, 3});
        list.add(new int[]{4, 5, 6, 7});
        list.add(new int[]{8, 9});

        List<Integer> result = solution.getZigzagList(list);
        System.out.println("result = " + result);
    }
}
