package com.lintcode.tree;

import java.util.*;

public class No689TwoSumIVInputIsABST {
    /*
     * @param : the root of tree
     * @param : the target sum
     * @return: two numbers from tree which sum is n
     */

    // O(N * H)
    public int[] twoSum(TreeNode root, int n) {
        return inOrder(root, root, n);
    }

    private int[] inOrder(TreeNode root, TreeNode node, int n) {
        if (node == null) return null;

        int num = n - node.val;
        if (findNode(root, num)) return new int[]{node.val, num};

        int[] R = inOrder(root, node.left, n);
        if (R != null) return R;
        R = inOrder(root, node.right, n);

        return R;
    }

    private boolean findNode(TreeNode root, int val) {
        if (root == null) return false;
        if (root.val == val) return true;

        return val < root.val ? findNode(root.left, val) : findNode(root.right, val);
    }

    // ---------------------------------------------
    // Time complexity: O(NH), Space complexity: O(1)
    public int[] twoSum2(TreeNode root, int n) {
        if (root == null) return null;

        TreeNode left = min(root), right = max(root);
        while (left != right) {
            if (left.val + right.val == n) return new int[]{left.val, right.val};
            else if (left.val + right.val > n) right = predecessor(root, right);
            else left = successor(root, left);
        }

        return null;
    }

    private TreeNode successor(TreeNode root, TreeNode target) {
        TreeNode successor = null, p = root;
        while (p != null) {
            if (p == target) break;
            if (target.val > p.val) p = p.right;
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

    private TreeNode predecessor(TreeNode root, TreeNode target) {
        TreeNode predecessor = null, p = root;
        while (p != null) {
            if (p == target) break;
            if (target.val > p.val) {
                predecessor = p;
                p = p.right;
            } else p = p.left;
        }

        if (p == null) return null;
        if (p.left == null) return predecessor;
        p = p.left;
        while (p.right != null) p = p.right;

        return p;
    }

    private TreeNode max(TreeNode root) {
        while (root.right != null) root = root.right;

        return root;
    }

    private TreeNode min(TreeNode root) {
        while (root.left != null) root = root.left;

        return root;
    }

    // ---------------------------------------------


    class BSTIterator {
        Stack<TreeNode> stack;
        boolean forward;

        BSTIterator(TreeNode root, boolean forward) {
            this.stack = new Stack<>();
            this.forward = forward;

            fillStack(root);
        }

        boolean hasNext() {
            return !stack.isEmpty();
        }

        TreeNode next() {
            if (!hasNext()) return null;

            TreeNode node = stack.pop();
            fillStack(forward ? node.right : node.left);

            return node;
        }

        private void fillStack(TreeNode node) {
            while (node != null) {
                stack.push(node);
                node = forward ? node.left : node.right;
            }
        }
    }

    /*
     * @param : the root of tree
     * @param : the target sum
     * @return: two numbers from tree which sum is n
     */
    public int[] twoSum3(TreeNode root, int n) {
        final BSTIterator forward = new BSTIterator(root, true);
        final BSTIterator backward = new BSTIterator(root, false);

        TreeNode left = forward.next(), right = backward.next();
        while (left != right) {
            if (left.val + right.val == n) return new int[]{left.val, right.val};
            else if (left.val + right.val > n) right = backward.next();
            else left = forward.next();
        }

        return null;
    }

    // ---------------------------------------------

    // Time complexity: O(N + H), Space complexity: O(N)
    public int[] twoSum4(TreeNode root, int n) {
        List<TreeNode> list = new ArrayList<>();
        inOrder(root, list);

        int l = 0, r = list.size() - 1;
        while (l < r) {
            int left = list.get(l).val, right = list.get(r).val;
            if (left + right == n) return new int[]{left, right};
            else if (left + right > n) r--;
            else l++;
        }

        return null;
    }

    private void inOrder(TreeNode root, List<TreeNode> list) {
        if (root == null) return;

        inOrder(root.left, list);
        list.add(root);
        inOrder(root.right, list);
    }

    // ---------------------------------------------

    // Time complexity: O(N + H), Space complexity: O(N)
    public int[] twoSum5(TreeNode root, int n) {
        Set<Integer> visited = new HashSet<>();
        return inorder(root, visited, n);
    }

    private int[] inorder(TreeNode root, Set<Integer> visited, int sum) {
        if (root == null) return null;

        int[] R = inorder(root.left, visited, sum);
        if (R != null) return R;

        int n = sum - root.val;
        if (visited.contains(n)) return new int[]{n, root.val};
        visited.add(root.val);

        return inorder(root.right, visited, sum);
    }
}
