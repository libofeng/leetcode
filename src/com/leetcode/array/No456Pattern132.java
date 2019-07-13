package com.leetcode.array;

import java.util.ArrayDeque;
import java.util.Deque;

public class No456Pattern132 {
    public boolean find132pattern(int[] nums) {
        final Deque<int[]> stack = new ArrayDeque<>();

        for (int n : nums) {
            if (stack.isEmpty() || n < stack.peek()[0]) stack.push(new int[]{n, n});
            else if (n > stack.peek()[0]) {
                int[] p = stack.pop();
                if (n < p[1]) return true;

                p[1] = n;
                while (!stack.isEmpty() && n >= stack.peek()[1]) stack.pop();
                if (!stack.isEmpty() && n > stack.peek()[0]) return true;
                stack.push(p);
            }
        }

        return false;
    }
}
