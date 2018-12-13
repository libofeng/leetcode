package com.lintcode.tree;

import java.util.ArrayList;
import java.util.Stack;

public class AntiClockWiseTravel {

    private ArrayList<TreeNode> antiClockWiseNodeList = new ArrayList<TreeNode>();
    private TreeNode root;

    private void getLeftSizeNodes() {
        TreeNode node = root;
        while (node != null) {
            antiClockWiseNodeList.add(node);
            node = node.left;
        }
    }

    private void inorder(TreeNode node) {
        if (node == null) return;

        inorder(node.left);

        if (node.left == null && node.right == null) {
            if (antiClockWiseNodeList.get(antiClockWiseNodeList.size() - 1) != node) {
                antiClockWiseNodeList.add(node);
            }

            return;
        }

        inorder(node.right);
    }

    private void getBottomSizeNodes() {
        inorder(root);
    }

    private void getRightSizeNodes() {
        Stack<TreeNode> stack = new Stack<>();

        TreeNode node = root.right;
        while (node != null) {
            stack.push(node);
            node = node.right;
        }

        while (!stack.empty()) {
            TreeNode n = stack.pop();
            if (antiClockWiseNodeList.get(antiClockWiseNodeList.size() - 1) != n) {
                antiClockWiseNodeList.add(n);
            }
        }
    }

    public AntiClockWiseTravel(TreeNode root) {
        this.root = root;

        getLeftSizeNodes();
        getBottomSizeNodes();
        getRightSizeNodes();
    }

    public ArrayList<TreeNode> getAntiClockWiseNodes() {
        return antiClockWiseNodeList;
    }
}