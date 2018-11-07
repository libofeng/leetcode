package com.lintcode.tree;

public class No691RecoverBinarySearchTree {
    // reference: https://www.lintcode.com/problem/recover-binary-search-tree/note/152644


    /**
     * @param root: the given tree
     * @return: the tree after swapping
     */
    TreeNode p = null, q = null, pre = null;

    public TreeNode bstSwappedNode(TreeNode root) {
        inOrder(root);

        if (p != null) {
            int tmp = p.val;
            p.val = q.val;
            q.val = tmp;
        }

        return root;
    }

    private void inOrder(TreeNode root) {
        if (root == null) return;

        inOrder(root.left);

        if (pre != null && pre.val > root.val) {
            if (p == null) {
                p = pre;
                q = root;
            } else {
                q = root;
                return;
            }
        }
        pre = root;

        inOrder(root.right);
    }
}
