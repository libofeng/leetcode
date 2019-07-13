package com.leetcode.tree;

public class No510InorderSuccessorInBSTII {
    public Node inorderSuccessor(Node x) {
        Node successor;
        if (x.right != null) {
            successor = x.right;
            while (successor.left != null) successor = successor.left;
        } else {
            Node parent = x.parent;
            while (parent != null && parent.left != x) {
                x = parent;
                parent = x.parent;
            }

            successor = parent;
        }

        return successor;
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node parent;
    }
}
