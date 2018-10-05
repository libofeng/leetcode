package com.leetcode.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class No144BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        final List<Integer> R = new LinkedList<>();
        helper(root, R);

        return R;
    }

    private void helper(TreeNode root, List<Integer> R){
        if(root == null ) return;

        R.add(root.val);
        helper(root.left, R);
        helper(root.right, R);
    }

    public List<Integer> preorderTraversal2(TreeNode root) {
        final List<Integer> R = new LinkedList<>();
        final Stack<TreeNode> stack = new Stack<>();
        if(root!=null) stack.push(root);

        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            R.add(node.val);

            if(node.right != null) stack.push(node.right);
            if(node.left != null) stack.push(node.left);
        }


        return R;
    }

}
