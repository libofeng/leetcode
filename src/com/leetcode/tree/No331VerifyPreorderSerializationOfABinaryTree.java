package com.leetcode.tree;

import java.util.Stack;

public class No331VerifyPreorderSerializationOfABinaryTree {
    // https://www.youtube.com/watch?v=_mbnPPHJmTQ
    // https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree/discuss/78551/7-lines-Easy-Java-Solution
    public boolean isValidSerialization(String preorder) {
        final String[] values = preorder.split(",");

        int outDegree = 1;
        for (String v : values) {
            if (--outDegree < 0) return false;
            if (!"#".equals(v)) outDegree += 2;
        }

        return outDegree == 0;
    }

    // https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree/discuss/78566/Java-intuitive-22ms-solution-with-stack
    public boolean isValidSerialization2(String preorder) {
        // using a stack, scan left to right
        // case 1: we see a number, just push it to the stack
        // case 2: we see #, check if the top of stack is also #
        // if so, pop #, pop the number in a while loop, until top of stack is not #
        // if not, push it to stack
        // in the end, check if stack size is 1, and stack top is #

        final String[] values = preorder.split(",");
        final Stack<String> stack = new Stack<>();

        for (String v : values) {
            while ("#".equals(v) && !stack.isEmpty() && "#".equals(stack.peek())) {
                stack.pop();
                if (stack.isEmpty()) return false;
                stack.pop();
            }
            stack.push(v);
        }

        return stack.size() == 1 && "#".equals(stack.pop());
    }
}
