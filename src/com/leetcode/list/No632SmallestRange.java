package com.leetcode.list;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class No632SmallestRange {
    class Node {
        List<Integer> list;
        int index;

        Node(List<Integer> l, int idx) {
            list = l;
            index = idx;
        }
    }

    // https://leetcode.com/problems/smallest-range/discuss/104893/Java-Code-using-PriorityQueue.-similar-to-merge-k-array
    public int[] smallestRange(List<List<Integer>> nums) {
        final Queue<Node> q = new PriorityQueue<>((a, b) -> a.list.get(a.index) - b.list.get(b.index));

        int max = Integer.MIN_VALUE;
        for (List<Integer> list : nums) {
            q.offer(new Node(list, 0));
            max = Math.max(max, list.get(0));
        }

        int start = -1, end = -1, range = Integer.MAX_VALUE;
        while (q.size() == nums.size()) {
            Node node = q.poll();

            int val = node.list.get(node.index);
            if (max - val < range) {
                start = val;
                end = max;
                range = end - start;
            }

            if (node.index + 1 < node.list.size()) {
                node.index++;
                max = Math.max(max, node.list.get(node.index));
                q.offer(node);
            }
        }

        return new int[]{start, end};
    }
}
