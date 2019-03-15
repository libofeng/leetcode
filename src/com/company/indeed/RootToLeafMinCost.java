package com.company.indeed;

public class RootToLeafMinCost {
    class TreeNode {
        TreeNode left, right;
        int val, leftCost, rightCost;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    TreeNode minNode = null;
    int min = Integer.MAX_VALUE;

    TreeNode findTheMinPathLeaf(TreeNode root) {
        findTheMinPathLeaf(root, 0);
        return minNode;
    }

    private void findTheMinPathLeaf(TreeNode root, int cost) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            if (cost < min) {
                minNode = root;
                min = cost;
            }
            return;
        }

        findTheMinPathLeaf(root.left, cost + root.leftCost);
        findTheMinPathLeaf(root.right, cost + root.rightCost);
    }
}
