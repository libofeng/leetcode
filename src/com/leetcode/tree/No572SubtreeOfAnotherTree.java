package com.leetcode.tree;

public class No572SubtreeOfAnotherTree {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        return s!=null && (t == null || isSame(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t));
    }

    private boolean isSame(TreeNode a, TreeNode b){
        if(a==null || b==null) return a == b;
        if(a.val != b.val) return false;

        return isSame(a.left, b.left) && isSame(a.right, b.right);
    }
}
