package com.company.indeed;

import java.util.LinkedList;
import java.util.Queue;

/*

如果有duplicate的话，就不能用inorder+preorder了。

A String contains the following:

a char array— thus a separate object— containing the actual characters;
an integer offset into the array at which the string starts;
the length of the string;
another int for the cached calculation of the hash code.

 */
public class BinaryTreeToArray {
    class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }

    public int[] compressDenseTree(Node root) {
        if (root == null) return null;

        int height = getHeight(root);
        int[] res = new int[(int) Math.pow(2, height + 1)];

        Queue<Node> nodeQueue = new LinkedList<>();
        Queue<Integer> indexQueue = new LinkedList<>();
        nodeQueue.add(root);
        indexQueue.add(1);

        while (!nodeQueue.isEmpty()) {
            Node cur = nodeQueue.remove();
            int curIndex = indexQueue.remove();
            res[curIndex] = cur.val;
            if (cur.left != null) {
                nodeQueue.add(cur.left);
                indexQueue.add(2 * curIndex);
            }
            if (cur.right != null) {
                nodeQueue.add(cur.right);
                indexQueue.add(2 * curIndex + 1);
            }
        }
        return res;
    }


    private int getHeight(Node root) {
        if (root == null) return 0;

        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }
}
