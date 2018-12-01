package com.lintcode.array;

import java.util.ArrayList;
import java.util.List;

public class No249CountOfSmallerNumberBeforeItSelfSegmentTree {

    class SegmentTreeNode {
        public int start, end, count;
        public SegmentTreeNode left, right;

        SegmentTreeNode(int start, int end, int count) {
            this.start = start;
            this.end = end;
            this.count = count;
        }
    }

    /**
     * @param A: an integer array
     * @return: A list of integers includes the index of the first number and the index of the last number
     */
    public List<Integer> countOfSmallerNumberII(int[] A) {
        // write your code here
        SegmentTreeNode root = build(0, 10000);
        List<Integer> res = new ArrayList<>();
        for (int num : A) {
            res.add(query(root, 0, num - 1));
            modify(root, num);
        }

        return res;
    }

    public int query(SegmentTreeNode root, int start, int end) {
        int rS = root.start;
        int rE = root.end;

        if (start > end || rE < start || end < rS) {
            return 0;
        } else if (start == rS && end == rE) {
            return root.count;
        } else {
            int mid = (rS + rE) / 2;
            int leftCount = query(root.left, Math.max(start, rS), Math.min(end, mid));
            int rightCount = query(root.right, Math.max(start, mid + 1), Math.min(end, rE));

            return leftCount + rightCount;
        }
    }

    public void modify(SegmentTreeNode root, int value) {
        int rS = root.start;
        int rE = root.end;

        if (rS == rE) {
            root.count++;
        } else {
            int mid = (rS + rE) / 2;
            if (value <= mid) {
                modify(root.left, value);
                root.count = root.left.count + root.right.count;
            } else {
                modify(root.right, value);
                root.count = root.left.count + root.right.count;
            }
        }
    }

    public SegmentTreeNode build(int start, int end) {
        if (start > end) {
            return null;
        }

        if (start == end) {
            return new SegmentTreeNode(start, end, 0);
        }

        int mid = (start + end) / 2;

        SegmentTreeNode node = new SegmentTreeNode(start, end, 0);
        SegmentTreeNode leftNode = build(start, mid);
        SegmentTreeNode rightNode = build(mid + 1, end);

        node.left = leftNode;
        node.right = rightNode;

        return node;
    }
}
