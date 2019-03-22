package com.leetcode.array;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class No739DailyTemperatures {
    public int[] dailyTemperatures(int[] T) {
        final Stack<Integer> stack = new Stack<>();
        final Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < T.length; i++) {
            while (!stack.isEmpty() && T[stack.peek()] < T[i]) map.put(stack.pop(), i);
            stack.push(i);
        }

        final int[] result = new int[T.length];
        for (int i = 0; i < T.length; i++) if (map.containsKey(i)) result[i] = map.get(i) - i;

        return result;
    }
}
