package com.leetcode.tree;

public class No536ConstructBinaryTreeFromString {
    public TreeNode str2tree(String s) {
        if (s == null || s.isEmpty()) return null;

        int index = s.indexOf("(");
        if (index < 0) return new TreeNode(Integer.parseInt(s));

        TreeNode node = new TreeNode(Integer.parseInt(s.substring(0, index)));
        int next = findPairEnd(s, index);
        node.left = str2tree(s.substring(index + 1, next));

        index = next + 1;
        if (index < s.length()) {
            next = findPairEnd(s, index);
            node.right = str2tree(s.substring(index + 1, next));
        }

        return node;
    }

    private int findPairEnd(String s, int start) {
        int left = 0;
        int i = start;
        for (; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') left++;
            else if (c == ')' && --left == 0) break;
        }

        return i;
    }
}
