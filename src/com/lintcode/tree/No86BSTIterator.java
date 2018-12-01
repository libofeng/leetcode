package com.lintcode.tree;

public class No86BSTIterator {
    private TreeNode root, current;

    /*
     * @param root: The root of binary tree.
     */
    public No86BSTIterator(TreeNode root) {
        if (root == null) return;
        this.root = root;

        current = root;
        while (current.left != null) current = current.left;
    }

    /*
     * @return: True if there has next node, or false
     */
    public boolean hasNext() {
        return current != null;
    }

    /*
     * @return: return next node
     */
    public TreeNode next() {
        TreeNode next = current;
        current = successor(current);
        return next;
    }

    private TreeNode successor(TreeNode node) {
        TreeNode successor = null, p = root;
        while (p != null) {
            if (p.val == node.val) break;
            if (node.val > p.val) p = p.right;
            else {
                successor = p;
                p = p.left;
            }
        }

        if (p == null) return null;
        if (p.right == null) return successor;

        p = p.right;
        while (p.left != null) p = p.left;
        return p;
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        root1.right = new TreeNode(2);
        No86BSTIterator solution1 = new No86BSTIterator(root1);
        while (solution1.hasNext()) System.out.println("solution1.next() = " + solution1.next().val);

        TreeNode root2 = new TreeNode(2);
        root2.left = new TreeNode(1);
        No86BSTIterator solution2 = new No86BSTIterator(root2);
        while (solution2.hasNext()) System.out.println("solution2.next() = " + solution2.next().val);
    }
}
