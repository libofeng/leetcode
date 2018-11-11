package com.lintcode.stack;

import java.util.List;
import java.util.Stack;

public class No1116ExclusiveTimeOfFunctions {
    class Log {
        int id, time, nested;

        Log(int id, int time) {
            this.id = id;
            this.time = time;
        }
    }

    /**
     * @param n:    a integer
     * @param logs: a list of integers
     * @return: return a list of integers
     */
    public int[] exclusiveTime(int n, List<String> logs) {
        final Stack<Log> stack = new Stack<>();
        final int[] output = new int[n];

        for(String s : logs){
            final String[] data = s.split(":");
            int id = Integer.parseInt(data[0]), time = Integer.parseInt(data[2]);
            Log log = new Log(id, time);
            if("start".equals(data[1])) stack.push(log);
            else{
                Log end = log, start = stack.pop();

                int interval = end.time - start.time + 1;
                output[start.id] += interval - start.nested;
                if(!stack.isEmpty()) stack.peek().nested += interval;
            }
        }

        return output;
    }
}
