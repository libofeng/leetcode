package com.leetcode.tree;

public class No427ConstructQuadTree {
    public Node construct(int[][] grid) {
        return build(grid, 0, 0, grid.length);
    }

    private Node build(int[][] grid, int i, int j, int size) {
        if (size == 1) return new Node(grid[i][j] == 1, true, null, null, null, null);

        int h = size / 2;
        Node topLeft = build(grid, i, j, h), topRight = build(grid, i, j + h, h);
        Node bottomLeft = build(grid, i + h, j, h), bottomRight = build(grid, i + h, j + h, h);

        if (topLeft.val == topRight.val && bottomLeft.val == bottomRight.val && topLeft.val == bottomLeft.val
                && topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf) {
            return new Node(topLeft.val, true, null, null, null, null);
        }

        return new Node(false, false, topLeft, topRight, bottomLeft, bottomRight);
    }

    class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;

        public Node() {
        }

        public Node(boolean _val, boolean _isLeaf, Node _topLeft, Node _topRight, Node _bottomLeft, Node _bottomRight) {
            val = _val;
            isLeaf = _isLeaf;
            topLeft = _topLeft;
            topRight = _topRight;
            bottomLeft = _bottomLeft;
            bottomRight = _bottomRight;
        }
    }

    ;
}
