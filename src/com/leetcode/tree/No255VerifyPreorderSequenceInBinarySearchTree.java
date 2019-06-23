package com.leetcode.tree;

import java.util.Stack;

public class No255VerifyPreorderSequenceInBinarySearchTree {
    public boolean verifyPreorder(int[] preorder) {
        final Stack<Integer> stack = new Stack<>();
        int min = Integer.MIN_VALUE;

        for (int n : preorder) {
            if (n < min) return false;
            while (!stack.isEmpty() && n > stack.peek()) min = stack.pop();
            stack.push(n);
        }

        return true;
    }

    // use the input array as the stack
    public boolean verifyPreorder2(int[] preorder) {
        int min = Integer.MIN_VALUE, i = -1;

        for (int n : preorder) {
            if (n < min) return false;
            while (i >= 0 && n > preorder[i]) min = preorder[i--];
            preorder[++i] = n;
        }

        return true;
    }
}
