package com.leetcode.array;

import java.util.PriorityQueue;

public class No378KthSmallestElementInASortedMatrix {
    // O(K * log(row))
    class Solution {
        public int kthSmallest(int[][] matrix, int k) {
            final int n = matrix.length;
            PriorityQueue<QueueNode> pq = new PriorityQueue<>();

            for (int i = 0; i < n; i++) pq.offer(new QueueNode(0, i, matrix[0][i]));
            for (int i = 0; i < k - 1; i++) {
                QueueNode node = pq.poll();
                if (node.x == n - 1) continue;
                pq.offer(new QueueNode(node.x + 1, node.y, matrix[node.x + 1][node.y]));
            }

            return pq.poll().v;
        }

        class QueueNode implements Comparable<QueueNode> {
            int x, y, v;

            QueueNode(int x, int y, int v) {
                this.x = x;
                this.y = y;
                this.v = v;
            }

            public int compareTo(QueueNode that) {
                return this.v - that.v;
            }
        }
    }

    public int kthSmallest2(int[][] matrix, int k) {
        final int n = matrix.length;
        int lo = matrix[0][0], hi = matrix[n - 1][n - 1];

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int count = 0, j = n - 1;
            for (int i = 0; i < n; i++) {
                while (j >= 0 && matrix[i][j] > mid) j--;
                count += j + 1;
            }

            if (count < k) lo = mid + 1;
            else hi = mid;
        }

        return lo;
    }
}
