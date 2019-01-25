package com.leetcode.interval;

import java.util.List;
import java.util.Stack;

public class No636ExclusiveTimeofFunctions {
    public int[] exclusiveTime(int n, List<String> logs) {
        final Stack<int[]> stack = new Stack<>();

        int[] result = new int[n];
        for (String log : logs) {
            String[] data = log.split(":");
            boolean end = "end".equals(data[1]);
            int id = Integer.parseInt(data[0]), time = Integer.parseInt(data[2]);

            if (end) {
                int[] start = stack.pop();
                int consumed = time - start[1] + 1;

                result[id] += consumed;
                if (!stack.isEmpty()) result[stack.peek()[0]] -= consumed;
            } else stack.push(new int[]{id, time});
        }

        return result;
    }
}
