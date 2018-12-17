package com.lintcode.stack;

import java.util.List;
import java.util.Stack;

public class No1116ExclusiveTimeOfFunctions {
    /**
     * @param n:    a integer
     * @param logs: a list of integers
     * @return: return a list of integers
     */
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<int[]> stack = new Stack<>();
        int[] R = new int[n];

        for (String log : logs) {
            String[] values = log.split(":");
            int id = Integer.parseInt(values[0]), time = Integer.parseInt(values[2]);
            if ("start".equals(values[1])) stack.push(new int[]{id, time});
            else {
                int[] logStart = stack.pop();
                int runTime = time - logStart[1] + 1;
                R[id] += runTime;
                if (!stack.isEmpty()) R[stack.peek()[0]] -= runTime;
            }
        }

        return R;
    }
}
