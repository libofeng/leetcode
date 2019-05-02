package com.leetcode.interval;

import java.util.List;
import java.util.Stack;

public class No636ExclusiveTimeofFunctions {
    public int[] exclusiveTime(int n, List<String> logs) {
        final Stack<int[]> stack = new Stack<>();
        final int[] result = new int[n];

        for (String log : logs) {
            String[] token = log.split(":");
            int id = Integer.parseInt(token[0]), time = Integer.parseInt(token[2]);

            if ("end".equals(token[1])) {
                int start = stack.pop()[1], duration = time - start + 1;
                result[id] += duration;
                if (!stack.isEmpty()) result[stack.peek()[0]] -= duration;
            } else stack.push(new int[]{id, time});
        }

        return result;
    }
}
